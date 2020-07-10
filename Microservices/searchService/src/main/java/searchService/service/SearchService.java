package searchService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import searchService.dto.*;
import searchService.model.*;
import searchService.mq.dto.AddDTO;
import searchService.repository.*;

import javax.xml.bind.ValidationException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class SearchService {

    @Autowired
    private SearchRepository searchRepository;

    @Autowired
    private BrandsRepository brandsRepository;

    @Autowired
    private VehicleModelsRepository vehicleModelsRepository;

    @Autowired
    private VehicleClassesRepository vehicleClassesRepository;

    @Autowired
    private FuelTypesRepository fuelTypesRepository;

    @Autowired
    private TransmissionTypesRepository transmissionTypesRepository;


    @Autowired
    private ReservedDatesRepository reservedDatesRepository;

    @Autowired
    private ImagesRepository imagesRepository;

    public List<SearchDTO> getAllSearches() {
        List<SearchDTO> searchesDTOlist = new ArrayList<>();
        List<Search> searches = searchRepository.findAll();
        for (Search search : searches) {
            searchesDTOlist.add(new SearchDTO(search));
        }

        System.out.println(searchesDTOlist);
        return searchesDTOlist;
    }

    public List<SearchDTO> getByQuery(SearchQueryDTO searchQueryDTO) {

        SearchQueryDTO sDTO = checkIfEmpty(searchQueryDTO);

        int minPrice = parseMinPrice(searchQueryDTO);
        int maxPrice = parseMaxPrice(searchQueryDTO);
        int minMileage = parseMinMileage(searchQueryDTO);
        int maxMileage = parseMaxMileage(searchQueryDTO);


        List<Search> searches = searchRepository.getByQuery(sDTO.getSelectBrand(), sDTO.getSelectModel(), sDTO.getSelectClass(), sDTO.getSelectTransmission(), sDTO.getSelectGas(), sDTO.getSelectLocation(), sDTO.getSelectChildSeats(), minPrice, maxPrice, minMileage, maxMileage);

        List<Search> dateSearches = searchDates(searches, searchQueryDTO);

        List<SearchDTO> searchDTOS = new ArrayList<>();
        for(Search search: dateSearches) {
            SearchDTO searchDTO = new SearchDTO(search);
            searchDTOS.add(searchDTO);
        }
        return searchDTOS;
    }

    SearchQueryDTO checkIfEmpty(SearchQueryDTO searchQueryDTO){
        if(searchQueryDTO.getSelectBrand().isEmpty()){
            searchQueryDTO.getSelectBrand().add("emptyBrand");
        }
        if(searchQueryDTO.getSelectModel().isEmpty()){
            searchQueryDTO.getSelectModel().add("emptyModel");
        }
        if(searchQueryDTO.getSelectClass().isEmpty()){
            searchQueryDTO.getSelectClass().add("emptyClass");
        }
        if(searchQueryDTO.getSelectTransmission().isEmpty()){
            searchQueryDTO.getSelectTransmission().add("emptyTransmission");
        }
        if(searchQueryDTO.getSelectGas().isEmpty()){
            searchQueryDTO.getSelectGas().add("emptyGas");
        }
        if(searchQueryDTO.getSelectLocation().isEmpty()){
            searchQueryDTO.getSelectLocation().add("emptyLocation");
        }
        if(searchQueryDTO.getSelectChildSeats().isEmpty()){
            searchQueryDTO.getSelectChildSeats().add(100);
        }

        return searchQueryDTO;
    }

    int parseMinPrice(SearchQueryDTO searchQueryDTO){

        if(searchQueryDTO.getSelectMinPrice() != null){
            return Integer.parseInt(searchQueryDTO.getSelectMinPrice());
        }else{
            return 0;
        }

    }

    int parseMaxPrice(SearchQueryDTO searchQueryDTO){

        if(searchQueryDTO.getSelectMaxPrice() != null){
            return Integer.parseInt(searchQueryDTO.getSelectMaxPrice());
        }else{
            return 0;
        }
    }

    int parseMinMileage(SearchQueryDTO searchQueryDTO){

        if(searchQueryDTO.getSelectMinMileage() != null){
            return Integer.parseInt(searchQueryDTO.getSelectMinMileage());
        }else{
            return 0;
        }
    }

    int parseMaxMileage(SearchQueryDTO searchQueryDTO){

        if(searchQueryDTO.getSelectMaxMileage() != null){
            return Integer.parseInt(searchQueryDTO.getSelectMaxMileage());
        }else{
            return 0;
        }
    }

    List<Search> searchDates(List<Search> searches, SearchQueryDTO searchQueryDTO){

        List<Search> searchList = new ArrayList<>();

        for(Search search : searches){
            List<ReservedDates> reservedDatesList = reservedDatesRepository.getAllBySearchId(search.getId());

            boolean flag = false;
            for(ReservedDates reservedDate: reservedDatesList){
                for(String date: searchQueryDTO.getDates()){
                    if(reservedDate.getOneDate().equals(date)){
                        flag = true;
                        break;
                    }
                }
            }

            if(!flag){
                searchList.add(search);
            }
        }

        return searchList;
    }

    public Search save(AddDTO addDTO) {
        Search search = newDTOtoReal(addDTO);
        searchRepository.save(search);

        for(ImagesDTO i: addDTO.getImages()){
            Images image = this.createImage(i);
            image.setSearch(search);
            imagesRepository.save(image);
        }

        for(ReservedDatesDTO r: addDTO.getDates()){
            ReservedDates reservedDate = this.createReservedDate(r);
            reservedDate.setSearch(search);
            reservedDatesRepository.save(reservedDate);
        }


        return search;
    }

    public void update(AddDTO addDTO) {

        Search search = searchRepository.getOne(addDTO.getId());
        existingDTOtoReal(search, addDTO);

        searchRepository.save(search);
    }

    public void delete(AddDTO addDTO){

        Search search = searchRepository.getOne(addDTO.getId());

        for (ReservedDates date : search.getReservedDates()) {
            reservedDatesRepository.delete(date);
        }

        for (Images image : search.getImages()) {
            imagesRepository.delete(image);
        }

        List<Search> searches = searchRepository.findAll();

        for(Search sr: searches){
            if(sr.getId().equals(addDTO.getId())){
                Search search1 = sr;
                searchRepository.delete(search1);
            }
        }

    }

    public Search newDTOtoReal(AddDTO dto){
        Search real = new Search();
        real.setId(dto.getId());
        real.setOwner(dto.getAddvertiser_username());
        real.setMileage(dto.getMileage());
        real.setMileage_limit(dto.getMileage_limit());
        real.setChild_seats(dto.getChild_seats());
        real.setCdw(dto.isCdw());
        real.setLocation(dto.getLocation());
        real.setDaily_price(dto.getDaily_price());
        real.setBrand(brandsRepository.findById(dto.getBrand().getId()).orElse(null));
        real.setFuel_type(fuelTypesRepository.findById(dto.getFuel_type().getId()).orElse(null));
        real.setTransmission_type(transmissionTypesRepository.findById(dto.getTransmission_type().getId()).orElse(null));
        real.setVehicle_class(vehicleClassesRepository.findById(dto.getVehicle_class().getId()).orElse(null));
        real.setVehicleModel(vehicleModelsRepository.findById(dto.getVehicle_model().getId()).orElse(null));

        return real;
    }

    public void existingDTOtoReal(Search real, AddDTO dto){
        real.setOwner(dto.getAddvertiser_username());
        real.setMileage(dto.getMileage());
        real.setMileage_limit(dto.getMileage_limit());
        real.setChild_seats(dto.getChild_seats());
        real.setCdw(dto.isCdw());
        real.setLocation(dto.getLocation());
        real.setDaily_price(dto.getDaily_price());
        real.setBrand(brandsRepository.findById(dto.getBrand().getId()).orElse(null));
        real.setFuel_type(fuelTypesRepository.findById(dto.getFuel_type().getId()).orElse(null));
        real.setTransmission_type(transmissionTypesRepository.findById(dto.getTransmission_type().getId()).orElse(null));
        real.setVehicle_class(vehicleClassesRepository.findById(dto.getVehicle_class().getId()).orElse(null));
        real.setVehicleModel(vehicleModelsRepository.findById(dto.getVehicle_model().getId()).orElse(null));
        return;
    }

    public Images createImage(ImagesDTO i){
        Images image = new Images();
        image.setUrl(i.getUrl());

        return image;
    }

    public ReservedDates createReservedDate(ReservedDatesDTO r){
        ReservedDates reservedDate = new ReservedDates();
        reservedDate.setOneDate(r.getOneDate());

        return reservedDate;
    }

}
