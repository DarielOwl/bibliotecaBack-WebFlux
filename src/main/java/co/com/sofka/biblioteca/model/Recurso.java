package co.com.sofka.biblioteca.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Document(collection = "recurso")
public class Recurso {
    @Id
    private String id = UUID.randomUUID().toString().substring(0, 10);
    private String nombre;
    private Boolean estado;
    private LocalDate fechaPrestamo;
    private String tipoRecurso;
    private String categoriaRecurso;

    //Constructor por Defecto
    public Recurso() {
    }

    //Constructor de Asignacion
    public Recurso(String nombre, Boolean estado, LocalDate fechaPrestamo, String tipoRecurso, String categoriaRecurso) {
        this.nombre = Objects.requireNonNull(nombre);
        this.estado = estado;
        this.fechaPrestamo =  LocalDate.now();;
        this.tipoRecurso = Objects.requireNonNull(tipoRecurso);
        this.categoriaRecurso = Objects.requireNonNull(categoriaRecurso);
    }


    //Getters------------------
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Boolean getEstado() {
        return estado;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public String getTipoRecurso() {
        return tipoRecurso;
    }

    public String getCategoriaRecurso() {
        return categoriaRecurso;
    }


    //Setters-----------------------
    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public void setTipoRecurso(String tipoRecurso) {
        this.tipoRecurso = tipoRecurso;
    }

    public void setCategoriaRecurso(String categoriaRecurso) {
        this.categoriaRecurso = categoriaRecurso;
    }
}
