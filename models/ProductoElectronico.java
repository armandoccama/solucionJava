package TiendaOnline.models;

public class ProductoElectronico extends Producto {
  private String marca;
  private int garantiaEnMeses;

  public ProductoElectronico(String nombre, double precio, int cantidadEnStock, String descripcion, String marca, int garantiaEnMeses) {
      super(nombre, precio, cantidadEnStock, descripcion);
      this.marca = marca;
      this.garantiaEnMeses = garantiaEnMeses;
  }

  @Override
  public double calcularPrecio() {
      // aplicar un 10% de impuesto más un incremento por garantía extendida
      double precioBase = getPrecio() * 1.10;
      // 5% extra si la garantía es mayor a 12 meses
      double incrementoPorGarantia = garantiaEnMeses > 12 ? precioBase * 0.05 : 0;
      return precioBase + incrementoPorGarantia;
  }

  // Getters y setters para marca y garantiaEnMeses
  public String getMarca() {
      return marca;
  }

  public void setMarca(String marca) {
      this.marca = marca;
  }

  public int getGarantiaEnMeses() {
      return garantiaEnMeses;
  }

  public void setGarantiaEnMeses(int garantiaEnMeses) {
      this.garantiaEnMeses = garantiaEnMeses;
  }
}
