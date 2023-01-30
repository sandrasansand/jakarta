package org.asaezc.apiservlet.webapp.compras.models;

import java.util.Objects;

public class ItemCarro {
    private int cantidad;
    private Producto producto;

    public ItemCarro(int cantidad, Producto producto) {
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    //implementación del metodo equals para utilizar en la Clase Carro contains(), y comparar por nombre e id -> único
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemCarro itemCarro = (ItemCarro) o;
        return Objects.equals(producto.getId(), itemCarro.producto.getId())
                && Objects.equals(producto.getNombre(), itemCarro.producto.getNombre());
    }

    public int getImporte() {
        return cantidad * producto.getPrecio();
    }
}
