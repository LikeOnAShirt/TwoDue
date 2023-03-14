// Get the necessary DOM elements
const leftList = document.getElementById('left-list');
const rightList = document.getElementById('right-list');

// Create an array of dummy items for the left list
const leftItems = [
    { title: 'Task 1', description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.' },
    { title: 'Task 2', description: 'Nulla facilisi. Fusce vel diam mauris. ' },
    { title: 'Task 3', description: 'Phasellus dictum felis ut lacus fermentum, sit amet ornare ex bibendum.' },
    { title: 'Task 4', description: 'Maecenas nec dolor sapien. Sed ut nisl quam.' },
];

// Create an array of dummy items for the right list
const rightItems = [
    { title: 'Item 1', content: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.' },
    { title: 'Item 2', content: 'Nulla facilisi. Fusce vel diam mauris. ' },
    { title: 'Item 3', content: 'Phasellus dictum felis ut lacus fermentum, sit amet ornare ex bibendum.' },
    { title: 'Item 4', content: 'Maecenas nec dolor sapien. Sed ut nisl quam.' },
];

// Populate the left and right lists with the dummy items
populateList(leftList, leftItems);
populateList(rightList, rightItems);

// Add event listeners for drag-and-drop functionality in the left and right lists
leftList.addEventListener('dragstart', dragStart);
leftList.addEventListener('dragover', dragOver);
leftList.addEventListener('drop', drop);
rightList.addEventListener('dragstart', dragStart);
rightList.addEventListener('dragover', dragOver);
rightList.addEventListener('drop', drop);

// Add event listeners for up/down buttons in the left list
leftList.addEventListener('click', e => {
    if (e.target.matches('.up-button')) {
        const currentItem = e.target.closest('.list-item');
        const currentIndex = leftItems.findIndex(item => item.title === currentItem.dataset.title);
        const previousItem = currentItem.previousElementSibling;
        const previousIndex = leftItems.findIndex(item => item.title === previousItem.dataset.title);
        swapItems(leftItems, currentIndex, previousIndex);
        populateList(leftList, leftItems);
    }
    else if (e.target.matches('.down-button')) {
        const currentItem = e.target.closest('.list-item');
        const currentIndex = leftItems.findIndex(item => item.title === currentItem.dataset.title);
        const nextItem = currentItem.nextElementSibling;
        const nextIndex = leftItems.findIndex(item => item.title === nextItem.dataset.title);
        swapItems(leftItems, currentIndex, nextIndex);
        populateList(leftList, leftItems);
    }
});

// Add event listeners for collapsible headers in the right list
rightList.addEventListener('click', e => {
    if (e.target.matches('.collapsible-header')) {
        e.target.classList.toggle('active');
        const content = e.target.nextElementSibling;
        if (content.style.display === 'block') {
            content.style.display = 'none';
        }
        else {
            content.style.display = 'block';
        }
    }
});

// Function to populate a list with items
function populateList(list, items) {
    list.innerHTML = '';
    items.forEach(item => {
        const listItem = document.createElement('li');
        listItem.classList.add('list-item');
        listItem.dataset.title = item.title;
        listItem.draggable = true;

        const title = document.createElement('h3');
        title.classList.add(    'title');
        title.textContent = item.title;
        listItem.appendChild(title);

        if ('description' in item) {
            const description = document.createElement('p');
            description.classList.add('description');
            description.textContent = item.description;
            listItem.appendChild(description);
        }
        else if ('content' in item) {
            const collapsibleHeader = document.createElement('h3');
            collapsibleHeader.classList.add('collapsible-header');
            collapsibleHeader.textContent = item.title;
            listItem.appendChild(collapsibleHeader);

            const content = document.createElement('div');
            content.classList.add('collapsible-content');
            content.style.display = 'none';
            content.textContent = item.content;
            listItem.appendChild(content);
        }

        if (list === leftList) {
            const upButton = document.createElement('button');
            upButton.classList.add('up-button');
            upButton.innerHTML = '&#8593;';
            listItem.appendChild(upButton);

            const downButton = document.createElement('button');
            downButton.classList.add('down-button');
            downButton.innerHTML = '&#8595;';
            listItem.appendChild(downButton);
        }

        list.appendChild(listItem);
    });
}

// Function to swap two items in an array
function swapItems(array, index1, index2) {
    [array[index1], array[index2]] = [array[index2], array[index1]];
}

// Drag-and-drop functionality for the left and right lists
let draggedItem = null;

function dragStart(e) {
    draggedItem = e.target;
    setTimeout(() => draggedItem.style.display = 'none', 0);
}

function dragOver(e) {
    e.preventDefault();
}

function drop(e) {
    const targetItem = e.target.closest('.list-item');
    const sourceIndex = Array.from(this.children).indexOf(draggedItem);
    const targetIndex = Array.from(this.children).indexOf(targetItem);
    swapItems(leftItems, sourceIndex, targetIndex);
    swapItems(rightItems, sourceIndex, targetIndex);
    populateList(leftList, leftItems);
    populateList(rightList, rightItems);
    draggedItem.style.display = 'block';
}

// Functionality for adding new items to the left and right lists
const leftAddForm = document.getElementById('left-add-form');
const leftAddInput = document.getElementById('left-add-input');
const rightAddForm = document.getElementById('right-add-form');
const rightAddInput = document.getElementById('right-add-input');

leftAddForm.addEventListener('submit', e => {
    e.preventDefault();
    const newTitle = leftAddInput.value.trim();
    if (newTitle !== '') {
        leftItems.push({ title: newTitle });
        populateList(leftList, leftItems);
        leftAddInput.value = '';
    }
});

rightAddForm.addEventListener('submit', e => {
    e.preventDefault();
    const newTitle = rightAddInput.value.trim();
    if (newTitle !== '') {
        rightItems.push({ title: newTitle });
        populateList(rightList, rightItems);
        rightAddInput.value = '';
    }
});

