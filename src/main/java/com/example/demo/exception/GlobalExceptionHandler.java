package com.example.demo.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Global exception handler untuk menangani error di seluruh aplikasi.
 * Menerapkan konsep OOP: Exception Handling
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Menangani ResourceNotFoundException — data tidak ditemukan
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public String handleResourceNotFound(ResourceNotFoundException ex, Model model) {
        model.addAttribute("errorTitle", "Data Tidak Ditemukan");
        model.addAttribute("errorMessage", ex.getMessage());
        model.addAttribute("errorCode", "404");
        return "error";
    }

    /**
     * Menangani IllegalArgumentException — input tidak valid
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public String handleIllegalArgument(IllegalArgumentException ex, Model model) {
        model.addAttribute("errorTitle", "Input Tidak Valid");
        model.addAttribute("errorMessage", ex.getMessage());
        model.addAttribute("errorCode", "400");
        return "error";
    }

    /**
     * Menangani semua exception lain yang tidak tertangkap
     */
    @ExceptionHandler(Exception.class)
    public String handleGeneralException(Exception ex, Model model) {
        ex.printStackTrace(); // Cetak log di server
        model.addAttribute("errorTitle", "Terjadi Kesalahan");
        model.addAttribute("errorMessage", "Sistem mengalami gangguan: " + ex.getMessage());
        model.addAttribute("errorCode", "500");
        return "error";
    }
}
