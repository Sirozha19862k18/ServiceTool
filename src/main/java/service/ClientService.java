package service;

import Models.Region;
import dao.clientDAOImpl;

import java.util.List;

public class ClientService {

    private clientDAOImpl model = new clientDAOImpl();

    public ClientService(){}

    public List<Region> showAllRegions (){return  model.showAllRegions();}

    public void addNewRegion(Region region){model.addNewRegion(region);}

    public void deleteRegion(Region region) {model.deleteRegion(region);}
}
