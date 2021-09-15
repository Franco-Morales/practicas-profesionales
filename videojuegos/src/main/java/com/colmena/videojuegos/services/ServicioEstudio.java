package com.colmena.videojuegos.services;

import com.colmena.videojuegos.entities.Estudio;
import com.colmena.videojuegos.repositories.RepositorioEstudio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioEstudio implements ServicioBase<Estudio> {
    @Autowired
    private RepositorioEstudio repositorio;

    @Override
    @Transactional
    public List<Estudio> findAll() throws Exception {
        try {
            List<Estudio> estudios = this.repositorio.findAll();
            return estudios;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Estudio findById(long id) throws Exception {
        try {
            Optional<Estudio> opt = this.repositorio.findById(id);
            return opt.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Estudio saveOne(Estudio entity) throws Exception {
        try {
            Estudio estudio = this.repositorio.save(entity);
            return estudio;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Estudio updateOne(Estudio entity, long id) throws Exception {
        try {
            Optional<Estudio> opt = this.repositorio.findById(id);
            Estudio estudio = opt.get();
            estudio = this.repositorio.save(entity);
            return estudio;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean deleteById(long id) throws Exception {
        try {
            Optional<Estudio> opt = this.repositorio.findById(id);

            if (!opt.isEmpty()) {
                Estudio estudio = opt.get();
                estudio.setActivo(!estudio.isActivo());
                this.repositorio.save(estudio);
            } else {
                throw new Exception();
            }
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
