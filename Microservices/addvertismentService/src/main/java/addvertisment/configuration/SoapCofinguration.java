package addvertisment.configuration;

import addvertisment.soap.FuelTypeClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapCofinguration {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath("com.xml.RentCar.wsdl");
        return marshaller;
    }



    @Bean
    public FuelTypeClient adClient(Jaxb2Marshaller marshaller) {
        FuelTypeClient client = new FuelTypeClient();
        client.setDefaultUri("http://localhost:8081/fuelType-schema/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

}
