package com.literalura.controller;

import com.literalura.model.Libro;
import com.literalura.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping
    public List<Libro> getAllLibros() {
        return libroService.getAllLibros();
    }

    @PostMapping
    public void saveLibros(@RequestBody List<Libro> libros) {
        libroService.saveLibros(libros);
    }
}
