package org.example;
import java.util.List;

public interface RepositorioEmpleados {
    List<Empleado> consultarEmpleados();

    Empleado obtenerEmpleadoPorId(int id);

    void agregarEmpleado(Empleado empleado);

    void actualizarEmpleado(Empleado empleado);

    void desactivarEmpleado(int id);
}

