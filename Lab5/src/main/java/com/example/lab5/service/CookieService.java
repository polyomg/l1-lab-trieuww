package com.example.lab5.service;

import org.springframework.stereotype.Service;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class CookieService {
    private final HttpServletRequest request;
    private final HttpServletResponse response;

    public CookieService(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    public Cookie get(String name) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equalsIgnoreCase(name)) return c;
            }
        }
        return null;
    }

    public String getValue(String name) {
        Cookie c = get(name);
        return c != null ? c.getValue() : "";
    }

    public Cookie add(String name, String value, int hours) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(hours * 3600);
        cookie.setPath("/");
        response.addCookie(cookie);
        return cookie;
    }

    public void remove(String name) {
        Cookie cookie = new Cookie(name, "");
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
    }
}
