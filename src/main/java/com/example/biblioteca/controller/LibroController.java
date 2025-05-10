package com.example.biblioteca.controller;

import com.example.biblioteca.model.controller;
import com.example.biblioteca.service.LibroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation;

import java.util.list;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;
    
    @GetMapping
    private List<libro> listarLibros() {
        return libroService.getLibros();
    }
    @PostMapping
    public Libro agregarLibro(@RequestBody Libro libro){
        return LibroService.saveLibro(libro);
    }

    @GetMapping("{id}")
    public Libro buscarLibro(@PathVariable int id){
        return LibroService.saveLibro(id);
    }
    
    @PutMapping("{id}")
    public Libro actualizarLibro(@PathVariable int id, @RequestBody Libro libro){
        return LibroServiceupdateLibro(libro);
    }
    @DeleteMapping("{id}")
    public String elininarLibro(@PathVariable int id){
        return libroService.delete(id);
    }
}

