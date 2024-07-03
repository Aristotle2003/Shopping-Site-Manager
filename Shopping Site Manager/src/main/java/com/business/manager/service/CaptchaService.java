package com.business.manager.service;

import jakarta.servlet.http.HttpServletResponse;

public interface CaptchaService {
    void generateCaptcha(HttpServletResponse response);
}
