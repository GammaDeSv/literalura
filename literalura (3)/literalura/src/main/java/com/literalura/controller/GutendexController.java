package com.literalura.controller;

import com.literalura.model.Libro;
import com.literalura.service.GutendexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gutendex")
public class GutendexController {

    @Autowired
    private GutendexService gutendexService;

    @GetMapping("/search")
    public List<Libro> searchLibros(@RequestParam String query) {
        return gutendexService.searchAndSaveLibros(query);
    }

    @GetMapping("/buscar")
    public List<Libro> buscarLibros(@RequestParam String titulo) {
        return gutendexService.searchAndSaveLibros(titulo);
    }
}
