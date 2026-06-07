package com.example.demo.service;

import com.example.demo.model.KategoriSampah;
import com.example.demo.repository.KategoriSampahRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * Service untuk KategoriSampah.
 * Menerapkan Inheritance: extends AbstractCrudService
 * Menerapkan Polymorphism: override getRepository() & getEntityName()
 */
@Service
public class KategoriSampahService extends AbstractCrudService<KategoriSampah, Long> {

    @Autowired
    private KategoriSampahRepository repo;

    @Override
    protected JpaRepository<KategoriSampah, Long> getRepository() {
        return repo;
    }

    @Override
    protected String getEntityName() {
        return "KategoriSampah";
    }

    // Method lama tetap dipertahankan untuk backward compatibility
    public java.util.List<KategoriSampah> getAll() { return findAll(); }
    public java.util.Optional<KategoriSampah> getById(Long id) { return repo.findById(id); }
    public KategoriSampah save(KategoriSampah k) { return super.save(k); }
    public void delete(Long id) { deleteById(id); }
}
