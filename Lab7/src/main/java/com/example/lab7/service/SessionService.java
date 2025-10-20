package com.example.lab7.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpSession;

@Service
public class SessionService {
    private HttpSession session() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return attr.getRequest().getSession(true);
    }

    public <T> void set(String name, T value) {
        session().setAttribute(name, value);
    }

    @SuppressWarnings("unchecked")
    public <T> T get(String name, T defaultValue) {
        Object v = session().getAttribute(name);
        return v == null ? defaultValue : (T) v;
    }
}
