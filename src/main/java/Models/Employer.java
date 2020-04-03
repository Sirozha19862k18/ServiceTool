package Models;

import javax.persistence.*;


@Entity
@Table (name="employers")
public class Employer {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employer_id")
    private int employer_id;

    @Column(name = "employer_name")
    private String employer_name;

    @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "position_id")
    private Position position;

    public Employer(){
    }

 /*   public Employer(int employer_id, String employer_name){
        this.employer_id=employer_id;
        this.employer_name=employer_name;
    }*/

    public int getEmployer_id() {
        return employer_id;
    }

    public void setEmployer_id(int employer_id) {
        this.employer_id = employer_id;
    }

    public String getEmployer_name() {
        return employer_name;
    }

    public void setEmployer_name(String employer_name) {
        this.employer_name = employer_name;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setPosition(String selectedPosition){
       this.position.setPosition(selectedPosition);
    }


    @Override
    public String toString() {
        return employer_id + " "+ employer_name+" "+getPosition();
    }
}
