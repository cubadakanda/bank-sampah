package com.example.demo.service;

import java.util.List;

/**
 * Interface generik untuk operasi CRUD dasar.
 * Menerapkan konsep OOP: Interface & Abstraksi
 *
 * @param <T>  Tipe entitas
 * @param <ID> Tipe primary key
 */
public interface ICrudService<T, ID> {

    /** Menyimpan atau memperbarui entitas */
    T save(T entity);

    /** Mengambil semua data entitas */
    List<T> findAll();

    /** Mengambil entitas berdasarkan ID, melempar exception jika tidak ada */
    T findById(ID id);

    /** Menghapus entitas berdasarkan ID */
    void deleteById(ID id);
}
