package com.mb5.ejercicio1.controller;

import com.mb5.ejercicio1.model.Casa;
import com.mb5.ejercicio1.repository.CasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class CasaController {
    @Autowired
    CasaService casaService;

    @GetMapping("/listar")
    public List<Casa> listar() {
        return casaService.findByAll();
    }

    @PostMapping("/crear")
    public ResponseEntity<Casa> crearUsuario(@RequestBody Casa u) {
        double costo_total=u.getCosto_total()*80;
        u.setCosto_total(costo_total);
        return new ResponseEntity<>(casaService.create(u), HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Casa> eliminarUsuario(@PathVariable Integer id) {
        casaService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public Casa actualizarCasa(@PathVariable Integer id, @RequestBody Casa c) {

        Casa casaActual = casaService.findById(id);
        casaActual.setPropietario(c.getPropietario());
        casaActual.setCodigo(c.getCodigo());
        return casaService.save(casaActual);

    }

    public double calcularCosto( double area) {

            double cos_total=area*80;
            return cos_total;
    }


}
