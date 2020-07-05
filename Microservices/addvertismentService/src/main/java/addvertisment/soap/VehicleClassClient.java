package addvertisment.soap;

import addvertisment.dto.VehicleClassDTO;
import addvertisment.service.VehicleClassService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class VehicleClassClient extends WebServiceGatewaySupport {

    @Autowired
    VehicleClassService vehicleClassService;

/*   public GetVCResponse postVC(VehicleClassDTO vehicleClassDTO)  {

        GetVCRequest request = new GetVCRequest();
        VehicleClassSoap vehicleClassSoap = new VehicleClassSoap();
        vehicleClassSoap.setId(vehicleClassDTO.getId());
        vehicleClassSoap.setVehicleClassName(vehicleClassDTO.getVehicle_class_name());
        request.setVehicleClassSoap(vehicleClassSoap);


        GetVCResponse response = (GetVCResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8081/ws/agent-schema", request,
                        new SoapActionCallback("http://localhost:8081/ws/agent-schema/getVCRequest"));

        return response;

    }*/
}
