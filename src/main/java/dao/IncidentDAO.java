package dao;

import Models.Incident;
import Models.Product;

import java.util.List;

public interface IncidentDAO {
    List<Incident> showAllIncident();
    List<Product> showAllProduct();
    void  addProduct(Product product);
    void deleteProduct(Product product);
}
