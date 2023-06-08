package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Empleado> empleados = consultarEmpleados();
        System.out.println("Empleados:");
        for (Empleado empleado : empleados) {
            System.out.println(empleado.getNombre());
        }

        Empleado nuevoEmpleado = new Empleado(4, "Ana", new Date(), "Avenida 789", "456123789", true);
        agregarEmpleado(nuevoEmpleado);
        modificarEmpleado(nuevoEmpleado);
        desactivarEmpleado(nuevoEmpleado);
    }

    public static List<Empleado> consultarEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        empleados.add(new Empleado(1, "Juan", new Date(), "Calle 123", "123456789", true));
        empleados.add(new Empleado(2, "María", new Date(), "Avenida 456", "987654321", true));
        empleados.add(new Empleado(3, "Pedro", new Date(), "Plaza 789", "456789123", false));
        return empleados;
    }

    public static void agregarEmpleado(Empleado empleado) {
        System.out.println("Empleado agregado: " + empleado.getNombre());
    }

    public static void modificarEmpleado(Empleado empleado) {
        System.out.println("Empleado modificado: " + empleado.getNombre());
    }

    public static void desactivarEmpleado(Empleado empleado) {
        System.out.println("Empleado desactivado: " + empleado.getNombre());
    }
}
