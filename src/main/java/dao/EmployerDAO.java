package dao;

import Models.Employer;
import Models.Position;

import java.util.List;

public interface EmployerDAO {
    List<Employer> showAllEmployers();
    List<Position> showAllPosition();
    void addNewPosition(Position position);
    void addNewEmployer(Employer employer);
    List<Position> searchPositionByName(String positionName);
    void deletePosition (Position position);
    void deleteEmployer(Employer employer);

}
