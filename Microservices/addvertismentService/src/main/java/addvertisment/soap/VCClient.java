package addvertisment.soap;

import addvertisment.dto.VehicleClassDTO;
import addvertisment.service.VehicleClassService;
//import com.xml.RentCar.wsdl.GetVCRequest;
//import com.xml.RentCar.wsdl.GetVCResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class VCClient extends WebServiceGatewaySupport {
    

   /* public GetVCResponse createVC(VehicleClassDTO vehicleClassDTOt)  {

        GetVCRequest request = new GetVCRequest();
        request.setId(vehicleClassDTOt.getId());
        request.setVehicleClassName(vehicleClassDTOt.getVehicle_class_name());
        GetVCResponse response = (GetVCResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8081/ws/agent-schema", request,
                        new SoapActionCallback("http://localhost:8081/ws/agent-schema/getVCRequest"));

        return response;
    }*/



}
