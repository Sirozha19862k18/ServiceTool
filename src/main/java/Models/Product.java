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

}
