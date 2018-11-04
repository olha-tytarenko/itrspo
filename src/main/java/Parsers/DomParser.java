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
                    System.out.println("Quantity : "
                            + eElement
                            .getElementsByTagName("quantity")
                            .item(0)
                            .getTextContent());
                    System.out.println("Promocode : "
                            + eElement
                            .getElementsByTagName("promocode")
                            .item(0)
                            .getTextContent());
                    System.out.println("Rating : "
                            + eElement
                            .getElementsByTagName("rating")
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
                    System.out.println("|||||||||||||||||||||||||||||||||||");
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

        Element root = doc.createElement ("games");
        doc.appendChild(root);

        Element root2 = doc.createElement ("gameStore");
        root.appendChild(root2);

        Element game = doc.createElement ("game");
        game.setAttribute("id", "1");
        root2.appendChild(game);

        Element title = doc.createElement("title");
        title.setTextContent("Assassin's Creed Odyssey");
        game.appendChild(title);

        Element studio = doc.createElement("studio");
        studio.setTextContent("Ubisoft");
        game.appendChild(studio);

        Element year = doc.createElement("year");
        year.setTextContent("2018-10-05");
        game.appendChild(year);

        Element genre = doc.createElement("genre");
        genre.setTextContent("Action, RPG");
        game.appendChild(genre);

        Element platform = doc.createElement("platform");
        platform.setTextContent("PlayStation 4, Xbox One, Nintendo Switch, Microsoft Windows");
        game.appendChild(platform);

        Element series = doc.createElement("series");
        series.setTextContent("Assassin’s Creed");
        game.appendChild(series);

        Element engine = doc.createElement("engine");
        engine.setTextContent("Anvil engine");
        game.appendChild(engine);

        Element price = doc.createElement("price");
        price.setTextContent("123.45");
        game.appendChild(price);

        Element quantity = doc.createElement("quantity");
        quantity.setTextContent("1234");
        game.appendChild(quantity);

        Element promocode = doc.createElement("promocode");
        promocode.setTextContent("str12340");
        game.appendChild(promocode);

        Element rating = doc.createElement("rating");
        rating.setTextContent("Awesome");
        game.appendChild(rating);

        Element firstname = doc.createElement("firstname");
        firstname.setTextContent("Some");
        game.appendChild(firstname);

        Element lastname = doc.createElement("lastname");
        lastname.setTextContent("One");
        game.appendChild(lastname);

        Element game2 = doc.createElement ("game");
        game2.setAttribute("id", "2");
        root2.appendChild(game2);

        Element title2 = doc.createElement("title");
        title2.setTextContent("Call of Duty: Black Ops 4");
        game2.appendChild(title2);

        Element studio2 = doc.createElement("studio");
        studio2.setTextContent("Activision");
        game2.appendChild(studio2);

        Element year2 = doc.createElement("year");
        year2.setTextContent("2018-12-10");
        game2.appendChild(year2);

        Element genre2 = doc.createElement("genre");
        genre2.setTextContent("Royal Battle, Action, Shooter, Royal Battle");
        game2.appendChild(genre2);

        Element platform2 = doc.createElement("platform");
        platform2.setTextContent("PlayStation 4, Xbox One, Windows");
        game2.appendChild(platform2);

        Element series2 = doc.createElement("series");
        series2.setTextContent("Call of Duty");
        game2.appendChild(series2);

        Element engine2 = doc.createElement("engine");
        engine2.setTextContent("Modified IW 3.0");
        game2.appendChild(engine2);

        Element price2 = doc.createElement("price");
        price2.setTextContent("59.99");
        game2.appendChild(price2);

        Element quantity2 = doc.createElement("quantity");
        quantity2.setTextContent("1234");
        game2.appendChild(quantity2);

        Element promocode2 = doc.createElement("promocode");
        promocode2.setTextContent("str12340");
        game2.appendChild(promocode2);

        Element rating2 = doc.createElement("rating");
        rating2.setTextContent("Awesome");
        game2.appendChild(rating2);

        Element firstname2 = doc.createElement("firstname");
        firstname2.setTextContent("Who");
        game2.appendChild(firstname2);

        Element lastname2 = doc.createElement("lastname");
        lastname2.setTextContent("AMI");
        game2.appendChild(lastname2);


        Element game3 = doc.createElement ("game");
        game3.setAttribute("id", "3");
        root2.appendChild(game3);

        Element title3 = doc.createElement("title");
        title3.setTextContent("Destiny 2");
        game3.appendChild(title3);

        Element studio3 = doc.createElement("studio");
        studio3.setTextContent("Activision");
        game3.appendChild(studio3);

        Element year3 = doc.createElement("year");
        year3.setTextContent("2017-09-06");
        game3.appendChild(year3);

        Element genre3 = doc.createElement("genre");
        genre3.setTextContent("Action, Shooter, Science-fiction");
        game3.appendChild(genre3);

        Element platform3 = doc.createElement("platform");
        platform3.setTextContent("PlayStation 4, Xbox One, Windows");
        game3.appendChild(platform3);

        Element series3 = doc.createElement("series");
        series3.setTextContent("Destiny");
        game3.appendChild(series3);

        Element engine3 = doc.createElement("engine");
        engine3.setTextContent("Tiger Engine");
        game3.appendChild(engine3);

        Element price3 = doc.createElement("price");
        price2.setTextContent("14.99");
        game2.appendChild(price2);

        Element quantity3 = doc.createElement("quantity");
        quantity3.setTextContent("10");
        game3.appendChild(quantity3);

        Element promocode3 = doc.createElement("promocode");
        promocode3.setTextContent("str12340");
        game3.appendChild(promocode3);

        Element rating3 = doc.createElement("rating");
        rating3.setTextContent("Awesome");
        game3.appendChild(rating3);

        Element firstname3 = doc.createElement("firstname");
        firstname3.setTextContent("IDONT");
        game3.appendChild(firstname3);

        Element lastname3 = doc.createElement("lastname");
        lastname3.setTextContent("KNOW");
        game3.appendChild(lastname3);


        File file = new File("C:\\Users\\user\\Desktop\\универ\\4курс\\code\\ITPOI\\src\\main\\java\\DOM.xml");

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(new DOMSource(doc), new StreamResult(file));
    }
}
