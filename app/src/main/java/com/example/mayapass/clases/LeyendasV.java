package com.example.mayapass.clases;

public class LeyendasV {
    private String nombre;
    private String desc;
    private String info;
    private int imagenId;

    public LeyendasV(String nombre,String desc, String info, int imagenId) {
        this.nombre = nombre;
        this.desc = desc;
        this.info = info;
        this.imagenId = imagenId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getImagenId() {
        return imagenId;
    }

    public void setImagenId(int imagenId) {
        this.imagenId = imagenId;
    }
}

