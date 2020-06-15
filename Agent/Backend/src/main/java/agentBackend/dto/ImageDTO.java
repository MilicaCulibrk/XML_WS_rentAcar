package agentBackend.dto;

import agentBackend.model.Image;

public class ImageDTO {

    private Long id;
    private String url;

    public ImageDTO(){
        super();
    }

    public ImageDTO(Long id, String url) {
        this.id = id;
        this.url = url;
    }
    public ImageDTO(Image images) {
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
