package ejercicio1;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement
public class Pokedex {

    @XmlElement(name="pokemon")
    ArrayList<Pokemon> pokedex = new ArrayList<>();

    public Pokedex() {
    }

    public Pokedex(ArrayList<Pokemon> pokedex) {
        this.pokedex = pokedex;
    }
}
