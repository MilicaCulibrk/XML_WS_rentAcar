package addvertisment.controller;

import addvertisment.dto.BrandDTO;
import addvertisment.dto.VehicleModelDTO;
import addvertisment.service.VehicleModelService;
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
public class VehicleModelController {

    @Autowired
    private VehicleModelService vehicleModelService;

    @GetMapping("/{brand_id}/model")
    public ResponseEntity getAllModels(@PathVariable Long brand_id)  {
        return new ResponseEntity<List<VehicleModelDTO>>(vehicleModelService.getAllModels(brand_id), HttpStatus.OK);
    }

    @PostMapping(path="/{brand_id}/model", consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json")
    public ResponseEntity createModel(@PathVariable Long brand_id, @RequestBody VehicleModelDTO vehicleModelDTO) {

        if (vehicleModelDTO == null || vehicleModelDTO.getVehicle_model_name().equals("") || brand_id == null) {
            return new ResponseEntity<>("Invalid input data", HttpStatus.UNPROCESSABLE_ENTITY);
        }

        try {
            vehicleModelService.createModel(vehicleModelDTO, brand_id);
            return new ResponseEntity<>(vehicleModelDTO, HttpStatus.OK);
        } catch (ValidationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }

    }

    @PutMapping(path = "/{brand_id}/model", consumes = "application/json", produces = "application/json")
    public ResponseEntity updateModel(@PathVariable Long brand_id, @RequestBody VehicleModelDTO modelDTO) {

        if (modelDTO == null || modelDTO.getVehicle_model_name().equals("")) {
            return new ResponseEntity<>("Invalid input data", HttpStatus.UNPROCESSABLE_ENTITY);
        }

        try {
            vehicleModelService.updateModel(modelDTO, brand_id);
            return new ResponseEntity<>(modelDTO, HttpStatus.OK);
        } catch (ValidationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }

    }

    @DeleteMapping(path = "/{brand_id}/model/{model_id}")
    public ResponseEntity deleteBrand(@PathVariable Long brand_id, @PathVariable Long model_id) {
        if (brand_id == null || model_id == null) {
            return new ResponseEntity<>("Invalid input data", HttpStatus.UNPROCESSABLE_ENTITY);
        }

        try {
            boolean hasAdds = vehicleModelService.hasAdds(model_id);

            if (hasAdds){
                return new ResponseEntity<>("Cars with this model exist. You can not delete it!", HttpStatus.FORBIDDEN);
            }

            vehicleModelService.deleteModel(model_id);

        } catch (ValidationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        }

        return new ResponseEntity<>(model_id, HttpStatus.OK);

    }

}
