package ejercicio3.dao;

import ejercicio3.modelo.Videojuego;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

public class VideojuegoDAO {
    private static Connection conectar() {
        String url = "jdbc:sqlite:./examen3ev22";
        Connection con = null; // para poder devolverla fuera del try
        try {
            con = DriverManager.getConnection(url); // aquí no cerramos la conexión; la cerraremos donde llamemos al método
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos.");
        }
        return con;
    }

    public static void cargarListado(List<Videojuego> videojuegos) {
        // necesitamos la conexión
        Connection con = conectar(); // llamamos al método conectar
        // Vamos a insertar el alumno en un registro de la base de datos
        // los valores en las consultas parametrizadas siempre se ponen como ?
        String sql = "INSERT INTO videojuego VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
        // creamos la consulta parametrizada
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            // le concretamos los valores
            int registroInsertado = 0, totalInsertados = 0;
            for (int i = 0; i < videojuegos.size(); i++) { // hacemos un for para hacer lo mismo con cada uno de los videojuegos que contiene
                pst.setInt(1, videojuegos.get(i).getId());
                pst.setString(2,videojuegos.get(i).getNombre());
                pst.setString(3,videojuegos.get(i).getPlataforma());
                pst.setString(4,videojuegos.get(i).getGenero());
                // Para la fecha tenemos que hacer un formato
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                pst.setString(5, String.valueOf(videojuegos.get(i).getFechaEstreno().format(formato)));
                pst.setDouble(6, videojuegos.get(i).getPrecio());
                pst.setBoolean(7, videojuegos.get(i).isStock());
                pst.setInt(8, videojuegos.get(i).getUnidades());
                // ahora la ejecutamos
                registroInsertado = pst.executeUpdate();
                totalInsertados += registroInsertado;
            }
            System.out.println("Se han insertado " + totalInsertados + " registros.");

            // antes de salir del método, cerramos la conexión
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Videojuego> obtenerListado() {
        String sql = "SELECT * FROM videojuego ORDER BY id;";
        Connection con;
        Videojuego videojuego = null;
        ArrayList<Videojuego> listado = new ArrayList<>();
        try {
            con = conectar(); // establecemos la conexión
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String fecha = rs.getString("fecha_estreno");
                DateTimeFormatter deStringAFechaJava = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate fechaEnJava = LocalDate.parse(fecha, deStringAFechaJava);

                videojuego = new Videojuego(rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("plataforma"),
                        rs.getString("genero"),
                        fechaEnJava,
                        rs.getDouble("precio"),
                        rs.getBoolean("stock"),
                        rs.getInt("unidades"));
                listado.add(videojuego);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al hacer la consulta.");
        }
        return listado;
    }

    public static void consultarStock(int id) {
        String sql = "SELECT * FROM videojuego WHERE id = ?;";
        Connection con;
        Videojuego videojuego = null;
        boolean hayStock = false;
        ArrayList<Videojuego> listado = new ArrayList<>();
        try {
            con = conectar(); // establecemos la conexión
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                if (rs.getBoolean("stock") == true) {
                    hayStock = true;
                    System.out.println("Hay stock: " + rs.getInt("unidades") + " unidades.");
                }
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al hacer la consulta.");
        }
        // Si llegamos aqui y no ha cambiado la variable hayStock es que no hay stock
        if (!hayStock) {
            System.out.println("No hay stock");
        }

    }
}
