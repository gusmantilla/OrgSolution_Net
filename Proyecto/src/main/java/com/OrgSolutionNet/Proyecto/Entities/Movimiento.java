package com.OrgSolutionNet.Proyecto.Entities;

import javax.persistence.*;

@Entity
@Table(name="movimiento")
public class Movimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name="id")
    public long id;

    @Column(name = "monto")
    private String monto;

    @Column(name = "monto_positivo")
    private String monto_positivo;

    @Column(name = "monto_negativo")
    private String monto_negativo;

    @Column(name = "concepto")
    private String concepto;

    @Column(name = "usuario_en")
    private String usuario_en;

    public Movimiento() {
    }

    public Movimiento(String monto, String monto_positivo, String monto_negativo, String concepto, String usuario_en) {
        this.monto = monto;
        this.monto_positivo = monto_positivo;
        this.monto_negativo = monto_negativo;
        this.concepto = concepto;
        this.usuario_en = usuario_en;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getMonto_positivo() {
        return monto_positivo;
    }

    public void setMonto_positivo(String monto_positivo) {
        this.monto_positivo = monto_positivo;
    }

    public String getMonto_negativo() {
        return monto_negativo;
    }

    public void setMonto_negativo(String monto_negativo) {
        this.monto_negativo = monto_negativo;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getUsuario_en() {
        return usuario_en;
    }

    public void setUsuario_en(String usuario_en) {
        this.usuario_en = usuario_en;
    }

    @Override
    public String toString() {
        return "Movimiento{" +
                "id=" + id +
                ", monto='" + monto + '\'' +
                ", monto_positivo='" + monto_positivo + '\'' +
                ", monto_negativo='" + monto_negativo + '\'' +
                ", concepto='" + concepto + '\'' +
                ", usuario_en='" + usuario_en + '\'' +
                '}';
    }
}
