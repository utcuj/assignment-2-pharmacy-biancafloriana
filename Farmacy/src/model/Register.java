package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Register {


    List<Sale> sales = new ArrayList<>();

    public List<Sale> getSales() {
        return sales;
    }
    @XmlElement(name = "sale")
    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }

    public void addSell(Sale s) {
        sales.add(s);
    }
}
