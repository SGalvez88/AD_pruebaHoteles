package lecturapruebas;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import lecturapruebas.classes.Hotel;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class LecturaPruebas {

    private static Hotel hotel;
    private static ArrayList<Hotel> hoteles;

    public static void main(String[] args) throws IOException, SAXException {
        hoteles = new ArrayList<>();

        int id = 0;
        String nombre = null;
        String direccion = null;
        float precioNoche = 0.0f;

        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder DocumentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = DocumentBuilder.parse(new File("src\\resources\\Hoteles.xml"));

            NodeList listaHoteles = document.getElementsByTagName("hotel");

            for (int i = 0; i < listaHoteles.getLength(); i++) {

                NodeList listaAlojamiento = listaHoteles.item(i).getChildNodes();

                for (int j = 0; j < listaAlojamiento.getLength(); j++) {

                    if (listaAlojamiento.item(j).getNodeType() == Node.ELEMENT_NODE) {

                        if (listaAlojamiento.item(j).getNodeName().equals("id")) {
                            id = Integer.parseInt(listaAlojamiento.item(j).getTextContent());

                        } else if (listaAlojamiento.item(j).getNodeName().equals("nombre")) {
                            nombre = listaAlojamiento.item(j).getTextContent();

                        } else if (listaAlojamiento.item(j).getNodeName().equals("direccion")) {
                            direccion = listaAlojamiento.item(j).getTextContent();

                        } else if (listaAlojamiento.item(j).getNodeName().equals("costeNoche")) {
                            precioNoche = Float.parseFloat(listaAlojamiento.item(j).getTextContent());
                        }
                    }
                }
                hotel = new Hotel(id, nombre, direccion, precioNoche);
                hoteles.add(hotel);
            }
            mostrarHoteles();
            
        } catch (ParserConfigurationException exception) {
            exception.getMessage();
        }
    }

    public static void mostrarHoteles() {
        for (Hotel hotel : hoteles) {
            System.out.println(hotel.toString());
        }
    }
}
