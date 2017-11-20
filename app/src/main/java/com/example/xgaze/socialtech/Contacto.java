package com.example.xgaze.socialtech;

/**
 * Created by xgaze on 12/11/2017.
 */

public class Contacto {

    private String nombre;
    private String apellidos;
    private String telefono;
    private String email;
    private String edad;
    private String formacion;
    private String provincia;
    private String sexo;

    public Contacto(String nombre, String apellido, String telefono, String email) {
    }

    public Contacto(String nombre, String apellidos, String telefono, String email, String edad, String formacion, String sexo ) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.email = email;
        this.edad = edad;
        this.formacion = formacion;
        this.sexo = sexo;
        //this.provincia = provincia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getFormacion() {
        return formacion;
    }

    public void setFormacion(String formacion) {
        this.formacion = formacion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Contacto{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", edad='" + edad + '\'' +
                ", formacion='" + formacion + '\'' +
                ", provincia='" + provincia + '\'' +
                ", sexo='" + sexo + '\'' +
                '}';
    }
}
