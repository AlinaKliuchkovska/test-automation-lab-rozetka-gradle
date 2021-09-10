package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "rozetkaFilter")
@XmlAccessorType(XmlAccessType.FIELD)
public class RozetkaFilter {
    String group;
    String sortingType;
    String brandName;

    public String getGroup() {
        return group;
    }

    public String getSortingType() {
        return sortingType;
    }

    public String getBrandName() {
        return brandName;
    }
}