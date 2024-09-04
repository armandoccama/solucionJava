package TiendaOnline.models;

import java.util.ArrayList;
import java.util.List;

import TiendaOnline.exceptions.ProductoAgotadoException;

public class Cliente {
    private String nombre;
    private List<Producto> carritoCompras;

    public Cliente(String nombre) {
        this.nombre = nombre;
        this.carritoCompras = new ArrayList<>();
    }

    public void agregarProductoAlCarrito(Producto producto, int cantidad) throws ProductoAgotadoException {
        if (producto.getCantidadEnStock() < cantidad) {
            throw new ProductoAgotadoException("No hay suficiente stock para el producto: " + producto.getNombre());
        }
        producto.setCantidadEnStock(producto.getCantidadEnStock() - cantidad);
        // Se crear una instancia del mismo producto para manejar la cantidad en el carrito
        Producto productoEnCarrito = clonarProductoConCantidad(producto, cantidad);
        carritoCompras.add(productoEnCarrito);
    }

    private Producto clonarProductoConCantidad(Producto producto, int cantidad) {
      if (producto instanceof ProductoElectronico) {
          ProductoElectronico pe = (ProductoElectronico) producto;
          return new ProductoElectronico(pe.getNombre(), pe.getPrecio(), cantidad, pe.getDescripcion(), pe.getMarca(), pe.getGarantiaEnMeses());
      } else if (producto instanceof ProductoRopa) {
          ProductoRopa pr = (ProductoRopa) producto;
          return new ProductoRopa(pr.getNombre(), pr.getPrecio(), cantidad, pr.getDescripcion(), pr.getTalla(), pr.getColor());
      }
      return null;
    }

    public double calcularTotalCarrito() {
        return carritoCompras.stream().mapToDouble(Producto::calcularPrecio).sum();
    }

    public void verCarrito() {
      if (carritoCompras.isEmpty()) {
          System.out.println("El carrito está vacío.");
      } else {
          System.out.println("Productos en el carrito:");
          for (Producto producto : carritoCompras) {
              System.out.println("- " + producto.getNombre() + " | Cantidad: " + producto.getCantidadEnStock() + " | Precio: " + producto.calcularPrecio());
          }
          System.out.println("Total: " + calcularTotalCarrito());
      }
    }
    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Producto> getCarritoCompras() {
        return carritoCompras;
    }

    public void setCarritoCompras(List<Producto> carritoCompras) {
        this.carritoCompras = carritoCompras;
    }
}
