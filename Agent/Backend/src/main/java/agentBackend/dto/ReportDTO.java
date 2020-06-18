package agentBackend.dto;

import agentBackend.model.Brand;
import agentBackend.model.Report;

public class ReportDTO {

    private Long id;
    private float kilometres_crossed;
    private String additional_information;
    private Long purchase_id;
    private Long id_add;
    private float old_kilometres;

    public ReportDTO(Long id, float kilometres_crossed, String additional_information, Long purchase_id, Long id_add, float old_kilometres) {
        this.id = id;
        this.kilometres_crossed = kilometres_crossed;
        this.additional_information = additional_information;
        this.purchase_id = purchase_id;
        this.id_add = id_add;
        this.old_kilometres = old_kilometres;
    }

    public ReportDTO(Report report) {
        this.id = report.getId();
        this.kilometres_crossed = report.getKilometresCrossed();
        this.additional_information = report.getAdditionalInformation();
        this.purchase_id = report.getPurchase().getId();
        this.id_add = report.getPurchase().getId_add();
        this.old_kilometres = report.getKilometresCrossed();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getKilometres_crossed() {
        return kilometres_crossed;
    }

    public void setKilometres_crossed(float kilometres_crossed) {
        this.kilometres_crossed = kilometres_crossed;
    }

    public String getAdditional_information() {
        return additional_information;
    }

    public void setAdditional_information(String additional_information) {
        this.additional_information = additional_information;
    }

    public Long getPurchase_id() {
        return purchase_id;
    }

    public void setPurchase_id(Long purchase_id) {
        this.purchase_id = purchase_id;
    }

    public Long getId_add() {
        return id_add;
    }

    public void setId_add(Long id_add) {
        this.id_add = id_add;
    }

    public float getOld_kilometres() {
        return old_kilometres;
    }

    public void setOld_kilometres(float old_kilometres) {
        this.old_kilometres = old_kilometres;
    }
}
