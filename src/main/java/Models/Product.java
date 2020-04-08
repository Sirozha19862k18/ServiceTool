package Models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="product")
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private int productId;

    @Column(name = "product_name")
    private String productName;

    @Column (name ="product_builddate")
    private int productBuildDate;

    @Column (name = "partnumber")
    private int partNumber;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Incident> incident;


    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductBuildDate() {
        return productBuildDate;
    }

    public void setProductBuildDate(int productBuildDate) {
        this.productBuildDate = productBuildDate;
    }

    public int getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(int partNumber) {
        this.partNumber = partNumber;
    }

    public List<Incident> getIncident() {
        return incident;
    }

    public void setIncident(List<Incident> incident) {
        this.incident = incident;
    }

    @Override
    public String toString(){
        return productName;
    }
}
