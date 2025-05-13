package modelo;

import java.util.Date;

public class Producto {
    private int id;
    private String nombre;
    private String categoria;
    private double precio;
    private int cantidad;
    private int stockMinimo;
    // private int proveedorId;
    private int garantiaDias;
                                                                                                // int proveedorId,
    public Producto(int id, String nombre, String categoria, double precio, int cantidad, int stockMinimo,  int garantiaDias) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.cantidad = cantidad;
        this.stockMinimo = stockMinimo;
        // this.proveedorId = proveedorId;
        this.garantiaDias = garantiaDias;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

/*     public int getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(int proveedorId) {
        this.proveedorId = proveedorId;
    } */

    public int getGarantiaDias() {
        return garantiaDias;
    }

    public void setGarantiaDias(int garantiaDias) {
        this.garantiaDias = garantiaDias;
    }

    
}