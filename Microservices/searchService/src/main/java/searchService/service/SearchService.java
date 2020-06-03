package searchService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import searchService.dto.SearchDTO;
import searchService.model.Search;
import searchService.repository.BrandsRepository;
import searchService.repository.SearchRepository;

import java.util.ArrayList;
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
}
