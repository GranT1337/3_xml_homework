package controller;

import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class XMLValidator {
    public boolean XMLValidation(String xmlpath, String schemapath) {
        try {
            SchemaFactory factory = SchemaFactory
                    .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new StreamSource(
                    new FileInputStream(schemapath)));

            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new FileInputStream(xmlpath)));
            System.out.println("Проверка прошла успешно!");
            return true;
        } catch (SAXException e) {
            System.out.println("Exception: " + e.getMessage());
            e.printStackTrace();
            return false;
        } catch (IOException ioe) {
            System.out.println("Exception: " + ioe.getMessage());
            ioe.printStackTrace();
            return false;
        }

    }
}
