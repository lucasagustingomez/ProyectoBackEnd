package com.example.v2.Controller;

import com.example.v2.Entity.Paciente;
import com.example.v2.Exception.DataInvalidException;
import com.example.v2.Exception.ResourceNotFoundException;
import com.example.v2.Service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private PacienteService pacienteService;


    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }



@PutMapping
public ResponseEntity<Paciente> actualizarPaciente(@RequestBody Paciente paciente)throws ResourceNotFoundException {
    Paciente pacienteActualizado = pacienteService.modificarPaciente(paciente);
    return ResponseEntity.ok(pacienteActualizado);
}


    @GetMapping ("/{id}")
    public ResponseEntity<Paciente> buscarPaciente(@PathVariable Long id)throws ResourceNotFoundException {
        Optional<Paciente> paciente = pacienteService.listarPaciente(id);
        if(paciente.isPresent()) {
            return ResponseEntity.ok(paciente.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    ResponseEntity <Paciente> registrarPaciente(@RequestBody Paciente paciente) throws  DataInvalidException {
        return ResponseEntity.ok(pacienteService.agregarPaciente(paciente)) ;}


    @GetMapping
    public ResponseEntity<List<Paciente>> buscarTodos()throws ResourceNotFoundException{
        List<Paciente> pacientes = pacienteService.listarTodosPacientes();
        return ResponseEntity.ok(pacientes);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPaciente(@PathVariable Long id)throws ResourceNotFoundException {
        pacienteService.eliminarPaciente(id);
        return ResponseEntity.noContent().build();
    }


}

