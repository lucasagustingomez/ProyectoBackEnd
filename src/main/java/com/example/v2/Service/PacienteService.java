package com.example.v2.Service;


import com.example.v2.Entity.Paciente;
import com.example.v2.Exception.DataInvalidException;
import com.example.v2.Exception.ResourceNotFoundException;
import com.example.v2.Repository.PacienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public class PacienteService {


    private PacienteRepository pacienteRepository;

    @Autowired
    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

      public Paciente agregarPaciente (Paciente paciente)throws DataInvalidException {
        if (paciente.getDomicilio() == null|| paciente.getNombre().isEmpty()|| paciente.getDocumento().isEmpty()|| paciente.getApellido().isEmpty()|| paciente.getFechaIngreso() == null){
            throw new DataInvalidException("Error. Alguno de los campos de registro del paciente  se encuentran incompleto");
        }else{
            return  pacienteRepository.save(paciente);
        }
    }

    public Optional<Paciente> listarPaciente (Long id) throws ResourceNotFoundException {
        Optional<Paciente> pacienteABuscar=pacienteRepository.findById(id);
        if (pacienteABuscar.isPresent()){
            return  pacienteRepository.findById(id);
        }else {
            throw new ResourceNotFoundException("Error. No se encontro el paciente Buscado");
        }

    }

    public Paciente modificarPaciente (Paciente paciente)throws ResourceNotFoundException{
        Optional<Paciente> pacienteaModificar= pacienteRepository.findById(paciente.getId());
        if (pacienteaModificar.isPresent()){
            return  pacienteRepository.save(paciente);
        }else {
            throw new ResourceNotFoundException("Error. No se encontro el paciente para actualizar");
        }

    }
    public void  eliminarPaciente (Long id) throws ResourceNotFoundException {
        Optional<Paciente> pacienteAEliminar= pacienteRepository.findById(id);
        if(pacienteAEliminar.isPresent()){
            pacienteRepository.deleteById(id);
        }else {
            throw new ResourceNotFoundException("Error. No se encontro el paciente registrado con el id:  "+ id);
        }

    }

    public List<Paciente>  listarTodosPacientes ()throws ResourceNotFoundException{
        List<Paciente> todosPacientes = pacienteRepository.findAll();
        if (todosPacientes.isEmpty()){
            throw new ResourceNotFoundException("Error. No se agregaron pacientes, la lista se encuentra vacia");
        }else {
           return todosPacientes;
        }

    }


}
