package service;

import Models.Employer;
import Models.Position;
import dao.EmployerDAOImpl;
import java.util.List;

public class EmployerService {
    private EmployerDAOImpl model = new EmployerDAOImpl();

    public EmployerService(){
    }

    public List<Employer> showAllEmployers(){
        return model.showAllEmployers();
    }

    public List<Position> showAllPosition(){
        return  model.showAllPosition();
    }

    public void addPosition (Position position){
        model.addNewPosition(position);
    }

    public void addNewEployer(Employer employer){ model.addNewEmployer(employer);}
    public List<Position> searchPositionByName (String positionName) {return model.searchPositionByName(positionName);}
    public  void deletePosition (Position position) {model.deletePosition(position);}
    public void deleteEmployer (Employer employer){model.deleteEmployer(employer);}
}
