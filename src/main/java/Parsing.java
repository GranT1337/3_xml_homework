
import controller.Converter;
import controller.XMLToObjectConverter;
import controller.XMLValidator;
import dto.CategoryType;

import javax.xml.bind.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parsing {

    private static Converter converter = new Converter();

    public static void main(String[] args) throws IOException {

        final String fileNameXML = "xml/products.xml";
        final String fileNameXSD = "xml/products.xsd";

        List<CategoryType> itemsList = new ArrayList<>();

        System.out.println("Проверка XML на валидность");
        if(new XMLValidator().XMLValidation(fileNameXML, fileNameXSD)) {
            try {
                itemsList = new XMLToObjectConverter().converterXMLToObject(fileNameXML);
            } catch (JAXBException e) {
                e.printStackTrace();
            }

            System.out.println("=================================================================");
            System.out.println("2. Вывод из XML в Java Object (toString) и разбор связкой StAX");
            System.out.println("=================================================================");
            System.out.println(itemsList);
            System.out.println("=================================================================");

            System.out.println("3.1. Convert XML to Json");
            System.out.println("=================================================================");
            converter.toJSON(itemsList);
            System.out.println("=================================================================");

            System.out.println("3.2. Convert Json to Objects");
            System.out.println("=================================================================");
            System.out.println(converter.toJavaObject());
            System.out.println("=================================================================");
        } else {
            System.out.println("XML не прошел валидацию!");
        }
    }
}
