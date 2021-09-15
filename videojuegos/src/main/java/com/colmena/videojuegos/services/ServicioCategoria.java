package com.colmena.videojuegos.services;

import com.colmena.videojuegos.entities.Categoria;
import com.colmena.videojuegos.repositories.RepositorioCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioCategoria implements ServicioBase<Categoria> {
    @Autowired
    private RepositorioCategoria repositorio;

    @Override
    @Transactional
    public List<Categoria> findAll() throws Exception {
        try {
            List<Categoria> categorias = this.repositorio.findAll();
            return categorias;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Categoria findById(long id) throws Exception {
        try {
            Optional<Categoria> opt = this.repositorio.findById(id);
            return opt.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Categoria saveOne(Categoria entity) throws Exception {
        try {
            Categoria categoria = this.repositorio.save(entity);
            return categoria;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Categoria updateOne(Categoria entity, long id) throws Exception {
        try {
            Optional<Categoria> opt = this.repositorio.findById(id);
            Categoria categoria = opt.get();
            categoria = this.repositorio.save(entity);
            return categoria;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean deleteById(long id) throws Exception {
        try {
            Optional<Categoria> opt = this.repositorio.findById(id);
            if (!opt.isEmpty()) {
                Categoria categoria = opt.get();
                categoria.setActivo(!categoria.isActivo());
                this.repositorio.save(categoria);
            } else {
                throw new Exception();
            }
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
