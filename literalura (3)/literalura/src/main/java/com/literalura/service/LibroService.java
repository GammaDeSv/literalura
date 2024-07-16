package com.literalura.service;

import com.literalura.model.Libro;
import com.literalura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    public List<Libro> getAllLibros() {
        return libroRepository.findAll();
    }

    public void saveLibros(List<Libro> libros) {
        libroRepository.saveAll(libros);
    }
}
