package com.OrgSolutionNet.Proyecto.Entities;

import javax.persistence.*;

@Entity
@Table(name="empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name="id")
    public long id;

    @Column(name = "nombre_em")
    private String nombre_em;

    @Column(name = "correo_em")
    private String correo_em;

    @Column(name = "empresa_em")
    private String empresa_em;

    @Column(name = "rol_em")
    private String rol_em;

    public Empleado() {
    }

    public Empleado(String nombre_em, String correo_em, String empresa_em, String rol_em) {
        this.nombre_em = nombre_em;
        this.correo_em = correo_em;
        this.empresa_em = empresa_em;
        this.rol_em = rol_em;
    }

    public String getNombre_em() {
        return nombre_em;
    }

    public void setNombre_em(String nombre_em) {
        this.nombre_em = nombre_em;
    }

    public String getCorreo_em() {
        return correo_em;
    }

    public void setCorreo_em(String correo_em) {
        this.correo_em = correo_em;
    }

    public String getEmpresa_em() {
        return empresa_em;
    }

    public void setEmpresa_em(String empresa_em) {
        this.empresa_em = empresa_em;
    }

    public String getRol_em() {
        return rol_em;
    }

    public void setRol_em(String rol_em) {
        this.rol_em = rol_em;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", nombre_em='" + nombre_em + '\'' +
                ", correo_em='" + correo_em + '\'' +
                ", empresa_em='" + empresa_em + '\'' +
                ", rol_em='" + rol_em + '\'' +
                '}';
    }
}
