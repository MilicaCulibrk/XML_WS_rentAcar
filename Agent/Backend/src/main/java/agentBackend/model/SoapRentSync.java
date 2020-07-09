package agentBackend.model;

import javax.persistence.*;

@Entity
public class SoapRentSync {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Long msApp_id;
    @Column
    private Long agentApp_id;

    public SoapRentSync() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMsApp_id() {
        return msApp_id;
    }

    public void setMsApp_id(Long msApp_id) {
        this.msApp_id = msApp_id;
    }

    public Long getAgentApp_id() {
        return agentApp_id;
    }

    public void setAgentApp_id(Long agentApp_id) {
        this.agentApp_id = agentApp_id;
    }
}
