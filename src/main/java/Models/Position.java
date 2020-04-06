package Models;

import dao.EmployerDAOImpl;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "position")

public class Position extends EmployerDAOImpl {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "position_id")
    private int id;

    @Column(name = "position")
    private String position;

    @OneToMany (mappedBy = "position", cascade = CascadeType.ALL)
    private List<Employer> employers;

    public Position(){
    }



    public Position(int id, String position){
        this.id=id;
        this.position=position;
        employers=new ArrayList<Employer>();
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }


    public void setPosition(String position) {
        this.position = position;
    }

    public List<Employer> getEmployers() {
        return employers;
    }

    public void setEmployers(List<Employer> employers) {
        this.employers = employers;
    }

    @Override
    public String toString() {
        return position;
    }
}
