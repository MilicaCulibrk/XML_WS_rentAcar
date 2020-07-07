package agentBackend.configuration;

import agentBackend.soap.AddClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapConfig {
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath("agentBackend.wsdl");
        return marshaller;
    }

    @Bean
    public AddClient adClient(Jaxb2Marshaller marshaller) {
        AddClient client = new AddClient();
        client.setDefaultUri("http://localhost:8087/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
