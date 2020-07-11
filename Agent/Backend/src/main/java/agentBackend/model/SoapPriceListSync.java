package agentBackend.model;

import javax.persistence.*;

@Entity
public class SoapPriceListSync {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Long msAppId;
    @Column
    private Long agentAppId;

    public SoapPriceListSync() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMsAppId() {
        return msAppId;
    }

    public void setMsAppId(Long msAppId) {
        this.msAppId = msAppId;
    }

    public Long getAgentAppId() {
        return agentAppId;
    }

    public void setAgentAppId(Long agentAppId) {
        this.agentAppId = agentAppId;
    }
}
