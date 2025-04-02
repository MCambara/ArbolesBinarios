package umg.edu.progra.bs.ejercicio;

public interface IbstProducto<T extends Comparable> {

	   void insertar(T emp);

	    boolean existe(int id);

	    T obtener(int id);

	    boolean esHoja();

	    boolean esVacio();

	    void preOrden();

	    void inOrden();

	    void postOrden();

	    void eliminar(int id);
	
}
