package demo;

import controller.Converter;
import controller.XMLToObjectConverter;
import controller.XMLValidator;
import dto.CategoryType;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

public class DemoService {

    public void execute() {
        List<CategoryType> itemsList;
        Converter converter = new Converter();

        String fileNameXSD = "xml/products.xsd";
        String fileNameXML = "xml/products.xml";

        System.out.println("Проверка XML на валидность");

        if (new XMLValidator().XMLValidation(fileNameXML, fileNameXSD)) {
            try {
                itemsList = new XMLToObjectConverter().converterXMLToObject(fileNameXML);

                dividingLine();
                System.out.println("2. Вывод из XML в Java Object (toString) и разбор связкой StAX");
                dividingLine();
                System.out.println(itemsList);
                dividingLine();

                System.out.println("3.1. Convert XML to Json");
                dividingLine();
                converter.toJSON(itemsList);
                dividingLine();

                System.out.println("3.2. Convert Json to Objects");
                dividingLine();
                System.out.println(converter.toJavaObject());
                dividingLine();

            } catch (JAXBException | IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("XML не прошел валидацию!");
        }
    }

    private void dividingLine() {
        System.out.println("=================================================================");
    }
}
