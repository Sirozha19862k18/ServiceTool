package service;

import Models.Region;
import dao.clientDAOImpl;

import java.util.List;

public class ClientService {

    private clientDAOImpl model = new clientDAOImpl();

    public ClientService(){}

    public List<Region> showAllRegions (){return  model.showAllRegions();}
}
