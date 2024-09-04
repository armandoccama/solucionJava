package TiendaOnline;
import java.util.Scanner;
import java.util.List;

import TiendaOnline.models.Cliente;
import TiendaOnline.models.Producto;
import TiendaOnline.models.ProductoElectronico;
import TiendaOnline.models.ProductoRopa;
import TiendaOnline.services.CarritoService;
import TiendaOnline.services.ProductoService;

public class Main {
    public static void main(String[] args) {
        ProductoService productoService = new ProductoService();
        CarritoService carritoService = new CarritoService();
        Cliente cliente = new Cliente("Juan");

        productoService.agregarProducto(new ProductoElectronico("Laptop", 1200.0, 10, "Laptop de baja gama", "Dell", 24));
        productoService.agregarProducto(new ProductoRopa("Camisa", 30.0, 50, "Camisa de algodón", "L", "Azul"));

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("1. Agregar producto al carrito");
            System.out.println("2. Ver el carrito");
            System.out.println("3. Realizar la compra");
            System.out.println("4. Salir del sistema");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    List<Producto> productosDisponibles = productoService.obtenerProductos();
                    System.out.println("Productos disponibles:");
                    for (int i = 0; i < productosDisponibles.size(); i++) {
                        Producto producto = productosDisponibles.get(i);
                        System.out.println(i + ". " + producto.getNombre() + " - Precio: " + producto.getPrecio() + " - Stock: " + producto.getCantidadEnStock());
                    }

                    System.out.print("Seleccione el número del producto: ");
                    int productoId = scanner.nextInt();

                    System.out.print("Ingrese la cantidad: ");
                    int cantidad = scanner.nextInt();

                    Producto productoSeleccionado = productoService.buscarProductoPorId(productoId);

                    if (productoSeleccionado != null) {
                        carritoService.agregarProductoAlCarrito(cliente, productoSeleccionado, cantidad);
                    } else {
                        System.out.println("Producto no válido.");
                    }
                    break;
                case 2:
                    carritoService.verCarrito(cliente);
                    break;
                case 3:
                    carritoService.realizarCompra(cliente);
                    break;
                case 4:
                    System.out.println("Gracias por usar el sistema. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 4);

        scanner.close();
    }
}
