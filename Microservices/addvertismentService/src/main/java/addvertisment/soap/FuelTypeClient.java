package addvertisment.soap;


import addvertisment.dto.FuelTypeDTO;
import com.xml.RentCar.wsdl.FuelTypeRequest;
import com.xml.RentCar.wsdl.FuelTypeResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class FuelTypeClient extends WebServiceGatewaySupport {

    public FuelTypeResponse createVC(FuelTypeDTO fuelTypeDTO)  {

        FuelTypeRequest request = new FuelTypeRequest();
        request.setId(fuelTypeDTO.getId());
        request.setFuelTypeName(fuelTypeDTO.getFuel_type_name());
        FuelTypeResponse response = (FuelTypeResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://agent:8081/ws/fuelType-schema", request,
                        new SoapActionCallback("http://agent:8081/ws/fuelType-schema/FuelTypeRequest"));

        return response;
    }
}
