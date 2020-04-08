package service;

import Models.Incident;
import Models.Product;
import dao.IncidentDAOImpl;

import java.util.List;

public class IncidentService {
    private IncidentDAOImpl model = new IncidentDAOImpl();

    public IncidentService(){}

    public List<Incident> showAllIncident() {return model.showAllIncident();}

    public List<Product> showAllProduct(){return model.showAllProduct();}
}
