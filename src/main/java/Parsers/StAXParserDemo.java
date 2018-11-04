package Parsers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class StAXParserDemo {

    public static void main(String[] args) {
        Parse();
    }

    public static void Parse(){

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

}
