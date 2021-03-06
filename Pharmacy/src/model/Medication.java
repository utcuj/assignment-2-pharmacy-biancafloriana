package model;


import model.BLL.MedicationServices;
import model.conversion.ConvertorSale;

import javax.persistence.*;


@Entity
@Table(name = "medication")
public class Medication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;


    @Column(name = "ingredients")
    private String ingredients;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    private Double price;


    public Medication() {
    }

    public Medication(Integer id, String name, String ingredients, String manufacturer, Integer quantity, Double price) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.manufacturer = manufacturer;
        this.quantity = quantity;
        this.price = price;
    }

    public Medication(String name, String ingredients, String manufacturer, Integer quantity, Double price) throws Exception {
       Validation(name);
       Validation(ingredients);
       Validation(manufacturer);
       Validation(quantity);
       Validation(price);

        this.name = name;
        this.ingredients = ingredients;
        this.manufacturer = manufacturer;
        this.quantity = quantity;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        Validation(name);
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) throws Exception {
        Validation(ingredients);
        this.ingredients = ingredients;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) throws Exception {

        Validation(manufacturer);
        this.manufacturer = manufacturer;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) throws Exception {

        Validation(quantity);
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) throws Exception {
        Validation(price);
        this.price = price;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public void sell(Integer quantity, String employee) {
        Sale s;
        ConvertorSale convertorSale = new ConvertorSale();
        if (this.quantity - quantity >= 0) {
            this.quantity -= quantity;



            s = new Sale(this.name, quantity, employee);
            Register r;

            r = convertorSale.convertFromXML();

            r.addSell(s);
            convertorSale.convertToXML(r);
        }

        update();
    }

    private void update() {

        MedicationServices.update(this);
    }
    private void Validation(String s) throws Exception {

        String regex = "^[a-zA-Z]+$";
        if(!s.matches(regex)) {
            throw new Exception();
        }

    }

    private void Validation(int i) throws Exception {

        if(i<0) {
            throw new Exception();
        }

    }
    private void Validation(double i) throws Exception {

        if(i<0.0) {
            throw new Exception();
        }

    }
}