package xmltohmtlconverter;

import java.io.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;

public class Driver {

    public static void main(String[] args)
    {
        try
        {
            TransformerFactory tFactory = TransformerFactory.newInstance();

            Source xslDoc = new StreamSource("src/main/java/moviestore.xsl");
            Source xmlDoc = new StreamSource("src/main/java/moviestore.xml");

            String outputFileName = "src/main/test.html";
            OutputStream htmlFile = new FileOutputStream(outputFileName);

            Transformer transformer = tFactory.newTransformer(xslDoc);
            transformer.transform(xmlDoc, new StreamResult(htmlFile));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}