package agentBackend.soap;

import agentBackend.dto.FuelTypeDTO;
import agentBackend.model.FuelType;
import agentBackend.service.FuelTypeService;
import localhost._8081.fueltype_schema.FuelTypeRequest;
import localhost._8081.fueltype_schema.FuelTypeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class FuelTypeEndpoint {

    private static final String NAMESPACE_URI = "http://localhost:8081/fuelType-schema";

    @Autowired
    private FuelTypeService fuelTypeService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "FuelTypeRequest")
    @ResponsePayload
    public FuelTypeResponse getCountry(@RequestPayload FuelTypeRequest request) {
        FuelTypeResponse response = new FuelTypeResponse();
        FuelTypeDTO fuelTypeDTO = new FuelTypeDTO(request.getId(), request.getFuelTypeName());
        FuelType fuelType = fuelTypeService.createFuelType(fuelTypeDTO);
        response.setFuelTypeName(fuelType.getFuel_type_name());
        response.setId(fuelType.getId());
        return response;
    }

}
