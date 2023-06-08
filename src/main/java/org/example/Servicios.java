package org.example;

import java.util.ArrayList;
import java.util.List;

public class Servicios {
    private static List<Empleado> empleados;

    static {
        empleados = new ArrayList<>();
    }

    public static List<Empleado> consultarEmpleados() {
        return empleados;
    }

    public static void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public static void modificarEmpleado(int id, Empleado empleadoModificado) {
        for (int i = 0; i < empleados.size(); i++) {
            Empleado empleado = empleados.get(i);
            if (empleado.getId() == id) {
                empleados.set(i, empleadoModificado);
                break;
            }
        }
    }

    public static void desactivarEmpleado(int id) {
        for (int i = 0; i < empleados.size(); i++) {
            Empleado empleado = empleados.get(i);
            if (empleado.getId() == id) {
                empleado.setActivo(false);
                break;
            }
        }
    }

    public static Empleado obtenerEmpleadoPorId(int id) {
        for (Empleado empleado : empleados) {
            if (empleado.getId() == id) {
                return empleado;
            }
        }
        return null;
    }

    public static void actualizarEmpleado(Empleado empleado) {
        int id = empleado.getId();
        for (int i = 0; i < empleados.size(); i++) {
            Empleado emp = empleados.get(i);
            if (emp.getId() == id) {
                empleados.set(i, empleado);
                break;
            }
        }
    }
}
