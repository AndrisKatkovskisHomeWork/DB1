import javax.persistence.*;

@Entity

@Table(name = "sku")

public class Sku {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne(cascade = CascadeType.PERSIST)

    @JoinColumn(name = "product_id")

    private Products productId;
    private String name;
    private String color;
    private String description;
    private String model;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Products getProductId() {
        return productId;
    }
    public void setProductId(Products productId) {
        this.productId = productId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
}

