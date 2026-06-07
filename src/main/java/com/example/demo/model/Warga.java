package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "warga")
public class Warga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idWarga;

    private String nama;
    private String alamat;
    private String noHp;

    @OneToMany(mappedBy = "warga", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaksi> transaksiList;

    @OneToOne(mappedBy = "warga", cascade = CascadeType.ALL, orphanRemoval = true)
    private User user;

    public Long getIdWarga() { return idWarga; }
    public void setIdWarga(Long idWarga) { this.idWarga = idWarga; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getAlamat() { return alamat; }
    public void setAlamat(String alamat) { this.alamat = alamat; }

    public String getNoHp() { return noHp; }
    public void setNoHp(String noHp) { this.noHp = noHp; }

    public List<Transaksi> getTransaksiList() { return transaksiList; }
    public void setTransaksiList(List<Transaksi> transaksiList) { this.transaksiList = transaksiList; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    /** Polymorphism: override toString() dari Object */
    @Override
    public String toString() {
        return "Warga{id=" + idWarga + ", nama='" + nama + "', noHp='" + noHp + "'}";
    }
}
