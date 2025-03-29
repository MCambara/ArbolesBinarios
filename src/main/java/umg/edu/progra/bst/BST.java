package umg.edu.progra.bst;


/**
 *
 * @author Walter Cordova
 */
public class BST implements IBST<Empleado> {


    private Empleado valor;
    private BST izdo, dcho;
    private BST padre;

    @Override
    public void insertar(Empleado emp) {
        if (valor == null) {
            this.valor = emp;
        } else {
            if (emp.compareTo(valor) < 0) {
                if (izdo == null) {
                    izdo = new BST();
                }
                izdo.insertar(emp);
            } else if (emp.compareTo(valor) > 0) {
                if (dcho == null) {
                    dcho = new BST();
                }
                dcho.insertar(emp);
            } else {
                throw new RuntimeException("Insertando elemento duplicado");
            }
        }
    }
//    private void insertarImp(Empleado emp, BST padre) {
//        if (valor == null) {
//            this.valor = emp;
//            this.padre = padre;
//        } else {
//            if (emp.compareTo(valor) < 0) {
//                if (izdo == null) {
//                    izdo = new BST();
//                }
//                izdo.insertarImp(emp, this);
//            } else if (emp.compareTo(valor) > 0) {
//                if (dcho == null) {
//                    dcho = new BST();
//                }
//                dcho.insertarImp(emp, this);
//            } else {
//                throw new RuntimeException("Insertando elemento duplicado");
//            }
//        }
//    }
//
//    @Override
//    public void insertar(Empleado emp) {
//        insertarImp(emp, null);
//    }

    @Override
    public boolean existe(int id) {
        if (valor != null) {
            if (id == valor.getId()) {
                return true;
            } else if (izdo != null && id < valor.getId()) {
                return izdo.existe(id);
            } else if (dcho != null && id > valor.getId()) {
                return dcho.existe(id);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public Empleado obtener(int id) {
        if (valor != null) {
            if (id == valor.getId()) {
                return valor;
            } else if (izdo != null && id < valor.getId()) {
                return izdo.obtener(id);
            } else if (dcho != null && id > valor.getId()) {
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
        return valor != null && izdo == null && dcho == null;
    }

    @Override
    public boolean esVacio() {
        return valor == null;
    }

    @Override
    public void preOrden() {
        preordenImpl("");
    }

    @Override
    public void postOrden() {
        postordenImpl("");
    }

    @Override
    public void inOrden() {
        inordenImpl("");
    }

    private void inordenImpl(String prefijo) {
        if (izdo != null) {
            izdo.inordenImpl(prefijo + "  ");
        }
        System.out.println(" " + prefijo + valor);
        if (dcho != null) {
            dcho.inordenImpl(prefijo + "  ");
        }
    }

    private void postordenImpl(String prefijo) {
        if (izdo != null) {
            izdo.postordenImpl(prefijo + "  ");
        }
        if (dcho != null) {
            dcho.postordenImpl(prefijo + "  ");
        }
        System.out.println(" " + prefijo + valor);
    }

    private void preordenImpl(String prefijo) {
        if (valor != null) {
        	System.out.println(" " + prefijo + valor);
            if (izdo != null) {
                izdo.preordenImpl(prefijo + "  ");
            }
            if (dcho != null) {
                dcho.preordenImpl(prefijo + "  ");
            }
        }
    }

    private void eliminarImpl(int id) {
        if (izdo != null && dcho != null) {
            // Eliminar con 2 hijos
            // Buscamos el sucesor (el valor mínimo del subárbol derecho)
            BST temp = dcho.obtenerMinimoNodo();
            valor = temp.valor;  // Reemplazamos el valor del nodo actual con el valor del sucesor
            temp.eliminarImpl(temp.valor.getId());  // Eliminamos el sucesor (se llama a sí mismo recursivamente)
        } else if (izdo != null || dcho != null) {
            // Eliminar con 1 hijo
            // Si tiene un solo hijo, lo conectamos con su padre
            BST hijo = (izdo != null) ? izdo : dcho; // Si tiene hijo izquierdo, lo seleccionamos, sino el derecho
            if (padre != null) {
                if (this == padre.izdo) {
                    padre.izdo = hijo;
                } else if (this == padre.dcho) {
                    padre.dcho = hijo;
                }
            }
            hijo.padre = padre;  // El hijo ahora tiene como padre al nodo actual
            this.valor = null;
            this.izdo = null;
            this.dcho = null;
            this.padre = null;
        } else {
            // Eliminar con 0 hijos (nodo hoja)
            if (padre != null) {
                if (this == padre.izdo) {
                    padre.izdo = null;
                } else if (this == padre.dcho) {
                    padre.dcho = null;
                }
            }
            this.padre = null;
            this.izdo = null;
            this.dcho = null;
            this.valor = null;
        }
    }

    private BST obtenerMinimoNodo() {
        // Método auxiliar para encontrar el nodo con el valor mínimo en el subárbol izquierdo
        if (izdo != null) {
            return izdo.obtenerMinimoNodo();
        } else {
            return this;
        }
    }

    @Override
    public void eliminar(int id) {
        if (valor != null) {
            if (id == valor.getId()) {
                //eliminar valor
                eliminarImpl(id);
            } else if (izdo != null && id < valor.getId()) {
                izdo.eliminarImpl(id);
            } else if (dcho != null && id > valor.getId()) {
                dcho.eliminarImpl(id);
            }
        }
    }
    
    public int altura() {
        if (valor == null) return 0;
        int alturaIzq = (izdo != null) ? izdo.altura() : 0;
        int alturaDer = (dcho != null) ? dcho.altura() : 0;
        return Math.max(alturaIzq, alturaDer) + 1;
    }

    public int contarNodos() {
        if (valor == null) return 0;
        int nodosIzq = (izdo != null) ? izdo.contarNodos() : 0;
        int nodosDer = (dcho != null) ? dcho.contarNodos() : 0;
        return nodosIzq + nodosDer + 1;
    }

    public Empleado obtenerMinimo() {
        if (valor == null) return null;
        return (izdo == null) ? valor : izdo.obtenerMinimo();
    }

    public Empleado obtenerMaximo() {
        if (valor == null) return null;
        return (dcho == null) ? valor : dcho.obtenerMaximo();
    }

    public void imprimirEnNiveles() {
        int altura = altura();
        for (int i = 1; i <= altura; i++) {
            imprimirNivel(this, i);
            System.out.println();
        }
    }

    private void imprimirNivel(BST nodo, int nivel) {
        if (nodo == null) return;
        if (nivel == 1) {
            System.out.print(nodo.valor + " ");
        } else if (nivel > 1) {
            imprimirNivel(nodo.izdo, nivel - 1);
            imprimirNivel(nodo.dcho, nivel - 1);
        }
    }

}
