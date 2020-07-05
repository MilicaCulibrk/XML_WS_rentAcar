package agentBackend.soap;

import org.springframework.ws.server.endpoint.annotation.Endpoint;

@Endpoint
public class VCEndPoint {

    private static final String NAMESPACE_URI = "http://localhost:8081/agent-schema";

  /*  @Autowired
    private VehicleClassService vehicleClassService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getVCRequest")
    @ResponsePayload
    public GetVCResponse createVC(@RequestPayload GetVCRequest request) throws ValidationException {
        System.out.println("SOAP - Create VC");
        GetVCResponse response = new GetVCResponse();

        VehicleClassDTO vehicleClassDTO = new VehicleClassDTO();
        vehicleClassDTO.setId(request.getId());
        vehicleClassDTO.setVehicle_class_name(request.getVehicleClassName());
        VehicleClass vehicleClass = vehicleClassService.createVehicleClass(vehicleClassDTO);
        response.setId(request.getId());
        response.setVehicleClassName(request.getVehicleClassName());
        return response;
    }*/
}
