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

}
