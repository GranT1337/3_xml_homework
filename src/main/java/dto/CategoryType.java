package dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "categoryType", propOrder = {
    "subcategory"
})
public class CategoryType {

    private List<SubcategoryType> subcategory;
    @XmlAttribute(name = "name")
    private String name;

    public List<SubcategoryType> getSubcategory() {
        if (subcategory == null) {
            subcategory = new ArrayList<>();
        }
        return this.subcategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    @Override
    public String toString() {
        return  "\n" + "Название категории -  " + name + "\n" + "\n" +
                "Подкатегория: " + subcategory  + "\n";
    }
}
