package com.example.productservice.controller;

import com.example.productservice.model.Product;
import com.example.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/")
    public String ShowProduct(Model model){
        List<Product> listProducts =productService.getProducts();
        model.addAttribute("listProducts",listProducts);
        return " ";
    }
    @GetMapping("/add")
    public String AddProduct(Model model){
        Product product = new Product();
        model.addAttribute("product",product);
        return "";
    }
    @PostMapping("/save")
    public String saveSanpham(@ModelAttribute("sanpham") Product product) {
        productService.saveProduct(product);
        return "";

    }
    @GetMapping("/deleteSanpham/{id}")
    public String deleteSanpham(@PathVariable (value = "id") int id){
        productService.deleteProduct(id);
        return "redirect:/listsp";
    }

}
