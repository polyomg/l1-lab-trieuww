package com.example.lab5.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ParamService {
    private final HttpServletRequest request;

    public ParamService(HttpServletRequest request) {
        this.request = request;
    }

    public String getString(String name, String defaultValue) {
        String v = request.getParameter(name);
        return v != null ? v : defaultValue;
    }

    public int getInt(String name, int defaultValue) {
        try {
            String v = request.getParameter(name);
            return v != null ? Integer.parseInt(v) : defaultValue;
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public double getDouble(String name, double defaultValue) {
        try {
            String v = request.getParameter(name);
            return v != null ? Double.parseDouble(v) : defaultValue;
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public boolean getBoolean(String name, boolean defaultValue) {
        String v = request.getParameter(name);
        return v != null ? Boolean.parseBoolean(v) : defaultValue;
    }

    public Date getDate(String name, String pattern) {
        try {
            String v = request.getParameter(name);
            if (v == null) return null;
            return new SimpleDateFormat(pattern).parse(v);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public File save(MultipartFile file, String path) {
        try {
            if (file == null || file.isEmpty()) return null;
            String real = request.getServletContext().getRealPath(path);
            File dir = new File(real);
            if (!dir.exists()) dir.mkdirs();
            File saved = new File(dir, file.getOriginalFilename());
            file.transferTo(saved);
            return saved;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
