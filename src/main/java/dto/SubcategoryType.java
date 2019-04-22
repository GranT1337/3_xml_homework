package dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "subcategoryType", propOrder = {
    "item"
})
public class SubcategoryType {

    private List<ItemType> item;
    @XmlAttribute(name = "name")
    private String name;

    public List<ItemType> getItem() {
        if (item == null) {
            item = new ArrayList<>();
        }
        return this.item;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }


    @Override
    public String toString() {
        return '\n' + "Название подкатегории: " + name + '\n' +
                "Список предметов: " + '\n' + item ;
    }
}
