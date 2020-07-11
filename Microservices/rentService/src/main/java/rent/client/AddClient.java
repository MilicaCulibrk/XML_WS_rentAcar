package rent.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import rent.dto.AddvertismentRentDTO;
import rent.dto.ReportDTO;
import rent.model.Report;

@FeignClient(name = "add-service")
public interface AddClient {

    @GetMapping("/addvertisment/rent/{id}/{kilometresCrossed}")
    AddvertismentRentDTO getAddById(@PathVariable Long id, @PathVariable float kilometresCrossed);

}