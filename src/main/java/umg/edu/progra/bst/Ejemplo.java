package umg.edu.progra.bst;

import java.util.Scanner;

/**
 *
 * @author Walter Cordova
 */
public class Ejemplo {

    public static void main(String[] args) {
       /* Empleado e1 = new Empleado(43, "Walter Cordova", "IT", "A-255");
        Empleado e2 = new Empleado(10, "Roxana Escobar", "RRHH", "A-255");
        Empleado e3 = new Empleado(8, "Bryan Orellana", "Ventas", "A-255");
        Empleado e4 = new Empleado(53, "Mario Ruano", "Logistica", "A-255");
        Empleado e5 = new Empleado(15, "Salazar Bitsco", "IT", "A-255");
        Empleado e6 = new Empleado(50, "Jonny Bravo", "RRHH", "A-255");
        Empleado e7 = new Empleado(54, "Sergio Espinoza", "Marketing", "A-255");
        Empleado e8 = new Empleado(25, "Belter Hernandez", "Contabilidad", "A-255");

        BST bst = new BST();
        System.out.println("Esta vacio: " + bst.esVacio() + " y es hoja " + bst.esHoja());
        System.out.println("Esta vacio: " + bst.esVacio() + " y es hoja " + bst.esHoja());
        bst.insertar(e1);
        System.out.println("Esta vacio: " + bst.esVacio() + " y es hoja " + bst.esHoja());
        bst.insertar(e2);
        System.out.println("Esta vacio: " + bst.esVacio() + " y es hoja " + bst.esHoja());
        bst.insertar(e3);
        System.out.println("Esta vacio: " + bst.esVacio() + " y es hoja " + bst.esHoja());
        bst.insertar(e8);
        System.out.println("Esta vacio: " + bst.esVacio() + " y es hoja " + bst.esHoja());
        
        localizar(bst,20);
        localizar(bst,45);
        localizar(bst,25);
        localizar(bst,19);

        //Arrays.asList(e1, e2, e3, e4, e5, e6, e7).forEach(bst::insertar);
        bst.insertar(e2);
        bst.insertar(e3);
        bst.insertar(e4);
        bst.insertar(e5);
        bst.insertar(e6);
        bst.insertar(e7);
        bst.insertar(e8);

        bst.inOrden();

        //BST bst = new BST();
        System.out.println("Esta vacio: " + bst.esVacio() + " y es hoja " + bst.esHoja());
        bst.insertar(e1);
        System.out.println("Esta vacio: " + bst.esVacio() + " y es hoja " + bst.esHoja());*/
    	
    	MainBst();
    }

    private static void localizar(BST bst, int id) {
        if (bst.existe(id)) {
        	System.out.println("Obtener" + id + ":" + bst.obtener(id));
        } else {
        	System.out.println("No encuentro el empleado: " + id);
        }
    }
    
    public static void MainBst() {
        // Crear el árbol BST y los empleados
        BST bst = new BST();

        Empleado e1 = new Empleado(10, "Juan", "Ventas", "A-101");
        Empleado e2 = new Empleado(20, "Maria", "IT", "A-102");
        Empleado e3 = new Empleado(5, "Pedro", "RRHH", "A-103");
        Empleado e4 = new Empleado(8, "Ana", "Marketing", "A-104");
        Empleado e5 = new Empleado(15, "Carlos", "Logistica", "A-105");
        Empleado e6 = new Empleado(25, "Sofia", "Contabilidad", "A-106");

        // Insertar empleados en el BST
        bst.insertar(e1);
        bst.insertar(e2);
        bst.insertar(e3);
        bst.insertar(e4);
        bst.insertar(e5);
        bst.insertar(e6);

        // Localizar empleados con IDs específicos
        localizar(bst, 8);
        localizar(bst, 15);
        localizar(bst, 30);

        // Menú para elegir diferentes opciones
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú:");
            System.out.println("1. Mostrar recorrido PreOrden");
            System.out.println("2. Mostrar recorrido InOrden");
            System.out.println("3. Mostrar recorrido PostOrden");
            System.out.println("4. Ver empleado con el menor ID");
            System.out.println("5. Ver empleado con el mayor ID");
            System.out.println("6. Contar nodos en el árbol");
            System.out.println("7. Calcular la altura del árbol");
            System.out.println("8. Eliminar un empleado por su ID");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    bst.preOrden();
                    break;
                case 2:
                    bst.inOrden();
                    break;
                case 3:
                    bst.postOrden();
                    break;
                case 4:
                    // Mostrar el empleado con el menor ID
                    Empleado minEmpleado = bst.obtenerMinimo();
                    if (minEmpleado != null) {
                        System.out.println("Empleado con el menor ID: " + minEmpleado);
                    } else {
                        System.out.println("El árbol está vacío.");
                    }
                    break;
                case 5:
                    // Mostrar el empleado con el mayor ID
                    Empleado maxEmpleado = bst.obtenerMaximo();
                    if (maxEmpleado != null) {
                        System.out.println("Empleado con el mayor ID: " + maxEmpleado);
                    } else {
                        System.out.println("El árbol está vacío.");
                    }
                    break;
                case 6:
                    // Contar nodos en el árbol
                    int numeroNodos = bst.contarNodos();
                    System.out.println("El árbol tiene: " + numeroNodos + " nodos");
                    break;
                case 7:
                    // Calcular la altura del árbol
                    System.out.println("La altura del árbol es de: " + bst.altura());
                    break;
                case 8:
                    // Eliminar un empleado por su ID
                    System.out.print("Ingrese el ID del empleado a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    bst.eliminar(idEliminar);
                    break;
                case 9:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        } while (opcion != 9);

        scanner.close();
    }

    /**
     * Ejercicio 3: Encontrar el Mínimo y Máximo
     * Agrega empleados con diferentes IDs a un BST.
     * Implementa una opción en el menú para que el usuario pueda ver el empleado con el menor ID y el empleado con el mayor ID.
     * Explica cómo se usa la estructura del árbol para encontrar estos valores.
     */

    /**
     * Ejercicio 4: Contar Nodos y Calcular la Altura
     * Implementa un método en MainBST que cuente cuántos empleados hay en el árbol.
     * Implementa otro método que calcule la altura del árbol.
     * Prueba estos métodos con diferentes conjuntos de datos.
     */

    /**
     * Ejercicio 5: Eliminación de un Nodo
     * Implementa una opción en el menú para eliminar un empleado por su ID.
     * Prueba eliminando:
     * Un nodo hoja (sin hijos).
     * Un nodo con un solo hijo.
     * Un nodo con dos hijos.
     * Explica qué ocurre en cada caso y cómo el árbol se reorganiza.
     */
}
