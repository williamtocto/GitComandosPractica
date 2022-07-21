package com.mb5.ejercicio1.repository;

import com.mb5.ejercicio1.model.Casa;

import java.util.List;

public interface CasaService {

    public Casa create( Casa c);
    public Casa save(Casa casa);
    public Casa findById(Integer id);
    public List<Casa> findByAll();
    public void eliminar(Integer id);
}
