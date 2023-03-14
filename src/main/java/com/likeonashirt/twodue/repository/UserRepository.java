package com.likeonashirt.twodue.repository;

import com.likeonashirt.twodue.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

}
