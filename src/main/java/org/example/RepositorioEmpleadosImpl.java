package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepositorioEmpleadosImpl implements RepositorioEmpleados {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/?user=root";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "root123";

    private Connection conexion;

    public RepositorioEmpleadosImpl() {
        try {
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar la excepción adecuadamente según tus necesidades
        }
    }

    @Override
    public List<Empleado> consultarEmpleados() {
        List<Empleado> empleados = new ArrayList<>();

        try {
            String consulta = "SELECT * FROM empleados";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultado = statement.executeQuery();

            while (resultado.next()) {
                int id = resultado.getInt("id");
                String nombre = resultado.getString("nombre");
                // Obtener los demás datos del empleado de las columnas correspondientes en la tabla

                Empleado empleado = new Empleado(id, nombre);
                empleados.add(empleado);
            }

            statement.close();
            resultado.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar la excepción adecuadamente según tus necesidades
        }

        return empleados;
    }

    @Override
    public Empleado obtenerEmpleadoPorId(int id) {
        Empleado empleado = null;

        try {
            String consulta = "SELECT * FROM empleados WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setInt(1, id);
            ResultSet resultado = statement.executeQuery();

            if (resultado.next()) {
                String nombre = resultado.getString("nombre");
                // Obtener los demás datos del empleado de las columnas correspondientes en la tabla

                empleado = new Empleado(id, nombre);
            }

            statement.close();
            resultado.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar la excepción adecuadamente según tus necesidades
        }

        return empleado;
    }

    @Override
    public void agregarEmpleado(Empleado empleado) {
        try {
            String consulta = "INSERT INTO empleados (nombre, ...) VALUES (?, ...)";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1, empleado.getNombre());
            // Establecer los demás parámetros del empleado en las columnas correspondientes en la tabla

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar la excepción adecuadamente según tus necesidades
        }
    }

    @Override
    public void actualizarEmpleado(Empleado empleado) {
        try {
            String consulta = "UPDATE empleados SET nombre = ?, ... WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1, empleado.getNombre());
            // Establecer los demás parámetros del empleado en las columnas correspondientes en la tabla
            statement.setInt(5, empleado.getId());

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar la excepción adecuadamente según tus necesidades
        }
    }

    @Override
    public void desactivarEmpleado(int id) {
        try {
            String consulta = "UPDATE empleados SET activo = false WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setInt(1, id);

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar la excepción adecuadamente según tus necesidades
        }
    }
}
