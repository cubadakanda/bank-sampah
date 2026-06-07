package com.example.demo.controller;

import com.example.demo.model.Transaksi;
import com.example.demo.model.User;
import com.example.demo.repository.TransaksiRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransaksiRepository transaksiRepository;

    @GetMapping("/dashboard")
    public String dashboard(Authentication authentication, Model model) {
        // Ambil username yang sedang login
        String username = authentication.getName();

        // Cari user berdasarkan username
        User user = userRepository.findByUsername(username).orElse(null);

        if (user != null && user.getWarga() != null) {
            // Ambil semua transaksi milik warga ini
            List<Transaksi> transaksiList = transaksiRepository
                    .findByWarga_IdWarga(user.getWarga().getIdWarga());
            model.addAttribute("transaksiList", transaksiList);
            model.addAttribute("namaWarga", user.getWarga().getNama());
        } else {
            model.addAttribute("transaksiList", List.of());
            model.addAttribute("namaWarga", username);
        }

        return "user/dashboard";
    }
}