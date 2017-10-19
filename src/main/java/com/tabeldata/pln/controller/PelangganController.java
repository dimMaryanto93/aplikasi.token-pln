package com.tabeldata.pln.controller;

import com.tabeldata.pln.model.Pelanggan;
import com.tabeldata.pln.model.RumahPelanggan;
import com.tabeldata.pln.repository.PelangganRepository;
import com.tabeldata.pln.repository.RumahPelangganRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Controller
@RequestMapping("/pelanggan")
public class PelangganController {

    private static Logger console = LoggerFactory.getLogger(PelangganController.class);
    @Autowired
    private PelangganRepository pelangganRepository;
    @Autowired
    private RumahPelangganRepository rumahPelangganRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping({"/baru", "/new"})
    public String pelangganBaru(Model model, Pelanggan pelanggan) {
        model.addAttribute("model", pelanggan);
        return "/pelanggan/new";
    }

    @PostMapping({"/new", "/baru"})
    public String submitPelanggan(@ModelAttribute Pelanggan pelanggan) {
        pelanggan.setPassword(passwordEncoder.encode(pelanggan.getNomorKtp()));
        pelanggan.setActive(false);
        this.pelangganRepository.save(pelanggan);
        return "redirect:/pelanggan/list";
    }

    @GetMapping({"/", "/list"})
    public String listPelanggan(Model model) {
        model.addAttribute("listPelanggan", pelangganRepository.findAll());
        return "/pelanggan/list";
    }

    @GetMapping("/rumah/{idPelanggan}")
    public String registrasiRumanPelanggan(
            @PathVariable(name = "idPelanggan", required = true) Pelanggan pelanggan,
            Model model,
            RumahPelanggan rumahPelanggan) {
        rumahPelanggan.setPelanggan(pelanggan);
        console.info(rumahPelanggan.toString());
        model.addAttribute("rumah", rumahPelanggan);
        return "/rumah/registrasi";
    }

    @PostMapping("/rumah/registrasi")
    public String submitRegistrasiRumah(@ModelAttribute RumahPelanggan rumahPelanggan) {
        rumahPelanggan.setSaldoToken(BigDecimal.ZERO);
        rumahPelangganRepository.save(rumahPelanggan);
        return "redirect:/pelanggan/list";
    }

}
