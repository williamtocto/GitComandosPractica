package com.mb5.ejercicio1.service;

import com.mb5.ejercicio1.model.Casa;
import com.mb5.ejercicio1.repository.CasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CasaServiceImpl  implements CasaService {
    @Autowired
    CasaRepository casaRepository;

    @Override
    public Casa create(Casa c) {
        return casaRepository.save(c);
    }

    @Override
    public Casa save(Casa casa) {
        return casaRepository.save(casa);
    }

    @Override
    public Casa findById(Integer id) {
        return casaRepository.findById(id).orElse(new Casa());
    }

    @Override
    public List<Casa> findByAll() {
        return casaRepository.findAll();
    }


    @Override
    public void eliminar(Integer id) {
        casaRepository.deleteById(id);
    }



}
