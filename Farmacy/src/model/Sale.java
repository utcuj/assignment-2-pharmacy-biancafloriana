package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
public class Sale {

    private String medicationName;
    private Integer quantity;
    private Date data;

    public Sale(String medicationName, Integer quantity, Date data) {
        this.medicationName = medicationName;
        this.quantity = quantity;
        this.data = data;
    }

    public String getMedicationName() {
        return medicationName;
    }
    @XmlElement
    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

    public Integer getQuantity() {
        return quantity;
    }
    @XmlElement
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getData() {
        return data;
    }
    @XmlElement
    public void setData(Date data) {
        this.data = data;
    }
}
