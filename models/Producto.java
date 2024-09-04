package TiendaOnline.models;

import TiendaOnline.interfaces.Comprable;

public abstract class Producto implements Comprable {
  private String nombre;
  private double precio;
  private int cantidadEnStock;
  private String descripcion;

  public Producto(String nombre, double precio, int cantidadEnStock, String descripcion) {
      this.nombre = nombre;
      this.precio = precio;
      this.cantidadEnStock = cantidadEnStock;
      this.descripcion = descripcion;
  }

  // Getters y setters
  public String getNombre() {
      return nombre;
  }

  public void setNombre(String nombre) {
      this.nombre = nombre;
  }

  public double getPrecio() {
      return precio;
  }

  public void setPrecio(double precio) {
      this.precio = precio;
  }

  public int getCantidadEnStock() {
      return cantidadEnStock;
  }

  public void setCantidadEnStock(int cantidadEnStock) {
      this.cantidadEnStock = cantidadEnStock;
  }

  public String getDescripcion() {
      return descripcion;
  }

  public void setDescripcion(String descripcion) {
      this.descripcion = descripcion;
  }

  // Método abstracto calcularPrecio
  @Override
  public abstract double calcularPrecio();
}
