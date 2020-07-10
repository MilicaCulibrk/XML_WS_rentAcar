package searchService.mq.handlers;

import org.springframework.stereotype.Component;
import searchService.dto.BrandsDTO;
import searchService.mq.dto.AddDTO;
import searchService.service.BrandsService;
import searchService.service.SearchService;

@Component
public class AddvertismentMessageHandler {

    private final SearchService searchService;

    public AddvertismentMessageHandler(SearchService searchService) {
        this.searchService = searchService;
    }

    public void createEntity(AddDTO message) {

        this.searchService.save(message);
        System.out.println("-------------------- Created add in search ----------------------.");

    }

    public void updateEntity(AddDTO message) {

        this.searchService.update(message);
        System.out.println("-------------------- Updated add in search ----------------------.");

    }

    public void deleteEntity(AddDTO message) {

        this.searchService.delete(message);
        System.out.println("-------------------- Deleted add in search ----------------------.");

    }


}
