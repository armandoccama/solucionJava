package TiendaOnline.services;

import TiendaOnline.exceptions.ProductoAgotadoException;
import TiendaOnline.models.Cliente;
import TiendaOnline.models.Producto;
import java.util.List;

public class CarritoService {
    // Agregar producto al carrito de un cliente
    public void agregarProductoAlCarrito(Cliente cliente, Producto producto, int cantidad) {
      try {
          cliente.agregarProductoAlCarrito(producto, cantidad);
          System.out.println("Producto agregado al carrito exitosamente.");
      } catch (ProductoAgotadoException e) {
          System.out.println(e.getMessage());
      }
  }

  // Ver el carrito de un cliente
  public void verCarrito(Cliente cliente) {
      List<Producto> carrito = cliente.getCarritoCompras();
      if (carrito.isEmpty()) {
          System.out.println("El carrito está vacío.");
      } else {
          System.out.println("Productos en el carrito:");
          for (Producto producto : carrito) {
              System.out.println(producto.getNombre() + " - Precio: " + producto.calcularPrecio());
          }
      }
  }

  // Realizar la compra y calcular el total
  public void realizarCompra(Cliente cliente) {
    double total = 0.0;
    List<Producto> carrito = cliente.getCarritoCompras();
    
    for (Producto producto : carrito) {
        total += producto.calcularPrecio();
    }
    
    System.out.println("El total de su compra es: " + total);
  }
}
