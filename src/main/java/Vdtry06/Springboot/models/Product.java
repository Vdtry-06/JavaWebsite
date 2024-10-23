package Vdtry06.Springboot.models;

import jakarta.persistence.*;

import java.util.Calendar;
import java.util.Objects;

// Plain Object Java Object: doi tuong java co ban
@Entity // thuc the
@Table(name="tblProduct")
public class Product {
    // this is "primary key"
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO) // auto-increment
    // tao ra quy tac
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1 // tang len 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    private Long id;
    @Column(nullable=false, unique=true, length=50)
    private String productName;
    private int productYear;
    private Double price;
    private String url;
    // default constructor
    public Product() {}

    @Transient
    private int age;
    public int getAge() {
        return Calendar.getInstance().get(Calendar.YEAR) - productYear;
    }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productYear == product.productYear
                && age == product.age && Objects.equals(id, product.id)
                && Objects.equals(productName, product.productName)
                && Objects.equals(price, product.price)
                && Objects.equals(url, product.url);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(id, productName, productYear, price, url, age);
//    }
}
