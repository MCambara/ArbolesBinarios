package umg.edu.progra.bs.ejercicio;

import java.util.Scanner;

public class SistemaGestionProductosBST {

    public static void main(String[] args) {
        ProductoBST bst = new ProductoBST();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Sistema de Gestión de Productos");
            System.out.println("1. Insertar Producto");
            System.out.println("2. Buscar Producto");
            System.out.println("3. Mostrar Productos (Inorden)");
            System.out.println("4. Eliminar Producto");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer de entrada

            switch (opcion) {
                case 1: {
                    System.out.print("Ingrese ID del Producto: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Limpiar buffer
                    System.out.print("Ingrese nombre del Producto: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese categoría del Producto: ");
                    String categoria = scanner.nextLine();
                    System.out.print("Ingrese precio del Producto: ");
                    double precio = scanner.nextDouble();
                    Producto producto = new Producto(id, nombre, categoria, precio);
                    bst.insertar(producto);
                    System.out.println("Producto insertado exitosamente.");
                    break;
                }
                case 2: {
                    System.out.print("Ingrese ID del Producto a buscar: ");
                    int id = scanner.nextInt();
                    Producto producto = bst.obtener(id);
                    if (producto != null) {
                        System.out.println("Producto encontrado: " + producto);
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;
                }
                case 3: {
                    System.out.println("Productos en orden (Inorden): ");
                    bst.inOrden();
                    System.out.println();
                    break;
                }
                case 4: {
                    System.out.print("Ingrese ID del Producto a eliminar: ");
                    int id = scanner.nextInt();
                    bst.eliminar(id);
                    System.out.println("Producto eliminado.");
                    break;
                }
                case 5: {
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                }
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}	
	/**
	 * Ejercicio: Sistema de Gestión de Productos con Árbol Binario de Búsqueda (BST)
		Contexto:
		Una empresa desea implementar un sistema eficiente para gestionar su catálogo de productos. Se requiere un sistema que permita registrar, buscar y eliminar productos de manera rápida, utilizando un árbol binario de búsqueda (BST).
		
		Requisitos del ejercicio:
		Los estudiantes deberán implementar desde cero un BST en Java para gestionar un catálogo de productos. El BST almacenará objetos de tipo Producto, ordenados por su ID de producto.
		
		Parte 1: Implementación de la Clase Producto
		Los productos tendrán los siguientes atributos:
		
		id (int) → Identificador único del producto
		
		nombre (String) → Nombre del producto
		
		categoria (String) → Categoría del producto
		
		precio (double) → Precio del producto
		
		Deben implementar el método compareTo() para que los productos sean ordenados en el BST por su id.
		
		Parte 2: Implementación del Árbol BST
		Se debe crear una clase ProductoBST que maneje la inserción, búsqueda y eliminación de productos.
		
		Parte 3: Implementación del main y Pruebas
		Deben permitir que el usuario interactúe con el BST para agregar, buscar y mostrar productos.
		
		Tareas Adicionales para los Estudiantes (Opcionales)
		Implementar la eliminación de productos por ID del árbol.
		
		Mejorar la interfaz de usuario para hacer el menú más dinámico.
		
		Agregar más métodos de recorrido, como preOrden y postOrden.
		
		Permitir modificar productos existentes (por ejemplo, actualizar su precio).
		
		Implementar búsqueda por rango de precios.
	 */