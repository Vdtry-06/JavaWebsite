package Vdtry06.Springboot.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// Plain Object Java Object: doi tuong java co ban
@Entity // thuc the
public class Product {
    // this is "primary key"
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // auto-increment
    private Long id;
    private String productName;
    private int productYear;
    private Double price;
    private String url;
    // default constructor
    public Product() {}
    public Product(String productName, int productYear, Double price, String url) {
        this.productName = productName;
        this.productYear = productYear;
        this.price = price;
        this.url = url;
    }
    // Objects created from this class are call POJO: Plain Object Java Object


    public void setId(Long id) {
        this.id = id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setYear(int productYear) {
        this.productYear = productYear;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public int getYear() {
        return productYear;
    }

    public Double getPrice() {
        return price;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productYear=" + productYear +
                ", price=" + price +
                ", url='" + url + '\'' +
                '}';
    }
}
