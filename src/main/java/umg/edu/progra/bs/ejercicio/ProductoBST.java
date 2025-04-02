package umg.edu.progra.bs.ejercicio;

public class ProductoBST implements IbstProducto<Producto> {

    private Producto producto;
    private ProductoBST izdo, dcho;
    private ProductoBST padre;

    @Override
    public void insertar(Producto prod) {
        if (producto == null) {
            this.producto = prod;
        } else {
            if (prod.compareTo(producto) < 0) {
                if (izdo == null) {
                    izdo = new ProductoBST();
                }
                izdo.insertar(prod);
            } else if (prod.compareTo(producto) > 0) {
                if (dcho == null) {
                    dcho = new ProductoBST();
                }
                dcho.insertar(prod);
            } else {
                throw new RuntimeException("Insertando elemento duplicado");
            }
        }
    }

    @Override
    public boolean existe(int id) {
        if (producto != null) {
            if (id == producto.getId()) {
                return true;
            } else if (izdo != null && id < producto.getId()) {
                return izdo.existe(id);
            } else if (dcho != null && id > producto.getId()) {
                return dcho.existe(id);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public Producto obtener(int id) {
        if (producto != null) {
            if (id == producto.getId()) {
                return producto;
            } else if (izdo != null && id < producto.getId()) {
                return izdo.obtener(id);
            } else if (dcho != null && id > producto.getId()) {
                return dcho.obtener(id);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    @Override
    public boolean esHoja() {
        return producto != null && izdo == null && dcho == null;
    }

    @Override
    public boolean esVacio() {
        return producto == null;
    }

    @Override
    public void preOrden() {
        if (producto != null) {
            System.out.print(producto + " ");
            if (izdo != null) izdo.preOrden();
            if (dcho != null) dcho.preOrden();
        }
    }

    @Override
    public void inOrden() {
        if (izdo != null) izdo.inOrden();
        if (producto != null) System.out.print(producto + " ");
        if (dcho != null) dcho.inOrden();
    }

    @Override
    public void postOrden() {
        if (izdo != null) izdo.postOrden();
        if (dcho != null) dcho.postOrden();
        if (producto != null) System.out.print(producto + " ");
    }

    @Override
    public void eliminar(int id) {
        if (producto == null) return;
        if (id < producto.getId()) {
            if (izdo != null) izdo.eliminar(id);
        } else if (id > producto.getId()) {
            if (dcho != null) dcho.eliminar(id);
        } else {
            if (izdo == null && dcho == null) {
                producto = null;
            } else if (izdo == null) {
                producto = dcho.producto;
                izdo = dcho.izdo;
                dcho = dcho.dcho;
            } else if (dcho == null) {
                producto = izdo.producto;
                dcho = izdo.dcho;
                izdo = izdo.izdo;
            } else {
                ProductoBST sucesor = obtenerMinimo(dcho);
                producto = sucesor.producto;
                dcho.eliminar(sucesor.producto.getId());
            }
        }
    }

    private ProductoBST obtenerMinimo(ProductoBST nodo) {
        while (nodo.izdo != null) {
            nodo = nodo.izdo;
        }
        return nodo;
    }
}
