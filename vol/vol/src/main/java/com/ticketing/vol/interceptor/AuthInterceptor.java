package com.ticketing.vol.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String path = request.getRequestURI();

        // Autoriser les accès à /admin/login et /admin/home
        if (path.equals("/admin/login") || path.equals("/admin/home")) {
            return true;
        }

        // Vérifier si la session contient un utilisateur
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/admin/home"); // Rediriger vers la page de connexion
            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
    }
}

