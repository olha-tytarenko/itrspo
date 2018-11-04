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

            Source xslDoc = new StreamSource("src/main/java/gamestore.xsl");
            Source xmlDoc = new StreamSource("src/main/java/gamestore.xml");

            String outputFileName = "C:\\Users\\user\\Desktop\\универ\\4курс\\code\\ITPOI\\src\\main\\java\\gamestore.html";
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