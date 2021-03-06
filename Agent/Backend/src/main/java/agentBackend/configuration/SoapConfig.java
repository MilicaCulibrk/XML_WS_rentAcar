package agentBackend.configuration;

import agentBackend.soap.AddClient;
import agentBackend.soap.PriceListClient;
import agentBackend.soap.RentClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapConfig {
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("agentBackend.wsdl");
        return marshaller;
    }

    @Bean
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

    @Bean
    public RentClient rentClient(Jaxb2Marshaller marshaller) {
        RentClient client = new RentClient();
        client.setDefaultUri("http://rent-service:8084/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
