package searchService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import searchService.dto.SearchDTO;
import searchService.dto.SearchQueryDTO;
import searchService.service.SearchService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping()
    public ResponseEntity<List<SearchDTO>> getAllSearches()  {
        return new ResponseEntity<List<SearchDTO>>(searchService.getAllSearches(), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json")
    public ResponseEntity getAllByQuery(@RequestBody SearchQueryDTO searchQueryDTO) {
        List<SearchDTO> searches = searchService.getByQuery(searchQueryDTO);
        return new ResponseEntity<>(searches, HttpStatus.OK);
    }
}
