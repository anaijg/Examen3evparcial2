package ejercicio1;

import org.w3c.dom.Node;
import org.xml.sax.ContentHandler;

import javax.xml.bind.*;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.attachment.AttachmentMarshaller;
import javax.xml.bind.helpers.AbstractMarshallerImpl;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.Result;
import javax.xml.validation.Schema;
import java.io.File;
import java.io.OutputStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Pokemon p1 = new Pokemon("001", "Primera", "Bulbasaur", new String[]{"planta", "veneno"});
        Pokemon p2 = new Pokemon("002", "Primera", "Ivysaur", new String[]{"planta", "veneno"});
        Pokemon p3 = new Pokemon("003", "Primera", "Venusaur", new String[]{"planta", "veneno"});

        hacerXMLPokemon(p1, "Bulbasaur");
        hacerXMLPokemon(p2, "Ivysaur");
        hacerXMLPokemon(p3, "Venusaur");

        String rutaFichero1 = "src\\main\\java\\ejercicio1\\Bulbasaur.xml";
        String rutaFichero2 = "src\\main\\java\\ejercicio1\\Ivysaur.xml";
        String rutaFichero3 = "src\\main\\java\\ejercicio1\\Venusaur.xml";
        ArrayList<String> rutas = new ArrayList<>();
        rutas.add(rutaFichero1);
        rutas.add(rutaFichero2);
        rutas.add(rutaFichero3);
        hacerXMLPokedex(rutas);


    }

    public static void hacerXMLPokemon(Pokemon pokemon, String nombre) {
        // Creamos un objeto file con la ruta
        File f = new File("src\\main\\java\\ejercicio1\\" + nombre + ".xml");
        try {
            JAXBContext contexto = JAXBContext.newInstance(Pokemon.class);
            Marshaller m = contexto.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m.marshal(pokemon, f);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static void hacerXMLPokedex(ArrayList<String> rutas){
        // Primero cargamos los ficheros XML y los convertimos a objetos
        ArrayList<Pokemon> pokemons = new ArrayList<>();
        try {
            JAXBContext contexto = JAXBContext.newInstance(Pokemon.class);
            Unmarshaller um = contexto.createUnmarshaller();
            for (int i = 0; i < rutas.size(); i++) {
                File f = new File(rutas.get(i));
                Pokemon p = (Pokemon) um.unmarshal(f);
                System.out.println(p.toString());
                pokemons.add(p);
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        // Creamos un objeto Pokedex con esta lista
        Pokedex pkdx = new Pokedex(pokemons);

        // A continuación creamos el XML con la lista creada
        File f = new File("src\\main\\java\\ejercicio1\\pokedex.xml");
        try {
            JAXBContext contexto = JAXBContext.newInstance(Pokedex.class);
            Marshaller m = contexto.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m.marshal(pkdx, f);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}
