package hu.flowacademy.shoppingList.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shopping_item")
public class ShoppingItem {

    @Id
    @Column(name = "id", length = 10)
    private String id;

    @Column
    private String name;

    @Column
    private String cathegory;

    @Column
    private int quantity;

    @Column
    private int quantityOne;

    @Column
    private int price;

    @Column
    private String description;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCathegory() {
        return cathegory;
    }

    public void setCathegory(String cathegory) {
        this.cathegory = cathegory;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantityOne() {
        return quantityOne;
    }

    public void setQuantityOne(int quantityOne) {
        this.quantityOne = quantityOne;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
