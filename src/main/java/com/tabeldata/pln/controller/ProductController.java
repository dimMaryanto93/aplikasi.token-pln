package com.tabeldata.pln.controller;

import com.tabeldata.pln.model.Product;
import com.tabeldata.pln.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/produk")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping({"/index", "/"})
    public String listProduct(Model model) {
        model.addAttribute("listProduct", productRepository.findAll());
        return "/produk/list";
    }

    @GetMapping("/new")
    public String newProduct(Product product, Model model) {
        model.addAttribute("p", product);
        return "/produk/new";
    }

    @PostMapping("/new")
    public String submitNewProduct(@ModelAttribute Product product) {
        productRepository.save(product);
        return "redirect:/produk/";
    }

    @GetMapping("/{kode}")
    public String productById(
            @PathVariable(name = "kode", required = true) Product product,
            Model model) {
        model.addAttribute("p", product);
        return "/produk/update-harga";
    }

    @PostMapping("/update")
    public String submitUpdatePrice(@ModelAttribute Product product) {
        productRepository.setHargaById(product.getHarga(), product.getId());
        return "redirect:/produk/";
    }
}
