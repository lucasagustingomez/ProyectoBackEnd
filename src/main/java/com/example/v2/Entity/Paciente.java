package com.example.v2.Entity;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String apellido;
    @Column
    private String nombre;
    @Column
    private String documento;
    @Column
    private LocalDate fechaIngreso;

    @OneToOne(cascade = CascadeType.ALL)
    // Especifica la columna utilizada para la relación y el nombre de la columna en la tabla
    @JoinColumn(name = "domicilio_id",referencedColumnName = "id")
    private Domicilio domicilio;

    @OneToMany(mappedBy = "paciente",fetch = FetchType.LAZY)
    private Set<Turno> turnos= new HashSet<>();

    public Paciente(Long id, String apellido, String nombre, String documento, LocalDate fechaIngreso, Domicilio domicilio) {
        this.id = id;
        this.apellido = apellido;
        this.nombre = nombre;
        this.documento = documento;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
    }

    public Paciente(String apellido, String nombre, String documento, LocalDate fechaIngreso, Domicilio domicilio) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.documento = documento;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
    }


    public Paciente() {
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }


    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", apellido='" + apellido + '\'' +
                ", nombre='" + nombre + '\'' +
                ", documento='" + documento + '\'' +
                ", fechaIngreso=" + fechaIngreso +
                ", domicilio=" + domicilio +'\''+
                '}';
    }
}
