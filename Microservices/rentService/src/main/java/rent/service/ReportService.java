package rent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rent.client.AddClient;
import rent.dto.AddvertismentRentDTO;
import rent.dto.ReportDTO;
import rent.model.Report;
import rent.repository.PurchaseRepository;
import rent.repository.ReportRepository;

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
    AddClient addClient;


    public List<ReportDTO> getAllReports() {
        List<ReportDTO> reportsDTOlist = new ArrayList<>();
        List<Report> reports = reportRepository.findAll();
        for (Report  report : reports) {
            ReportDTO reportDTO = new ReportDTO();
            reportDTO.setId( report.getId());
            reportDTO.setKilometres_crossed(report.getKilometresCrossed());
            reportDTO.setAdditional_information(report.getAdditionalInformation());
            reportDTO.setPurchase_id(report.getPurchase().getId());
            reportDTO.setId_add(report.getPurchase().getId_add());
            reportsDTOlist.add(reportDTO);
        }
        return reportsDTOlist;
    }



    public void createReport(ReportDTO reportDTO, Long purchase_id) throws ValidationException {

        //ako vec postoji brend sa istim imenomd
        List<Report> reportList = reportRepository.findAll();

        Report report = newDTOtoReal(reportDTO, purchase_id);

        reportRepository.save(report);

        reportDTO.setAdditionalPrice(updateMileage(reportDTO.getKilometres_crossed(), addClient.getAddById(reportDTO.getId_add())));
        System.out.println("-----------------------" + reportDTO.getAdditionalPrice() + "-----------------");
    }

    public void updateReport(ReportDTO reportDTO, Long purchase_id) throws ValidationException {
System.out.println("-----------------perendijaaaaaaaaaa-----------------");
        Report report = reportRepository.getOne(reportDTO.getId());

        existingDTOtoReal(report, reportDTO);

        reportRepository.save(report);

        reportDTO.setAdditionalPrice(changeUpdatedMileage(reportDTO.getKilometres_crossed(), addClient.getAddById(reportDTO.getId_add()), reportDTO.getOld_kilometres()));
        System.out.println("-----------------------" + reportDTO.getAdditionalPrice() + "-----------------");
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

    public float updateMileage(float kilometresCrossed, AddvertismentRentDTO addvertisment){

        float crossedOverKilometres = checkMileageLimit(kilometresCrossed, addvertisment);

        if(crossedOverKilometres != 0){
            return crossedOverKilometres * addvertisment.getPriceByKm();
        }else{
            return 0;
        }
    }

    public float changeUpdatedMileage(float kilometresCrossed, AddvertismentRentDTO addvertisment, float old_kilometres){


        float crossedOverKilometres = checkMileageLimit(kilometresCrossed, addvertisment);

        if(crossedOverKilometres != 0){
            return crossedOverKilometres * addvertisment.getPriceByKm();
        }else{
            return 0;
        }
    }


    public float checkMileageLimit(float kilometresCrossed, AddvertismentRentDTO addvertisment){
        float crossedOverKilometres = 0;
        if(kilometresCrossed > addvertisment.getMileage_limit() && addvertisment.getMileage_limit() != 0){
            crossedOverKilometres = kilometresCrossed - addvertisment.getMileage_limit();
        }

        return crossedOverKilometres;
    }



}
