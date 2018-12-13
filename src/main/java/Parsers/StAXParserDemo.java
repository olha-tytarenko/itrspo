package Parsers;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

import javax.xml.XMLConstants;
import javax.xml.stream.*;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stax.StAXSource;
import javax.xml.validation.*;

public class StAXParserDemo {

    public static void main(String[] args) throws IOException, XMLStreamException, SAXException {
        DemarshallStAX();
        MarshallStAX();
    }

    public static void DemarshallStAX(){

        boolean bTitle = false;
        boolean bStudio = false;
        boolean bYear = false;
        boolean bGenre = false;
        boolean bPlatform = false;
        boolean bLanguage = false;
        boolean bPrice = false;
        boolean bQuantity = false;
        boolean bPromocode = false;
        boolean bRating = false;
        boolean bFirstname = false;
        boolean bLastname = false;
        boolean bDescription = false;
        boolean bQuality = false;

        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLEventReader eventReader =
                    factory.createXMLEventReader(new FileReader("/Users/user/Documents/ITPOI/src/main/java/moviestore.xml"));

            while(eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();

                switch(event.getEventType()) {

                    case XMLStreamConstants.START_ELEMENT:
                        StartElement startElement = event.asStartElement();
                        String qName = startElement.getName().getLocalPart();

                        if (qName.equalsIgnoreCase("movie")) {
                            Iterator<Attribute> attributes = startElement.getAttributes();
                            String gameId = attributes.next().getValue();
                            System.out.println("Movie id : " + gameId);
                        } else if (qName.equalsIgnoreCase("title")) {
                            bTitle = true;
                        } else if (qName.equalsIgnoreCase("studio")) {
                            bStudio = true;
                        } else if (qName.equalsIgnoreCase("dateOfPublishing")) {
                            bYear = true;
                        } else if (qName.equalsIgnoreCase("genre")) {
                            bGenre = true;
                        } else if (qName.equalsIgnoreCase("language")) {
                            bLanguage = true;
                        } else if (qName.equalsIgnoreCase("price")) {
                            bPrice = true;
                        } else if (qName.equalsIgnoreCase("quantity")) {
                            bQuantity = true;
                        } else if (qName.equalsIgnoreCase("rating")) {
                            bRating = true;
                        } else if (qName.equalsIgnoreCase("videoQuality")) {
                            bQuality = true;
                        } else if (qName.equalsIgnoreCase("firstname")) {
                            bFirstname = true;
                        } else if (qName.equalsIgnoreCase("lastname")) {
                            bLastname = true;
                        } else if (qName.equalsIgnoreCase("description")) {
                            bDescription = true;
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
                        if(bLanguage) {
                            System.out.println("language: " + characters.getData());
                            bLanguage = false;
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
                        if(bQuality) {
                            System.out.println("Video quality: " + characters.getData());
                            bQuality = false;
                        }
                        if(bFirstname) {
                            System.out.print("Producer: " + characters.getData() + " ");
                            bFirstname = false;
                        }
                        if(bDescription) {
                            System.out.print("Description: " + characters.getData() + " ");
                            bDescription = false;
                        }
                        if(bLastname) {
                            System.out.println(characters.getData());
                            bLastname = false;
                            System.out.println("-------------------------");
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

    public static void MarshallStAX() throws IOException, XMLStreamException, SAXException {

        XMLOutputFactory factory =  XMLOutputFactory.newFactory();
        XMLStreamWriter writer = factory.createXMLStreamWriter(new FileOutputStream("/Users/user/Documents/ITPOI/src/main/java/StAX.xml"));
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
        writer.writeCharacters("Descridflk dfjjldv ");
        writer.writeEndElement();
        writer.writeStartElement("firstname");
        writer.writeCharacters("Some");
        writer.writeEndElement();
        writer.writeStartElement("lastname");
        writer.writeCharacters("One");
        writer.writeEndElement();
        writer.writeEndElement();

        writer.writeEndElement();
        writer.writeEndElement();
        writer.writeEndDocument();
    }

}
