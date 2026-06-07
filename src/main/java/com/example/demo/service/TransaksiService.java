package com.example.demo.service;

import com.example.demo.model.Transaksi;
import com.example.demo.repository.TransaksiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service untuk Transaksi.
 * Menerapkan Inheritance: extends AbstractCrudService
 * Menerapkan Polymorphism: override getRepository() & getEntityName()
 */
@Service
public class TransaksiService extends AbstractCrudService<Transaksi, Long> {

    @Autowired
    private TransaksiRepository repo;

    @Override
    protected JpaRepository<Transaksi, Long> getRepository() {
        return repo;
    }

    @Override
    protected String getEntityName() {
        return "Transaksi";
    }

    // Method lama tetap dipertahankan untuk backward compatibility
    public List<Transaksi> getAll() { return findAll(); }
    public Optional<Transaksi> getById(Long id) { return repo.findById(id); }
    public Transaksi save(Transaksi t) { return super.save(t); }
    public void delete(Long id) { deleteById(id); }
}
