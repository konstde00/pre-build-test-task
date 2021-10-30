package model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "products")
public final class Product {
    @Id
    @Column(name = "id", nullable = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String productUuid;
    @NotNull
    private String productName;
    @Positive
    private int amount;

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductUuid() {
        return productUuid;
    }

    public void setProductUuid(String productUuid) {
        this.productUuid = productUuid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product product = (Product) o;
        return amount == product.amount
                && id.equals(product.id)
                && productUuid.equals(product.productUuid)
                && productName.equals(product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productUuid, productName, amount);
    }

    @Override
    public String toString() {
        return "Product{"
                + "id=" + id
                + ", productUuid='" + productUuid + '\''
                + ", productName='" + productName + '\''
                + ", amount=" + amount
                + '}';
    }
}
