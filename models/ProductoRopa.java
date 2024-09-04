package TiendaOnline.models;

public class ProductoRopa extends Producto {
  private String talla;
  private String color;

  public ProductoRopa(String nombre, double precio, int cantidadEnStock, String descripcion, String talla, String color) {
      super(nombre, precio, cantidadEnStock, descripcion);
      this.talla = talla;
      this.color = color;
  }

  @Override
  public double calcularPrecio() {
      // aplicar un 5% de descuento, y un costo adicional para ciertos colores
      double precioBase = getPrecio() * 0.95;
      // Si es rojo, aumenta 10 unidades
      double incrementoPorColor = color.equalsIgnoreCase("rojo") ? 10.0 : 0;
      return precioBase + incrementoPorColor;
  }

  // Getters y setters para talla y color
  public String getTalla() {
      return talla;
  }

  public void setTalla(String talla) {
      this.talla = talla;
  }

  public String getColor() {
      return color;
  }

  public void setColor(String color) {
      this.color = color;
  }
}
