package addvertisment.service;

import addvertisment.dto.ReservedDateDTO;
import addvertisment.model.Addvertisment;
import addvertisment.model.ReservedDate;
import addvertisment.repository.AddvertismentRepository;
import addvertisment.repository.ReservedDateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservedDateService {

    @Autowired
    AddvertismentRepository addvertismentRepository;

    @Autowired
    ReservedDateRepository reservedDateRepository;

    public void createReservedDate(ArrayList<ReservedDateDTO> reservedDatesDTO, Long id){

        Addvertisment addvertisment= addvertismentRepository.findById(id).orElse(null);

        for(ReservedDateDTO reservedDateDto : reservedDatesDTO ){
            ReservedDate reservedDate = new ReservedDate();
            reservedDate.setOneDate(reservedDateDto.getOneDate());
            reservedDate.setAddvertisment(addvertisment);
            reservedDateRepository.save(reservedDate);
        }
    }
    public ArrayList<ReservedDateDTO> findReservedDate(Long id){
        Addvertisment addvertisment= addvertismentRepository.findById(id).orElse(null);
        List<ReservedDate> reservedDates= reservedDateRepository.findByAddvertisment(addvertisment);
        ArrayList<ReservedDateDTO> reservedDateDTOS = new ArrayList<ReservedDateDTO>() ;
        for(ReservedDate reservedDate: reservedDates){
            reservedDateDTOS.add(new ReservedDateDTO( reservedDate));

        }
        return reservedDateDTOS;

    }

}
