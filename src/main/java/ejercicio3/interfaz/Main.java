package ejercicio3.interfaz;

import ejercicio3.dao.VideojuegoDAO;
import ejercicio3.modelo.Videojuego;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Videojuego> videojuegos = new ArrayList<>();
        videojuegos.add(new Videojuego(1, "Evil Dead: The Game", "PC", "Accion", LocalDate.of(2022, 05, 13), 39.95, true, 50));
        videojuegos.add(new Videojuego(2, "Trek to Yomi", "PS5", "Accion", LocalDate.of(2022, 05, 5), 19.99, true, 30));
        videojuegos.add(new Videojuego(3, "King Arthur: Knight's Tale", "PC", "Rol", LocalDate.of(2022, 04, 26), 44.99, false, 0));
        videojuegos.add(new Videojuego(4, "Eiyuden Chronicles: Rising", "PS5", "Estrategia", LocalDate.of(2022, 05, 10), 14.99, false, 0));
        videojuegos.add(new Videojuego(5, "Chaos Gate - Daemonhunters", "PC", "Rol", LocalDate.of(2022, 05, 10), 14.99, true, 10));

        System.out.println("Insertamos los registros...");
        //VideojuegoDAO.cargarListado(videojuegos); // descomentar para cargar el listado

        System.out.println("\n");
        //ArrayList<Videojuego> listado = VideojuegoDAO.obtenerListado(); // descomentar las dos líneas para mostrar el listado
        // listado.stream().forEach(videojuego -> System.out.println(videojuego));
        System.out.println("Consultamos el stock para el id=1");
        VideojuegoDAO.consultarStock(1); // respuesta: hay stock
        System.out.println("Consultamos el stock para el id=3");
        VideojuegoDAO.consultarStock(3); // respuesta: no hay stock
    }


}
