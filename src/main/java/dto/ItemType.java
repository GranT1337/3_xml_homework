package dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;
import java.math.BigInteger;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "itemType", propOrder = {
    "manufacturer",
    "model",
    "dateOfManufacture",
    "color",
    "price",
    "amount"
})
public class ItemType {

    @XmlElement
    @JsonProperty("manufacturer")
    protected String manufacturer;

    @XmlElement
    @JsonProperty("model")
    protected String model;

    @XmlElement(name="date_of_manufacture")
    @JsonProperty("dateOfManufacture")
    protected String dateOfManufacture;

    @XmlElement
    @JsonProperty("color")
    protected String color;

    @XmlElement
    @JsonProperty("price")
    protected BigDecimal price;

    @XmlElement
    @JsonProperty("amount")
    protected BigInteger amount;


    @Override
    public String toString() {
        return  '\n' + "Предмет: " + '\n' +
                "manufacturer - " + manufacturer + '\n' +
                "model  - " + model + '\n' +
                "dateOfManufacture  - " + dateOfManufacture + '\n' +
                "color  - " + color + '\n' +
                "price  - " + price + '\n' +
                "amount  - " + amount + '\n' + '\n' ;
    }
}
