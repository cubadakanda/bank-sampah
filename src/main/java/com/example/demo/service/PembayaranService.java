package com.example.demo.service;

import com.example.demo.model.Pembayaran;
import com.example.demo.repository.PembayaranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service untuk Pembayaran.
 * Menerapkan Inheritance: extends AbstractCrudService
 * Menerapkan Polymorphism: override getRepository() & getEntityName()
 */
@Service
public class PembayaranService extends AbstractCrudService<Pembayaran, Long> {

    @Autowired
    private PembayaranRepository repo;

    @Override
    protected JpaRepository<Pembayaran, Long> getRepository() {
        return repo;
    }

    @Override
    protected String getEntityName() {
        return "Pembayaran";
    }

    // Method lama tetap dipertahankan untuk backward compatibility
    public List<Pembayaran> getAll() { return findAll(); }
    public Optional<Pembayaran> getById(Long id) { return repo.findById(id); }
    public Pembayaran save(Pembayaran p) { return super.save(p); }
    public void delete(Long id) { deleteById(id); }
}
