package searchService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import searchService.repository.BrandsRepository;
import searchService.repository.SearchRepository;

@Service
public class SearchService {

    @Autowired
    private SearchRepository searchRepository;
}
