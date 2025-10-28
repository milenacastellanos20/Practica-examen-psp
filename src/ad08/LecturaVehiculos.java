package ad08;

import ad07.Alumno;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;

public class LecturaVehiculos {
    public static void main(String[] args) {
        Coche coche1 = new Coche("totoya", "auris", 2016, "verga negra", "1233");
        Coche coche2 = new Coche("Misubicho", "x", 2002, "verga caucasica", "1234");
        Coche coche3 = new Coche("Lambebicho", "aaa", 2013, "verga venezolana", "1235");
        ArrayList<Coche> coches = new ArrayList<>();
        coches.add(coche1);
        coches.add(coche2);
        coches.add(coche3);

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation domImpl = builder.getDOMImplementation();
            Document doc = domImpl.createDocument(null, "xml", null);

            Element raiz = doc.createElement("coches");
            doc.getDocumentElement().appendChild(raiz);

            /*
             * <coches> raiz
             *   <coche> cochesito
             *     <Marca>totoya</Marca>
             *     <Modelo>auris</Modelo>
             *     <anio>2016</anio>
             *     <color>verga negra</color>
             *     <matricula>1233</matricula>
             *   </coche>
             * <coche>
             *     <Marca>totoya</Marca>
             *     <Modelo>auris</Modelo>
             *     <anio>2016</anio>
             *     <color>verga negra</color>
             *     <matricula>1233</matricula>
             *   </coche>
             * </coches>*/
            for (Coche coche : coches) {
                Element cochesito = doc.createElement("coche");
                raiz.appendChild(cochesito);

                Element marca = doc.createElement("Marca");
                Text text = doc.createTextNode(coche.getMarca());//<Marca> totoya </Marca>
                marca.appendChild(text);
                cochesito.appendChild(marca);

                Element modelo = doc.createElement("Modelo");
                Text text2 = doc.createTextNode(coche.getModelo());
                modelo.appendChild(text2);
                cochesito.appendChild(modelo);

                Element anio = doc.createElement("anio");
                Text text3 = doc.createTextNode(String.valueOf(coche.getAnio()));
                anio.appendChild(text3);
                cochesito.appendChild(anio);

                Element color = doc.createElement("color");
                Text text4 = doc.createTextNode(coche.getColor());
                color.appendChild(text4);
                cochesito.appendChild(color);

                Element matricula = doc.createElement("matricula");
                Text text5 = doc.createTextNode(coche.getMatricula());
                matricula.appendChild(text5);
                cochesito.appendChild(matricula);
            }
            Source src = new DOMSource(doc);
            Result result = new StreamResult(new File("coches.xml"));

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(src, result);

            //LECTURA
            NodeList cochesList = doc.getElementsByTagName("coche");
            for (int i = 0; i < cochesList.getLength(); i++) {
                Node cocheNode = cochesList.item(i);
                Element cocheElement = (Element) cocheNode;
                System.out.println(cocheElement.getElementsByTagName("Marca").item(0).getChildNodes().item(0).getNodeValue());
                System.out.println(cocheElement.getElementsByTagName("Modelo").item(0).getChildNodes().item(0).getNodeValue());
                System.out.println(cocheElement.getElementsByTagName("anio").item(0).getChildNodes().item(0).getNodeValue());
                System.out.println(cocheElement.getElementsByTagName("color").item(0).getChildNodes().item(0).getNodeValue());
                System.out.println(cocheElement.getElementsByTagName("matricula").item(0).getChildNodes().item(0).getNodeValue());

            }
        } catch (ParserConfigurationException | TransformerException e) {
            throw new RuntimeException(e);
        }
    }
}
