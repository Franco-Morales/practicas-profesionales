package com.colmena.videojuegos.services;

import com.colmena.videojuegos.entities.Videojuego;
import com.colmena.videojuegos.repositories.RepositorioVideojuego;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioVideojuego implements ServicioBase<Videojuego>{
    @Autowired
    private RepositorioVideojuego repositorio;

    @Override
    @Transactional
    public List<Videojuego> findAll() throws Exception {
        try {
            List<Videojuego> entities = this.repositorio.findAll();
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Videojuego findById(long id) throws Exception {
        try {
            Optional<Videojuego> opt = this.repositorio.findById(id);
            return opt.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Videojuego saveOne(Videojuego entity) throws Exception {
        try {
            Videojuego videojuego = this.repositorio.save(entity);
            return videojuego;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Videojuego updateOne(Videojuego entity, long id) throws Exception {
        try {
            Optional<Videojuego> opt = this.repositorio.findById(id);
            Videojuego videojuego = opt.get();
            videojuego = this.repositorio.save(entity);
            return videojuego;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean deleteById(long id) throws Exception {
        try {
            Optional<Videojuego> opt = this.repositorio.findById(id);
            if (!opt.isEmpty()) {
                Videojuego videojuego = opt.get();
                videojuego.setActivo(!videojuego.isActivo());
                this.repositorio.save(videojuego);
            } else {
                throw new Exception();
            }
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /*   Metodos nuevos   */

    @Transactional
    public List<Videojuego> findAllByActivo() throws Exception{
        try {
            List<Videojuego> entities = this.repositorio.findAllByActivo();
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Videojuego findByIdAndActivo(long id) throws Exception {
        try {
            Optional<Videojuego> opt = this.repositorio.findByIdAndActivo(id);
            return opt.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public List<Videojuego> findByTitle(String q) throws Exception{
        try{
            List<Videojuego> entities = this.repositorio.findByTitle(q);
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
