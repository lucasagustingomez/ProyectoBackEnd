package com.example.v2.Dto;

import java.time.LocalDate;



public class TurnoDto {


    private Long id;
    private LocalDate fecha;
    private Long pacienteId;
    private String nombrePaciente;
    private Long odontologoId;
    private String nombreOdontologo;



    public TurnoDto() {
    }

    public TurnoDto(Long id, LocalDate fecha, Long pacienteId, String nombrePaciente, Long odontologoId, String nombreOdontologo) {
        this.id = id;
        this.fecha = fecha;
        this.pacienteId = pacienteId;
        this.nombrePaciente = nombrePaciente;
        this.odontologoId = odontologoId;
        this.nombreOdontologo = nombreOdontologo;
    }


    public TurnoDto(LocalDate fecha, Long pacienteId, String nombrePaciente, Long odontologoId, String nombreOdontologo) {
        this.fecha = fecha;
        this.pacienteId = pacienteId;
        this.nombrePaciente = nombrePaciente;
        this.odontologoId = odontologoId;
        this.nombreOdontologo = nombreOdontologo;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Long getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Long pacienteId) {
        this.pacienteId = pacienteId;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public Long getOdontologoId() {
        return odontologoId;
    }

    public void setOdontologoId(Long odontologoId) {
        this.odontologoId = odontologoId;
    }



    public String getNombreOdontologo() {
        return nombreOdontologo;
    }

    public void setNombreOdontologo(String nombreOdontologo) {
        this.nombreOdontologo = nombreOdontologo;
    }


    @Override
    public String toString() {
        return "TurnoDto{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", pacienteId=" + pacienteId +
                ", nombrePaciente='" + nombrePaciente + '\'' +
                ", odontologoId=" + odontologoId +
                ", nombreOdontologo='" + nombreOdontologo + '\'' +
                '}';
    }
}
