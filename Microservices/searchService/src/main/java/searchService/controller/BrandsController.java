package searchService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import searchService.dto.BrandsDTO;
import searchService.service.BrandsService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/brands")
public class BrandsController {

    @Autowired
    private BrandsService brandsService;

    @GetMapping()
    public ResponseEntity<List<String>> getBrandNames() {
        return new ResponseEntity<List<String>>(brandsService.getBrandNames(), HttpStatus.OK);
    }
}
