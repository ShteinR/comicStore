package starzone.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "products")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "product_name")
    private String name;
    @Column(name = "product_price")
    private double price;
    @Column(name = "product_image",length = Integer.MAX_VALUE,nullable = true)
    private String image;
    private String description;
@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "author_id")
private Author author;
    public String getDescription() {
        return description;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
