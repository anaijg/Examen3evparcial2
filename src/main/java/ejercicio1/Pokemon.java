package ejercicio1;

import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @see <a href="https://pokemon.fandom.com/es/wiki/Lista_de_Pok%C3%A9mon_de_Pok%C3%A9mon_GO">
 *     Lista de Pokemon Go</a>
 *
 */

@XmlRootElement
public class Pokemon {

    private String codigo;
    private String generacion;
    private String nombre;
    private String[] tipo;

    public Pokemon(String codigo, String generacion, String nombre, String[] tipo) {
        this.codigo = codigo;
        this.generacion = generacion;
        this.nombre = nombre;
        this.tipo = tipo;
    }


    public Pokemon() {
    }

    public String getCodigo() { return codigo;    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getGeneracion() {
        return generacion;
    }
    public void setGeneracion(String generacion) {
        this.generacion = generacion;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlElementWrapper(name = "tipos")
    public String[] getTipo() {
        return tipo;
    }
    public void setTipo(String[] tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "codigo='" + codigo + '\'' +
                ", generacion='" + generacion + '\'' +
                ", nombre='" + nombre + '\'' +
                ", tipo=" + Arrays.toString(tipo) +
                '}';
    }
}
