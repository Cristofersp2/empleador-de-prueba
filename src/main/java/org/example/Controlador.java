package org.example;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controlador {

    public void manejarSolicitud(HttpServletRequest request, HttpServletResponse response) {
        String ruta = request.getPathInfo();

        if (ruta.equals("/empleados")) {
            mostrarEmpleados(request, response);
        } else if (ruta.equals("/agregar")) {
            agregarEmpleado(request, response);
        } else if (ruta.equals("/modificar")) {
            modificarEmpleado(request, response);
        } else if (ruta.equals("/desactivar")) {
            desactivarEmpleado(request, response);
        } else {
            mostrarError404(response);
        }
    }

    private void mostrarEmpleados(HttpServletRequest request, HttpServletResponse response) {
        List<Empleado> empleados = Servicios.consultarEmpleados();
        request.setAttribute("empleados", empleados);

        // Lógica para redirigir o despachar a la vista correspondiente
        // ...
    }

    private void agregarEmpleado(HttpServletRequest request, HttpServletResponse response) {
        String nombre = request.getParameter("nombre");
        // Obtener otros datos...

        Empleado empleado = new Empleado(nombre);

        Servicios.agregarEmpleado(empleado);

        // Lógica para redirigir o despachar a la vista correspondiente
        // ...
    }

    private void modificarEmpleado(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        // Obtener otros datos...

        Empleado empleado = Servicios.obtenerEmpleadoPorId(id);

        empleado.setNombre(nombre);
        // Actualizar otros atributos...

        Servicios.actualizarEmpleado(empleado);

        // Lógica para redirigir o despachar a la vista correspondiente
        // ...
    }

    private void desactivarEmpleado(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));

        Servicios.desactivarEmpleado(id);

        // Lógica para redirigir o despachar a la vista correspondiente
        // ...
    }

    private void mostrarError404(HttpServletResponse response) {
        // Lógica para mostrar una página de error 404
        // ...
    }
}
