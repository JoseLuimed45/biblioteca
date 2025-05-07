package com.example.biblioteca.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.biblioteca.model.Libro;

@Repository
public class LibroRepository {

    //Arreglo que guardara todos los libros
    private List<Libro> listaLibros = new ArrayList<>();

    //Metodo que retorna todos los libros
    public List<Libro> obtenerLibros() {
        return listaLibros;
    }
    //Buscar libro por su id
    public Libro buscarPorId(int id) {
        for (Libro libro : listaLibros) {
            if (libro.getId() == id) {
                return libro;
            }
        }
        return null;
    }
    //Buscar libro por su ISBN
    public Libro buscarLibroPorIsbn(String isbn) {
        for (Libro libro : listaLibros) {
            if (libro.getIsbn().equals(isbn)){
                return libro;
            }
        }
        return null;
    }
    public Libro guardar(Libro lib) {
        listaLibros.add(lib);
        return lib;
    }
    public Libro actualizar(Libro lib) {
        int idPosicion = -1;

        for (int i = 0; i < listaLibros.size(); i ++) {
            if (listaLibros.get(i).getId() == lib.getId()) {
                idPosicion = i;
                break;
            }
        }
        if (idPosicion == -1) {
        Libro libro1 = new Libro();
        libro1.setId(lib.getId());
        libro1.setTitulo(lib.getTitulo());
        libro1.setAutor(lib.getAutor());
        libro1.setFechaPublicacion(lib.getFechaPublicacion());
        libro1.setEditorial(lib.getEditorial());
        libro1.setIsbn(lib.getIsbn());

        listaLibros.set(idPosicion, libro1);
        return libro1;
        }
        else {
            // Si no se encuentra el libro, se puede lanzar una excepción o manejarlo de otra manera
            System.out.println("Libro no encontrado");
    }

    return null;
    }
    public void eliminar(int id) {
        //Alternativa 1
        Libro libro = buscarPorId(id);
        if (libro != null) {
            listaLibros.remove(libro);
        }
}