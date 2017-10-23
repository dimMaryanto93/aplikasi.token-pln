package com.tabeldata.pln.controller;

import com.tabeldata.pln.model.Pelanggan;
import com.tabeldata.pln.repository.PelangganRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/transaksi")
public class TransaksiController {

    @Autowired
    PelangganRepository pelangganRepository;

    @GetMapping("/beli")
    public String getRumahPelanggan(Authentication auth, Model model) {
        Pelanggan pelanggan = pelangganRepository.findByUsername(auth.getName());
        model.addAttribute("p", pelanggan);
        model.addAttribute("p", pelanggan);
        return "/transaksi/beli-token";
    }

}
