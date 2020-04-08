package Models;

import javax.persistence.*;

@Entity
@Table(name = "incident")

public class Incident {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "incident_id")
    private int incidentID;

    @Column(name = "incident_name")
    private String incidentNAme;

    @Column(name = "begin_date")
    private int incidentBeginDate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product product;


    @Column(name="description")
    private String descriptionOfIncident;

    @Column (name = "incident_resolvedflag")
    private int incidentResolvedFlag;

    @Column (name="resolved_date")
    private int incidentResolvedDate;

    public int getIncidentID() {
        return incidentID;
    }

    public void setIncidentID(int incidentID) {
        this.incidentID = incidentID;
    }

    public String getIncidentNAme() {
        return incidentNAme;
    }

    public void setIncidentNAme(String incidentNAme) {
        this.incidentNAme = incidentNAme;
    }

    public int getIncidentBeginDate() {
        return incidentBeginDate;
    }

    public void setIncidentBeginDate(int incidentBeginDate) {
        this.incidentBeginDate = incidentBeginDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getDescriptionOfIncident() {
        return descriptionOfIncident;
    }

    public void setDescriptionOfIncident(String descriptionOfIncident) {
        this.descriptionOfIncident = descriptionOfIncident;
    }

    public int getIncidentResolvedFlag() {
        return incidentResolvedFlag;
    }

    public void setIncidentResolvedFlag(int incidentResolvedFlag) {
        this.incidentResolvedFlag = incidentResolvedFlag;
    }

    public int getIncidentResolvedDate() {
        return incidentResolvedDate;
    }

    public void setIncidentResolvedDate(int incidentResolvedDate) {
        this.incidentResolvedDate = incidentResolvedDate;
    }

    @Override
    public String toString(){
        return client.getClientName();
    }


}
