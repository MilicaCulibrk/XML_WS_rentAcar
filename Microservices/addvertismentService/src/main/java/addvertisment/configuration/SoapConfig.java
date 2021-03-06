package addvertisment.configuration;


import addvertisment.soap.AddClient;
import addvertisment.soap.PriceListClient;
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
        client.setDefaultUri("http://agent:8081/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
    @Bean
    public PriceListClient priceListClient(Jaxb2Marshaller marshaller) {
        PriceListClient client = new PriceListClient();
        client.setDefaultUri("http://agent:8081/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

}
