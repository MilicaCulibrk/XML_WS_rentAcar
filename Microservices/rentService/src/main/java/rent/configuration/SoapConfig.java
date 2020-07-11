package rent.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import rent.soap.RentClient;

@Configuration
public class SoapConfig {
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("agentBackend.wsdl");
        return marshaller;
    }

  /*  @Bean
    public AddClient addClient(Jaxb2Marshaller marshaller) {
        AddClient client = new AddClient();
        client.setDefaultUri("http://add-service:8087/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
    @Bean
    public PriceListClient priceListClient(Jaxb2Marshaller marshaller) {
        PriceListClient client = new PriceListClient();
        client.setDefaultUri("http://add-service:8087/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
*/
    @Bean
    public RentClient rentClient(Jaxb2Marshaller marshaller) {
        RentClient client = new RentClient();
        client.setDefaultUri("http://agent:8081/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
