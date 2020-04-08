package dao;

import Models.Client;
import Models.Region;

import java.util.List;

public interface ClientDAO {
    List<Client> showAllClients();
    List<Region> showAllRegions();
    void addNewClient(Client client);
    void addNewRegion(Region region);
    List<Region> searchRegionByName(String regionName);
    void deleteRegion (Region region);
    void deleteClient(Client client);
}
