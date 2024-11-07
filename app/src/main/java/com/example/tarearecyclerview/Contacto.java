package com.example.tarearecyclerview;

public class Contacto {
    private String nombre;
    private String email;
    private String numeroMovil;
    private int foto;

    // Constructor
    public Contacto(String nombre, String email, String numeroMovil, int foto) {
        this.nombre = nombre;
        this.email = email;
        this.numeroMovil = numeroMovil;
        this.foto = foto;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getNumeroMovil() {
        return numeroMovil;
    }

    public int getFoto(){
        return foto;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNumeroMovil(String numeroMovil) {
        this.numeroMovil = numeroMovil;
    }

    public void setFoto(int foto){
        this.foto = foto;
    }

    // Método para mostrar la información del contacto
    @Override
    public String toString() {
        return "Contacto{" +
                "nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", numeroMovil='" + numeroMovil + '\'' +
                '}';
    }
}

