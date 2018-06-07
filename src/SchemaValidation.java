import org.xml.sax.SAXException;

import javax.xml.XMLConstants;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.FileNotFoundException;
import java.io.IOException;

class SchemaValidation {
    public static void main(String[] args) {
        try {

            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new Source[]{
                new StreamSource("/Path/to/Base/Schema/File")
            });

            Validator validator = schema.newValidator();
            validator.validate(new StreamSource("/Path/to/XML/File"));
        } catch (FileNotFoundException ex) {
            System.out.println("File not found exception");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("IOException");
            ex.printStackTrace();
        } catch (SAXException ex) {
            System.out.println("SAX exception");
            ex.printStackTrace();
        }
    }
}