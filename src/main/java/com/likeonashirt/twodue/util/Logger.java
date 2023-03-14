package com.likeonashirt.twodue.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import jakarta.servlet.http.HttpServletRequest;

public class Logger {
    private static final String LOG_FILE_PATH = "src/main/resources/META-INF/resources/var/log/TwoDue.log";

    public static void logTransaction(HttpServletRequest request) {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(LOG_FILE_PATH, true)))) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String timestamp = sdf.format(Calendar.getInstance().getTime());
            String remoteAddr = request.getRemoteAddr();
            String method = request.getMethod();
            String uri = request.getRequestURI();
            String queryString = request.getQueryString();
            String referer = request.getHeader("referer");
            String userAgent = request.getHeader("User-Agent");

            writer.println(timestamp + " " + remoteAddr + " " + method + " " + uri + (queryString != null ? "?" + queryString : "") + " " + referer + " " + userAgent);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void logRequestResponse(HttpServletRequest request, String response) {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(LOG_FILE_PATH, true)))) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String timestamp = sdf.format(Calendar.getInstance().getTime());
            String remoteAddr = request.getRemoteAddr();
            String method = request.getMethod();
            String uri = request.getRequestURI();
            String queryString = request.getQueryString();
            String referer = request.getHeader("referer");
            String userAgent = request.getHeader("User-Agent");

            writer.println(timestamp + " " + remoteAddr + " " + method + " " + uri + (queryString != null ? "?" + queryString : "") + " " + referer + " " + userAgent + "\n" + response);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
