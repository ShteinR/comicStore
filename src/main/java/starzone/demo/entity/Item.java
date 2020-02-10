package starzone.demo.entity;

import java.io.Serializable;
import java.util.Optional;

public class Item  implements Serializable {
    private Product product;
    private int quantity;

    public Optional<Product> getProduct() {
        return Optional.ofNullable(product);
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Item(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }


}
