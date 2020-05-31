package addvertisment.controller;

import addvertisment.dto.BrandDTO;
import addvertisment.dto.FuelTypeDTO;
import addvertisment.model.Brand;
import addvertisment.model.VehicleModel;
import addvertisment.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @Autowired
    private BrandService vehicleModelService;

    @GetMapping()
    public ResponseEntity<List<BrandDTO>> getAllBrands() {
        return new ResponseEntity<List<BrandDTO>>(brandService.getAllBrands(), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json")
    public ResponseEntity createBrand(@RequestBody BrandDTO brandDTO) {

        if (brandDTO == null || brandDTO.getBrand_name().equals("")) {
            return new ResponseEntity<>("Invalid input data", HttpStatus.UNPROCESSABLE_ENTITY);
        }

        try {
            brandService.createBrand(brandDTO);
            return new ResponseEntity<>(brandDTO, HttpStatus.OK);
        } catch (ValidationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }

    }

    @PutMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity updateBrand(@RequestBody BrandDTO brandDTO) {

        if (brandDTO == null || brandDTO.getBrand_name().equals("")) {
            return new ResponseEntity<>("Invalid input data", HttpStatus.UNPROCESSABLE_ENTITY);
        }

        System.out.println(brandDTO.getId());

        try {
            brandService.updateBrand(brandDTO);
            return new ResponseEntity<>(brandDTO, HttpStatus.OK);
        } catch (ValidationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBrand(@PathVariable Long id) {
        if (id == null) {
            return new ResponseEntity<>("Invalid input data", HttpStatus.UNPROCESSABLE_ENTITY);
        }

        try {
            boolean hasAdds = brandService.hasAdds(id);
            boolean hasModels = vehicleModelService.hasModels(id);

            if (hasAdds){
                return new ResponseEntity<>("Cars with this brand exist. You can not delete it!", HttpStatus.FORBIDDEN);
            }

            if (hasModels){
                return new ResponseEntity<>("Modles of this brand exist. You can not delete it!", HttpStatus.FORBIDDEN);
            }

            brandService.deleteBrand(id);
        } catch (ValidationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        }

        return new ResponseEntity<>(id, HttpStatus.OK);

    }
}