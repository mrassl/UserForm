package com.mrassl.userform;


import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

public class User {
    private String nombre;
    private String fecha;
    private String telefono;
    private String email;
    private String descripcion;

    public User(String nombre, String fecha, String telefono, String email, String descripcion) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.telefono = telefono;
        this.email = email;
        this.descripcion = descripcion;
    }

    public User(TextView nombre, TextView fecha, TextView telefono, TextView email, TextView descripcion) {
    }

    public User(EditText nombre, DatePicker fecha, EditText telefono, EditText email, EditText descripcion) {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
