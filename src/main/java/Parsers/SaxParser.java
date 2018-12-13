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
            File inputFile = new File("/Users/user/Documents/ITPOI/src/main/java/moviestore.xml");
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
    private boolean bLanguage = false;
    private boolean bPrice = false;
    private boolean bQuantity = false;
    private boolean bPromocode = false;
    private boolean bRating = false;
    private boolean bFirstname = false;
    private boolean bLastname = false;
    private boolean bDescription = false;
    private boolean bQuality = false;

    @Override
    public void startElement(
            String uri, String localName, String qName, Attributes attributes)
            throws SAXException {

        if (qName.equalsIgnoreCase("movie")) {
            String gameId = attributes.getValue("id");
            System.out.println("Movie id : " + gameId);
        } else if (qName.equalsIgnoreCase("Movie name")) {
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
        else if (qName.equalsIgnoreCase("language")) {
            bLanguage = true;
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
        else if (qName.equalsIgnoreCase("videoQuality")) {
            bQuality = true;
        }
        else if (qName.equalsIgnoreCase("Firstname")) {
            bFirstname = true;
        }
        else if (qName.equalsIgnoreCase("Lastname")) {
            bLastname = true;
        }
        else if (qName.equalsIgnoreCase("Description")) {
            bDescription = true;
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
            System.out.println("Movie title : " + new String(ch, start, length));
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
        } else if (bLanguage) {
            System.out.println("Language : " + new String(ch, start, length));
            bLanguage = false;
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
        } else if (bQuality) {
            System.out.println("Video quality : " + new String(ch, start, length));
            bQuality = false;
        } else if (bFirstname) {
            System.out.print("Producer : " + new String(ch, start, length) + " ");
            bFirstname = false;
        } else if (bDescription) {
            System.out.print("Description : " + new String(ch, start, length) + " ");
            bDescription = false;
        } else if (bLastname) {
            System.out.println(new String(ch, start, length));
            bLastname = false;
            System.out.println("----------------------");
        }
    }

    public static void MarshallSAX() throws FileNotFoundException, XMLStreamException {

        XMLOutputFactory factory =  XMLOutputFactory.newFactory();
        XMLStreamWriter writer = factory.createXMLStreamWriter(new FileOutputStream("/Users/user/Documents/ITPOI/src/main/java/SAX.xml"));
        writer.writeStartDocument();
        writer.writeStartElement("movies");
        writer.writeStartElement("movieStore");

        writer.writeStartElement("movie");
        writer.writeAttribute("id","1");

        writer.writeStartElement("title");
        writer.writeCharacters("Assassin's Creed Odyssey");
        writer.writeEndElement();
        writer.writeStartElement("studio");
        writer.writeCharacters("Ubisoft");
        writer.writeEndElement();
        writer.writeStartElement("dateOfPublishing");
        writer.writeCharacters("2018-10-05");
        writer.writeEndElement();
        writer.writeStartElement("genre");
        writer.writeCharacters("Action, RPG");
        writer.writeEndElement();
        writer.writeStartElement("language");
        writer.writeCharacters("Anvil engine");
        writer.writeEndElement();
        writer.writeStartElement("price");
        writer.writeCharacters("123.45");
        writer.writeEndElement();
        writer.writeStartElement("quantity");
        writer.writeCharacters("1234");
        writer.writeEndElement();
        writer.writeStartElement("rating");
        writer.writeCharacters("Awesome");
        writer.writeEndElement();
        writer.writeStartElement("videoQuality");
        writer.writeCharacters("BlueRay");
        writer.writeEndElement();
        writer.writeStartElement("description");
        writer.writeCharacters("Deflksdlvsdfj sdfjjldsf");
        writer.writeEndElement();
        writer.writeStartElement("firstname");
        writer.writeCharacters("Some");
        writer.writeEndElement();
        writer.writeStartElement("lastname");
        writer.writeCharacters("One");
        writer.writeEndElement();
        writer.writeEndElement();

        writer.writeEndDocument();


    }

}
