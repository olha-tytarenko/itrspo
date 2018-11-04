package Parsers;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Iterator;

import javax.xml.stream.*;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class StAXParserDemo {

    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
        //DemarshallStAX();
        MarshallStAX();
    }

    public static void DemarshallStAX(){

        boolean bTitle = false;
        boolean bStudio = false;
        boolean bYear = false;
        boolean bGenre = false;
        boolean bPlatform = false;
        boolean bSeries = false;
        boolean bEngine = false;
        boolean bPrice = false;
        boolean bQuantity = false;
        boolean bPromocode = false;
        boolean bRating = false;
        boolean bFirstname = false;
        boolean bLastname = false;

        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLEventReader eventReader =
                    factory.createXMLEventReader(new FileReader("C:\\Users\\user\\Desktop\\универ\\4курс\\code\\ITPOI\\src\\main\\java\\gamestore.xml"));

            while(eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();

                switch(event.getEventType()) {

                    case XMLStreamConstants.START_ELEMENT:
                        StartElement startElement = event.asStartElement();
                        String qName = startElement.getName().getLocalPart();

                        if (qName.equalsIgnoreCase("game")) {
                            Iterator<Attribute> attributes = startElement.getAttributes();
                            String gameId = attributes.next().getValue();
                            System.out.println("Game id : " + gameId);
                        } else if (qName.equalsIgnoreCase("title")) {
                            bTitle = true;
                        } else if (qName.equalsIgnoreCase("studio")) {
                            bStudio = true;
                        } else if (qName.equalsIgnoreCase("year")) {
                            bYear = true;
                        } else if (qName.equalsIgnoreCase("genre")) {
                            bGenre = true;
                        } else if (qName.equalsIgnoreCase("platform")) {
                            bPlatform = true;
                        } else if (qName.equalsIgnoreCase("series")) {
                            bSeries = true;
                        } else if (qName.equalsIgnoreCase("engine")) {
                            bEngine = true;
                        } else if (qName.equalsIgnoreCase("price")) {
                            bPrice = true;
                        } else if (qName.equalsIgnoreCase("quantity")) {
                            bQuantity = true;
                        } else if (qName.equalsIgnoreCase("promocode")) {
                            bPromocode = true;
                        } else if (qName.equalsIgnoreCase("rating")) {
                            bRating = true;
                        } else if (qName.equalsIgnoreCase("firstname")) {
                            bFirstname = true;
                        } else if (qName.equalsIgnoreCase("lastname")) {
                            bLastname = true;
                        }
                        break;

                    case XMLStreamConstants.CHARACTERS:
                        Characters characters = event.asCharacters();
                        if(bTitle) {
                            System.out.println("Title: " + characters.getData());
                            bTitle = false;
                        }
                        if(bStudio) {
                            System.out.println("Studio: " + characters.getData());
                            bStudio = false;
                        }
                        if(bYear) {
                            System.out.println("Outcome date: " + characters.getData());
                            bYear = false;
                        }
                        if(bGenre) {
                            System.out.println("Genre: " + characters.getData());
                            bGenre = false;
                        }
                        if(bPlatform) {
                            System.out.println("Platform: " + characters.getData());
                            bPlatform = false;
                        }
                        if(bSeries) {
                            System.out.println("Marks: " + characters.getData());
                            bSeries = false;
                        }
                        if(bEngine) {
                            System.out.println("Engine: " + characters.getData());
                            bEngine = false;
                        }
                        if(bPrice) {
                            System.out.println("Price: " + characters.getData());
                            bPrice = false;
                        }
                        if(bQuantity) {
                            System.out.println("Quantity: " + characters.getData());
                            bQuantity = false;
                        }
                        if(bPromocode) {
                            System.out.println("Promocode: " + characters.getData());
                            bPromocode = false;
                        }
                        if(bRating) {
                            System.out.println("Rating: " + characters.getData());
                            bRating = false;
                        }
                        if(bFirstname) {
                            System.out.print("Producer: " + characters.getData() + " ");
                            bFirstname = false;
                        }
                        if(bLastname) {
                            System.out.println(characters.getData());
                            bLastname = false;
                            System.out.println("|||||||||||||||||||||||||||||||||||");
                        }
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        EndElement endElement = event.asEndElement();

                        if(endElement.getName().getLocalPart().equalsIgnoreCase("game")) {
                            //System.out.println("End Element : game");
                            System.out.println();
                        }
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

    public static void MarshallStAX() throws FileNotFoundException, XMLStreamException {

        XMLOutputFactory factory =  XMLOutputFactory.newFactory();
        XMLStreamWriter writer = factory.createXMLStreamWriter(new FileOutputStream("C:\\Users\\user\\Desktop\\универ\\4курс\\code\\ITPOI\\src\\main\\java\\StAX.xml"));
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
