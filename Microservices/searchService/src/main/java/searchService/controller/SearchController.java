package searchService.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import searchService.model.Search;

@RestController
@RequestMapping("/search")
public class SearchController {

    //pretraga oglasa po odredjenim paramatrima smesteni u klasu search
    @GetMapping()
    public ResponseEntity<?> getAllAdds(@RequestBody Search search)  {
        return null;
    }


}