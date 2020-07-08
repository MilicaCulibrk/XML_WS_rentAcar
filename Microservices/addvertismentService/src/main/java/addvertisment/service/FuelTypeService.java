package addvertisment.service;

import addvertisment.dto.BrandDTO;
import addvertisment.dto.FuelTypeDTO;
import addvertisment.model.Addvertisment;
import addvertisment.model.FuelType;
import addvertisment.mq.enums.OperationEnum;
import addvertisment.mq.producer.BrandProducer;
import addvertisment.mq.producer.FuelTypeProducer;
import addvertisment.repository.AddvertismentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import addvertisment.repository.FuelTypeRepository;

import javax.xml.bind.ValidationException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class FuelTypeService {

    @Autowired
    private FuelTypeRepository fuelTypeRepository;

    @Autowired
    private AddvertismentRepository addvertismentRepository;

    private final FuelTypeProducer fuelTypeProducer;

    public FuelTypeService(FuelTypeProducer fuelTypeProducer) {
        this.fuelTypeProducer = fuelTypeProducer;
    }

    public List<FuelTypeDTO> getAllFuelTypes() {
        List<FuelTypeDTO> fuelTypesDTOlist = new ArrayList<>();
        List<FuelType> fuelTypes = fuelTypeRepository.findAll();
        for (FuelType fuelType : fuelTypes) {
            fuelTypesDTOlist.add(new FuelTypeDTO(fuelType));
        }
        return fuelTypesDTOlist;
    }

    public FuelType createFuelType(FuelTypeDTO fuelTypeDTO) throws ValidationException {

        //ako vec postoji fuel type sa istim imenomd
        List<FuelType> fuelTypeList = fuelTypeRepository.findAll();
        for(FuelType ft: fuelTypeList){
            if(ft.getFuel_type_name().equals(fuelTypeDTO.getFuel_type_name())){
                throw new ValidationException("Fuel type with this name already exists!");
            }
        }

        FuelType fuelType = newDTOtoReal(fuelTypeDTO);

        fuelTypeRepository.save(fuelType);

        try {
            FuelTypeDTO dto = new FuelTypeDTO(fuelType);
            dto.setOperation(OperationEnum.CREATE);
            this.fuelTypeProducer.send(dto);
        } catch (Exception e) {
            System.err.println("Did not sync with search service");
        }


        return fuelType;
    }

    public void updateFuelType(FuelTypeDTO fuelTypeDTO) throws ValidationException {

        //ako vec postoji fuel type sa istim imenomd
        List<FuelType> fuelTypeList = fuelTypeRepository.findAll();
        for(FuelType ft: fuelTypeList){
            if(ft.getFuel_type_name().equals(fuelTypeDTO.getFuel_type_name())){
                throw new ValidationException("Fuel type with this name already exists!");
            }
        }

        FuelType fuelType = fuelTypeRepository.getOne(fuelTypeDTO.getId());
        existingDTOtoReal(fuelType, fuelTypeDTO);

        try {
            FuelTypeDTO dto = new FuelTypeDTO(fuelType);
            dto.setOperation(OperationEnum.UPDATE);
            this.fuelTypeProducer.send(dto);
        } catch (Exception e) {
            System.err.println("Did not sync with search service");
        }

        fuelTypeRepository.save(fuelType);
    }

    public void deleteFuelType(Long id) throws ValidationException {
        Optional<FuelType> fuelType = fuelTypeRepository.findById(id);
        if (!fuelType.isPresent()){
            throw new ValidationException("Fuel type with that id doesn't exist!");
        }

        try {
            FuelTypeDTO dto = new FuelTypeDTO(id, "delete");
            dto.setOperation(OperationEnum.DELETE);
            this.fuelTypeProducer.send(dto);
        } catch (Exception e) {
            System.err.println("Did not sync with search service");
        }

        fuelTypeRepository.delete(fuelType.get());
    }

    public FuelType newDTOtoReal(FuelTypeDTO dto){
        FuelType real = new FuelType();
        real.setFuel_type_name(dto.getFuel_type_name());
        return real;
    }

    public void existingDTOtoReal(FuelType real, FuelTypeDTO dto){
        real.setFuel_type_name(dto.getFuel_type_name());
        return;
    }

    public boolean hasAdds(Long id){
        List<Addvertisment> addvertisments = addvertismentRepository.findAll();

        for(Addvertisment addvertisment: addvertisments){
            if(addvertisment.getFuel_type().getId() == id){
                return true;
            }
        }

        return false;
    }



}
