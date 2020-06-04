package zuul;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "user-service")
public interface AuthClient {

	@RequestMapping(value = "verify/{email}", method = RequestMethod.GET, produces = "application/json")
    String verify(@PathVariable("email") String email);

}
