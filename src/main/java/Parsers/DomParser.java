package Parsers;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class DomParser {

    public static void main(String[] args) throws TransformerException, ParserConfigurationException {
        DemarshallDOM();
        MarshallDOM();
    }

    private static void DemarshallDOM(){

        try {
            File inputFile = new File("/Users/user/Documents/ITPOI/src/main/java/moviestore.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("movie");
            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                // System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Movie id : "
                            + eElement.getAttribute("id"));
                    System.out.println("Title: "
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
                            .getElementsByTagName("dateOfPublishing")
                            .item(0)
                            .getTextContent());
                    System.out.println("Genre : "
                            + eElement
                            .getElementsByTagName("genre")
                            .item(0)
                            .getTextContent());
                    System.out.println("language : "
                            + eElement
                            .getElementsByTagName("language")
                            .item(0)
                            .getTextContent());
                    System.out.println("Price : "
                            + eElement
                            .getElementsByTagName("price")
                            .item(0)
                            .getTextContent());
                    System.out.println("Quantity : "
                            + eElement
                            .getElementsByTagName("quantity")
                            .item(0)
                            .getTextContent());
                    System.out.println("Rating : "
                            + eElement
                            .getElementsByTagName("rating")
                            .item(0)
                            .getTextContent());
                    System.out.println("Video quality : "
                            + eElement
                            .getElementsByTagName("videoQuality")
                            .item(0)
                            .getTextContent());
                    System.out.print("Producer : "
                            + eElement
                            .getElementsByTagName("firstname")
                            .item(0)
                            .getTextContent() + " ");
                    System.out.println(eElement
                            .getElementsByTagName("lastname")
                            .item(0)
                            .getTextContent());
                    System.out.println(eElement
                            .getElementsByTagName("description")
                            .item(0)
                            .getTextContent());
                    System.out.println("-------------------------");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void MarshallDOM() throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        Document doc = factory.newDocumentBuilder().newDocument();

        Element root = doc.createElement ("movies");
        doc.appendChild(root);

        Element root2 = doc.createElement ("movieStore");
        root.appendChild(root2);

        Element game = doc.createElement ("movie");
        game.setAttribute("id", "1");
        root2.appendChild(game);

        Element title = doc.createElement("title");
        title.setTextContent("Assassin's Creed Odyssey");
        game.appendChild(title);

        Element studio = doc.createElement("studio");
        studio.setTextContent("Ubisoft");
        game.appendChild(studio);

        Element dateOfPublishing = doc.createElement("dateOfPublishing");
        dateOfPublishing.setTextContent("2018-10-05");
        game.appendChild(dateOfPublishing);

        Element genre = doc.createElement("genre");
        genre.setTextContent("Action, RPG");
        game.appendChild(genre);

        Element language = doc.createElement("language");
        language.setTextContent("Anvil engine");
        game.appendChild(language);

        Element price = doc.createElement("price");
        price.setTextContent("123.45");
        game.appendChild(price);

        Element quantity = doc.createElement("quantity");
        quantity.setTextContent("1234");
        game.appendChild(quantity);

        Element rating = doc.createElement("rating");
        rating.setTextContent("Awesome");
        game.appendChild(rating);

        Element videoQuality = doc.createElement("videoQuality");
        videoQuality.setTextContent("BlueRay");
        game.appendChild(videoQuality);

        Element firstname = doc.createElement("firstname");
        firstname.setTextContent("Some");
        game.appendChild(firstname);

        Element lastname = doc.createElement("lastname");
        lastname.setTextContent("One");
        game.appendChild(lastname);

        Element description = doc.createElement("description");
        description.setTextContent("Description");
        game.appendChild(description);

        File file = new File("/Users/user/Documents/ITPOI/src/main/java/DOM.xml");

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(new DOMSource(doc), new StreamResult(file));
    }
}
