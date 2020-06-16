package agentBackend.controller;

import agentBackend.dto.BrandDTO;
import agentBackend.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping()
    public ResponseEntity<List<BrandDTO>> getAllBrands() {
        return new ResponseEntity<List<BrandDTO>>(brandService.getAllBrands(), HttpStatus.OK);
    }
}
