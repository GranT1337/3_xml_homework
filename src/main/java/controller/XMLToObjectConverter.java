package controller;

import dto.CategoryType;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLToObjectConverter {

    public List<CategoryType> converterXMLToObject(String fileName) throws JAXBException {
        List<CategoryType> itemsList = new ArrayList<>();

        try {
            XMLStreamReader xmlStreamReader = XMLInputFactory
                    .newInstance()
                    .createXMLStreamReader(fileName, new FileInputStream(fileName));

            while (xmlStreamReader.hasNext()) {

                xmlStreamReader.next();

                if (xmlStreamReader.isStartElement() && xmlStreamReader.getLocalName().equals("category")) {
                    JAXBContext jaxbContext = JAXBContext.newInstance(CategoryType.class);
                    Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
                    JAXBElement<CategoryType> jaxbElement = unmarshaller.unmarshal(xmlStreamReader, CategoryType.class);
                    CategoryType items = jaxbElement.getValue();
                    itemsList.add(items);
                }
            }
        } catch (XMLStreamException | IOException ex) {
            ex.printStackTrace();
        }
        return itemsList;
    }
}
