package com.example.demo.exception;

/**
 * Exception kustom untuk resource yang tidak ditemukan.
 * Menerapkan konsep OOP: Inheritance (extends RuntimeException)
 */
public class ResourceNotFoundException extends RuntimeException {

    private final String resourceName;
    private final Long resourceId;

    public ResourceNotFoundException(String message) {
        super(message);
        this.resourceName = "Unknown";
        this.resourceId = null;
    }

    public ResourceNotFoundException(String resourceName, Long id) {
        super(resourceName + " dengan ID " + id + " tidak ditemukan");
        this.resourceName = resourceName;
        this.resourceId = id;
    }

    public String getResourceName() {
        return resourceName;
    }

    public Long getResourceId() {
        return resourceId;
    }
}
