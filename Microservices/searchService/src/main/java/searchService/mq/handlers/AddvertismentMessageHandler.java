package searchService.mq.handlers;

import org.springframework.stereotype.Component;
import searchService.mq.dto.AddDTO;
import searchService.service.SearchService;

@Component
public class AddvertismentMessageHandler {

    private final SearchService searchService;

    public AddvertismentMessageHandler(SearchService searchService) {
        this.searchService = searchService;
    }

    public void createEntity(AddDTO message) {
        switch (message.getEntity()) {
            case ADD:
                this.searchService.save(message);
                System.out.println("-------------------- Created add in search ----------------------.");
                break;
            default:
                break;
        }
    }

}
