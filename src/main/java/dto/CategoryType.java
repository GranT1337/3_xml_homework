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

    protected List<SubcategoryType> subcategory;
    @XmlAttribute(name = "name", required = true)
    protected String name;

    public List<SubcategoryType> getSubcategory() {
        if (subcategory == null) {
            subcategory = new ArrayList<SubcategoryType>();
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
