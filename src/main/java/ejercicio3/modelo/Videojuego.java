package ejercicio3.modelo;

import java.time.LocalDate;

public class Videojuego {
    private int id;
    private String nombre;
    private String plataforma;
    private String genero;
    private LocalDate fechaEstreno;
    private double precio;
    private boolean stock;
    private int unidades;

    public Videojuego(int id, String nombre, String plataforma, String genero, LocalDate fechaEstreno, double precio, boolean stock, int unidades) {
        this.id = id;
        this.nombre = nombre;
        this.plataforma = plataforma;
        this.genero = genero;
        this.fechaEstreno = fechaEstreno;
        this.precio = precio;
        this.stock = stock;
        this.unidades = unidades;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPlataforma() {
        return plataforma;
    }
    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }

    public LocalDate getFechaEstreno() {
        return fechaEstreno;
    }
    public void setFechaEstreno(LocalDate fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isStock() {
        return stock;
    }
    public void setStock(boolean stock) {
        this.stock = stock;
    }

    public int getUnidades() {
        return unidades;
    }
    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    @Override
    public String toString() {
        String enStock;
        if (this.stock) {
            enStock = "sí:" + unidades + " unidades.";
        } else {
            enStock = "no.";
        }
        return id +
                " -" + nombre +
                ", plataforma=" + plataforma +
                ", genero='" + genero +
                ", fechaEstreno=" + fechaEstreno +
                ", precio=" + precio +
                "€, stock=" + enStock;
    }
}
