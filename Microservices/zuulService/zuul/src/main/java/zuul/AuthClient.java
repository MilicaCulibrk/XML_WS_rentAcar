package zuul;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service")
public interface AuthClient {

    @GetMapping("/verify/{email}/{password}")
    String verify(@PathVariable("email") String email, @PathVariable("password") String password);

}
