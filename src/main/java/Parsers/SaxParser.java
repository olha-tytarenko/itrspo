package Parsers;
import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxParser {

    public static void main(String[] args) {
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
    }

    @Override
    public void endElement(String uri,
                           String localName, String qName) throws SAXException {

        if (qName.equalsIgnoreCase("game")) {
            System.out.println("End Element :" + qName);
        }
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
        }
    }
}
