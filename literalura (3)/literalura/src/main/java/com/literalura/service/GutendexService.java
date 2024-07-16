package com.literalura.service;

import com.literalura.client.GutendexClient;
import com.literalura.model.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GutendexService {

    @Autowired
    private GutendexClient gutendexClient;

    @Autowired
    private LibroService libroService;

    public List<Libro> searchAndSaveLibros(String query) {
        if ("0".equals(query)) {
            System.exit(0); // Salir de la aplicación
        }

        List<Libro> libros = gutendexClient.fetchLibros(query);
        libroService.saveLibros(libros);
        return libros;
    }
}
