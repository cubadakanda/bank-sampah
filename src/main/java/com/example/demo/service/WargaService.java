package com.example.demo.service;

import com.example.demo.model.Warga;
import com.example.demo.repository.WargaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service untuk Warga.
 * Menerapkan Inheritance: extends AbstractCrudService
 * Menerapkan Polymorphism: override getRepository() & getEntityName()
 */
@Service
public class WargaService extends AbstractCrudService<Warga, Long> {

    @Autowired
    private WargaRepository wargaRepository;

    @Override
    protected JpaRepository<Warga, Long> getRepository() {
        return wargaRepository;
    }

    @Override
    protected String getEntityName() {
        return "Warga";
    }

    // Method lama tetap dipertahankan untuk backward compatibility
    public List<Warga> getAll() { return findAll(); }
    public Optional<Warga> getById(Long id) { return wargaRepository.findById(id); }
    public Warga save(Warga warga) { return super.save(warga); }
    public void delete(Long id) { deleteById(id); }
}