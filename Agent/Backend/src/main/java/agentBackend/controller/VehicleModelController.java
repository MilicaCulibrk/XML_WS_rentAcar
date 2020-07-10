package agentBackend.controller;

import agentBackend.dto.VehicleModelDTO;
import agentBackend.service.VehicleModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/brand")
public class VehicleModelController {

    @Autowired
    private VehicleModelService vehicleModelService;

    @GetMapping("/model")
    public ResponseEntity<List<String>> getVehicleModelNames() {
        return new ResponseEntity<List<String>>(vehicleModelService.getVehicleModelNames(), HttpStatus.OK);
    }

    @GetMapping("/{brand_id}/model")
    public ResponseEntity getAllModels(@PathVariable Long brand_id)  {
        return new ResponseEntity<List<VehicleModelDTO>>(vehicleModelService.getAllModels(brand_id), HttpStatus.OK);
    }
}
