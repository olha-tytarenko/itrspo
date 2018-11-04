package Parsers;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class DomParser {

    public static void main(String[] args) {
        ParseDOM();
    }

    private static void ParseDOM(){

        try {
            File inputFile = new File("C:\\Users\\user\\Desktop\\универ\\4курс\\code\\ITPOI\\src\\main\\java\\gamestore.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("game");
            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                // System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Game id : "
                            + eElement.getAttribute("id"));
                    System.out.println("Game name : "
                            + eElement
                            .getElementsByTagName("title")
                            .item(0)
                            .getTextContent());
                    System.out.println("Developer studio : "
                            + eElement
                            .getElementsByTagName("studio")
                            .item(0)
                            .getTextContent());
                    System.out.println("Outcome date : "
                            + eElement
                            .getElementsByTagName("year")
                            .item(0)
                            .getTextContent());
                    System.out.println("Genre : "
                            + eElement
                            .getElementsByTagName("genre")
                            .item(0)
                            .getTextContent());
                    System.out.println("Platform : "
                            + eElement
                            .getElementsByTagName("platform")
                            .item(0)
                            .getTextContent());
                    System.out.println("Series : "
                            + eElement
                            .getElementsByTagName("series")
                            .item(0)
                            .getTextContent());
                    System.out.println("Engine : "
                            + eElement
                            .getElementsByTagName("engine")
                            .item(0)
                            .getTextContent());
                    System.out.println("Price : "
                            + eElement
                            .getElementsByTagName("price")
                            .item(0)
                            .getTextContent());
                    System.out.println("|||||||||||||||||||||||||||||||||||");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
