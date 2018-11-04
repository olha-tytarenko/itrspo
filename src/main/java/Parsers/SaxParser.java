package Parsers;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import static Parsers.UserHandler.MarshallSAX;

public class SaxParser {

    private static void DemarshallSAX(){
        try {
            File inputFile = new File("C:\\Users\\user\\Desktop\\универ\\4курс\\code\\ITPOI\\src\\main\\java\\gamestore.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            UserHandler userhandler = new UserHandler();
            saxParser.parse(inputFile, userhandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {

        DemarshallSAX();
        MarshallSAX();

    }
}

class UserHandler extends DefaultHandler {

    private boolean bTitle = false;
    private boolean bStudio = false;
    private boolean bYear = false;
    private boolean bGenre = false;
    private boolean bPlatform = false;
    private boolean bSeries = false;
    private boolean bEngine = false;
    private boolean bPrice = false;
    private boolean bQuantity = false;
    private boolean bPromocode = false;
    private boolean bRating = false;
    private boolean bFirstname = false;
    private boolean bLastname = false;

    @Override
    public void startElement(
            String uri, String localName, String qName, Attributes attributes)
            throws SAXException {

        if (qName.equalsIgnoreCase("game")) {
            String gameId = attributes.getValue("id");
            System.out.println("Game id : " + gameId);
        } else if (qName.equalsIgnoreCase("Game name")) {
            bTitle = true;
        } else if (qName.equalsIgnoreCase("Developer studio")) {
            bStudio = true;
        } else if (qName.equalsIgnoreCase("Outcome date")) {
            bYear = true;
        }
        else if (qName.equalsIgnoreCase("Genre")) {
            bGenre = true;
        }
        else if (qName.equalsIgnoreCase("Platform")) {
            bPlatform = true;
        }
        else if (qName.equalsIgnoreCase("Series")) {
            bSeries = true;
        }
        else if (qName.equalsIgnoreCase("Engine")) {
            bEngine = true;
        }
        else if (qName.equalsIgnoreCase("Price")) {
            bPrice = true;
        }
        else if (qName.equalsIgnoreCase("Quantity")) {
            bQuantity = true;
        }
        else if (qName.equalsIgnoreCase("Promocode")) {
            bPromocode = true;
        }
        else if (qName.equalsIgnoreCase("Rating")) {
            bRating = true;
        }
        else if (qName.equalsIgnoreCase("Firstname")) {
            bFirstname = true;
        }
        else if (qName.equalsIgnoreCase("Lastname")) {
            bLastname = true;
        }
    }

    @Override
    public void endElement(String uri,
                           String localName, String qName) throws SAXException {

       // if (qName.equalsIgnoreCase("game")) {
        //    System.out.println("End Element :" + qName);
       // }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {

        if (bTitle) {
            System.out.println("Game name : " + new String(ch, start, length));
            bTitle = false;
        } else if (bStudio) {
            System.out.println("Last Name : " + new String(ch, start, length));
            bStudio = false;
        } else if (bYear) {
            System.out.println("Outcome date : " + new String(ch, start, length));
            bYear = false;
        } else if (bGenre) {
            System.out.println("Genre : " + new String(ch, start, length));
            bGenre = false;
        } else if (bPlatform) {
            System.out.println("Platform : " + new String(ch, start, length));
            bPlatform = false;
        } else if (bSeries) {
            System.out.println("Series : " + new String(ch, start, length));
            bSeries = false;
        } else if (bEngine) {
            System.out.println("Engine : " + new String(ch, start, length));
            bEngine = false;
        } else if (bPrice) {
            System.out.println("Price : " + new String(ch, start, length));
            bPrice = false;
        } else if (bQuantity) {
            System.out.println("Quantity : " + new String(ch, start, length));
            bQuantity = false;
        } else if (bPromocode) {
            System.out.println("Promocode : " + new String(ch, start, length));
            bPromocode = false;
        } else if (bRating) {
            System.out.println("Rating : " + new String(ch, start, length));
            bRating = false;
        } else if (bFirstname) {
            System.out.print("Producer : " + new String(ch, start, length) + " ");
            bFirstname = false;
        } else if (bLastname) {
            System.out.println(new String(ch, start, length));
            bLastname = false;
            System.out.println("|||||||||||||||||||||||||||||||||||");
        }
    }

    public static void MarshallSAX() throws FileNotFoundException, XMLStreamException {

        XMLOutputFactory factory =  XMLOutputFactory.newFactory();
        XMLStreamWriter writer = factory.createXMLStreamWriter(new FileOutputStream("C:\\Users\\user\\Desktop\\универ\\4курс\\code\\ITPOI\\src\\main\\java\\SAX.xml"));
        writer.writeStartDocument();
        writer.writeStartElement("games");
        writer.writeStartElement("gameStore");

        writer.writeStartElement("game");
        writer.writeAttribute("id","1");

        writer.writeStartElement("title");
        writer.writeCharacters("Assassin's Creed Odyssey");
        writer.writeEndElement();
        writer.writeStartElement("studio");
        writer.writeCharacters("Ubisoft");
        writer.writeEndElement();
        writer.writeStartElement("year");
        writer.writeCharacters("2018-10-05");
        writer.writeEndElement();
        writer.writeStartElement("genre");
        writer.writeCharacters("Action, RPG");
        writer.writeEndElement();
        writer.writeStartElement("platform");
        writer.writeCharacters("PlayStation 4, Xbox One, Nintendo Switch, Microsoft Windows");
        writer.writeEndElement();
        writer.writeStartElement("series");
        writer.writeCharacters("Assassin’s Creed");
        writer.writeEndElement();
        writer.writeStartElement("engine");
        writer.writeCharacters("Anvil engine");
        writer.writeEndElement();
        writer.writeStartElement("price");
        writer.writeCharacters("123.45");
        writer.writeEndElement();
        writer.writeStartElement("quantity");
        writer.writeCharacters("1234");
        writer.writeEndElement();
        writer.writeStartElement("promocode");
        writer.writeCharacters("str12340");
        writer.writeEndElement();
        writer.writeStartElement("rating");
        writer.writeCharacters("Awesome");
        writer.writeEndElement();
        writer.writeStartElement("firstname");
        writer.writeCharacters("Some");
        writer.writeEndElement();
        writer.writeStartElement("lastname");
        writer.writeCharacters("One");
        writer.writeEndElement();
        writer.writeEndElement();

        writer.writeStartElement("game");
        writer.writeAttribute("id","2");

        writer.writeStartElement("title");
        writer.writeCharacters("Call of Duty: Black Ops 4");
        writer.writeEndElement();
        writer.writeStartElement("studio");
        writer.writeCharacters("Activision");
        writer.writeEndElement();
        writer.writeStartElement("year");
        writer.writeCharacters("2018-12-10");
        writer.writeEndElement();
        writer.writeStartElement("genre");
        writer.writeCharacters("Royal Battle, Action, Shooter, Royal Battle");
        writer.writeEndElement();
        writer.writeStartElement("platform");
        writer.writeCharacters("PlayStation 4, Xbox One, Windows");
        writer.writeEndElement();
        writer.writeStartElement("series");
        writer.writeCharacters("Call of Duty");
        writer.writeEndElement();
        writer.writeStartElement("engine");
        writer.writeCharacters("Modified IW 3.0");
        writer.writeEndElement();
        writer.writeStartElement("price");
        writer.writeCharacters("59.99");
        writer.writeEndElement();
        writer.writeStartElement("quantity");
        writer.writeCharacters("1234");
        writer.writeEndElement();
        writer.writeStartElement("promocode");
        writer.writeCharacters("str12340");
        writer.writeEndElement();
        writer.writeStartElement("rating");
        writer.writeCharacters("Awesome");
        writer.writeEndElement();
        writer.writeStartElement("firstname");
        writer.writeCharacters("Who");
        writer.writeEndElement();
        writer.writeStartElement("lastname");
        writer.writeCharacters("AMI");
        writer.writeEndElement();
        writer.writeEndElement();

        writer.writeStartElement("game");
        writer.writeAttribute("id","3");

        writer.writeStartElement("title");
        writer.writeCharacters("Destiny 2");
        writer.writeEndElement();
        writer.writeStartElement("studio");
        writer.writeCharacters("Activision");
        writer.writeEndElement();
        writer.writeStartElement("year");
        writer.writeCharacters("2017-09-06");
        writer.writeEndElement();
        writer.writeStartElement("genre");
        writer.writeCharacters("Action, Shooter, Science-fiction");
        writer.writeEndElement();
        writer.writeStartElement("platform");
        writer.writeCharacters("PlayStation 4, Xbox One, Windows");
        writer.writeEndElement();
        writer.writeStartElement("series");
        writer.writeCharacters("Destiny");
        writer.writeEndElement();
        writer.writeStartElement("engine");
        writer.writeCharacters("Tiger Engine");
        writer.writeEndElement();
        writer.writeStartElement("price");
        writer.writeCharacters("14.99");
        writer.writeEndElement();
        writer.writeStartElement("quantity");
        writer.writeCharacters("10");
        writer.writeEndElement();
        writer.writeStartElement("promocode");
        writer.writeCharacters("str12340");
        writer.writeEndElement();
        writer.writeStartElement("rating");
        writer.writeCharacters("Awesome");
        writer.writeEndElement();
        writer.writeStartElement("firstname");
        writer.writeCharacters("IDONT");
        writer.writeEndElement();
        writer.writeStartElement("lastname");
        writer.writeCharacters("KNOW");
        writer.writeEndElement();
        writer.writeEndElement();

        writer.writeEndElement();
        writer.writeEndElement();
        writer.writeEndDocument();


    }

}
