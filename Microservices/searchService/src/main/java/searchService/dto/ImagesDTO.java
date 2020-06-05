package searchService.dto;

import searchService.model.Images;
import searchService.model.ReservedDates;

public class ImagesDTO {

    private Long id;
    private String url;

    public ImagesDTO(){
        super();
    }

    public ImagesDTO(Long id, String url) {
        this.id = id;
        this.url = url;
    }
    public ImagesDTO(Images images) {
        this.id = images.getId();
        this.url = images.getUrl();
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
