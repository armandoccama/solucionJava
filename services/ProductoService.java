package TiendaOnline.services;

import TiendaOnline.models.Producto;
import java.util.ArrayList;
import java.util.List;

public class ProductoService {
    private List<Producto> productos;

    public ProductoService() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public List<Producto> obtenerProductos() {
      return productos;
    }

    public Producto buscarProductoPorId(int id) {
        if (id >= 0 && id < productos.size()) {
            return productos.get(id);
        }
        return null;
    }

}
