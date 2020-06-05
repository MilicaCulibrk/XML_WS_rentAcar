package searchService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import searchService.dto.SearchDTO;
import searchService.dto.SearchQueryDTO;
import searchService.model.Search;
import searchService.repository.BrandsRepository;
import searchService.repository.SearchRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class SearchService {

    @Autowired
    private SearchRepository searchRepository;

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


        List<Search> searches = searchRepository.getByQuery(sDTO.getSelectBrand(), sDTO.getSelectModel(), sDTO.getSelectClass(), sDTO.getSelectTransmission(), sDTO.getSelectGas(), sDTO.getSelectLocation(), sDTO.getSelectChildSeats());
        List<SearchDTO> searchDTOS = new ArrayList<>();
        for(Search search: searches) {
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


}
