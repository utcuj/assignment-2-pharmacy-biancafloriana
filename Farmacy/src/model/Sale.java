package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Sale {

    private String medicationName;
    private Integer quantity;
    private String employee;


    public Sale() {
    }

    public Sale(String medicationName, Integer quantity, String employee) {
        this.medicationName = medicationName;
        this.quantity = quantity;
        this.employee = employee;
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

    public String getEmployee() {
        return employee;
    }

    @XmlElement
    public void setEmployee(String employee) {
        this.employee = employee;
    }
}