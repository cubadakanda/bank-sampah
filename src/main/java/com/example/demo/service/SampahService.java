package com.example.demo.service;

import com.example.demo.model.Sampah;
import com.example.demo.repository.SampahRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service untuk Sampah.
 * Menerapkan Inheritance: extends AbstractCrudService
 * Menerapkan Polymorphism: override getRepository() & getEntityName()
 */
@Service
public class SampahService extends AbstractCrudService<Sampah, Long> {

    @Autowired
    private SampahRepository repo;

    @Override
    protected JpaRepository<Sampah, Long> getRepository() {
        return repo;
    }

    @Override
    protected String getEntityName() {
        return "Sampah";
    }

    // Method lama tetap dipertahankan untuk backward compatibility
    public List<Sampah> getAll() { return findAll(); }
    public Optional<Sampah> getById(Long id) { return repo.findById(id); }
    public Sampah save(Sampah s) { return super.save(s); }
    public void delete(Long id) { deleteById(id); }
}
