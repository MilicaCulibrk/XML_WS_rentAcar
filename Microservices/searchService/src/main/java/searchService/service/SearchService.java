package searchService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import searchService.dto.SearchDTO;
import searchService.dto.SearchQueryDTO;
import searchService.model.ReservedDates;
import searchService.model.Search;
import searchService.repository.BrandsRepository;
import searchService.repository.ReservedDatesRepository;
import searchService.repository.SearchRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class SearchService {

    @Autowired
    private SearchRepository searchRepository;

    @Autowired
    private ReservedDatesRepository reservedDatesRepository;

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
}
