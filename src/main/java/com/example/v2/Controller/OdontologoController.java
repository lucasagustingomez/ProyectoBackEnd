package com.example.v2.Controller;

import com.example.v2.Entity.Odontologo;
import com.example.v2.Exception.DataInvalidException;
import com.example.v2.Exception.ResourceNotFoundException;
import com.example.v2.Service.OdontologoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    private OdontologoService odontologoService;
    @Autowired
    public OdontologoController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> buscarOdontologo(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<Odontologo> listaOdontologo=odontologoService.listarOdontologo(id);
        if(listaOdontologo.isPresent()){
            return ResponseEntity.ok(listaOdontologo.get());
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


      @PutMapping
    public ResponseEntity<Odontologo> actualizarOdontologo(@RequestBody Odontologo odontologo)throws ResourceNotFoundException{
        Odontologo odontologoActualizado = odontologoService.modificarOdontologo(odontologo);
        if (odontologoActualizado != null) {
            return ResponseEntity.ok(odontologoActualizado);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Odontologo>> buscarTodosOdontologos() throws ResourceNotFoundException {
        List<Odontologo> listaOdontologos = odontologoService.listarTodosOdontologo();
        return ResponseEntity.ok(listaOdontologos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarOdontologo(@PathVariable Long id) throws ResourceNotFoundException {
        odontologoService.eliminarOdontologo(id);
        return ResponseEntity.noContent().build();
    }


    @PostMapping
    public ResponseEntity<Odontologo> agregarOdontologo(@RequestBody Odontologo odontologo) throws DataInvalidException {
        Odontologo odontologoAgregado = odontologoService.agregarOdontologo(odontologo);
        return ResponseEntity.status(HttpStatus.CREATED).body(odontologoAgregado);
    }
}










