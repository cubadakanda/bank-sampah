package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Abstract service generik sebagai base class untuk semua service.
 * Menerapkan konsep OOP:
 * - Abstract Class (tidak bisa diinstansiasi langsung)
 * - Inheritance (subclass mewarisi behavior CRUD)
 * - Polymorphism (getRepository() & getEntityName() di-override tiap subclass)
 *
 * @param <T>  Tipe entitas
 * @param <ID> Tipe primary key
 */
public abstract class AbstractCrudService<T, ID> implements ICrudService<T, ID> {

    /**
     * Abstract method — wajib di-override oleh subclass.
     * Polymorphism: setiap subclass mengembalikan repository-nya masing-masing.
     */
    protected abstract JpaRepository<T, ID> getRepository();

    /**
     * Abstract method — wajib di-override oleh subclass.
     * Mengembalikan nama entitas untuk pesan error.
     */
    protected abstract String getEntityName();

    @Override
    public T save(T entity) {
        if (entity == null) {
            throw new IllegalArgumentException(getEntityName() + " tidak boleh null");
        }
        return getRepository().save(entity);
    }

    @Override
    public List<T> findAll() {
        return getRepository().findAll();
    }

    @Override
    public T findById(ID id) {
        return getRepository().findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(getEntityName(), (Long) id));
    }

    @Override
    public void deleteById(ID id) {
        if (!getRepository().existsById(id)) {
            throw new ResourceNotFoundException(getEntityName(), (Long) id);
        }
        getRepository().deleteById(id);
    }
}
