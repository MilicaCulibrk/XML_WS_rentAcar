package agentBackend.service;

import agentBackend.dto.ReportDTO;
import agentBackend.model.Report;
import agentBackend.repository.PurchaseRepository;
import agentBackend.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private AddvertismentService addvertismentService;

    public List<ReportDTO> getAllReports() {
        List<ReportDTO> reportsDTOlist = new ArrayList<>();
        List<Report> reports = reportRepository.findAll();
        for (Report  report : reports) {
            reportsDTOlist.add(new ReportDTO(report));
        }
        return reportsDTOlist;
    }



    public void createReport(ReportDTO reportDTO, Long purchase_id) throws ValidationException {

        //ako vec postoji brend sa istim imenomd
        List<Report> reportList = reportRepository.findAll();

        Report report = newDTOtoReal(reportDTO, purchase_id);

        reportRepository.save(report);

        reportDTO.setAdditionalPrice(addvertismentService.updateMileage(reportDTO.getKilometres_crossed(), reportDTO.getId_add()));

    }

    public void updateReport(ReportDTO reportDTO, Long purchase_id) throws ValidationException {

        Report report = reportRepository.getOne(reportDTO.getId());

        existingDTOtoReal(report, reportDTO);

        reportRepository.save(report);

        reportDTO.setAdditionalPrice(addvertismentService.changeUpdatedMileage(reportDTO.getKilometres_crossed(), reportDTO.getId_add(), reportDTO.getOld_kilometres()));
    }

    public Report newDTOtoReal(ReportDTO dto, Long purchase_id){
        Report real = new Report();
        real.setKilometresCrossed(dto.getKilometres_crossed());
        real.setAdditionalInformation(dto.getAdditional_information());
        real.setPurchase(purchaseRepository.findById(purchase_id).orElse(null));
        return real;
    }

    public void existingDTOtoReal(Report real, ReportDTO dto){
        real.setKilometresCrossed(dto.getKilometres_crossed());
        real.setAdditionalInformation(dto.getAdditional_information());
        real.setPurchase(purchaseRepository.findById(dto.getPurchase_id()).orElse(null));
        return;
    }


}
