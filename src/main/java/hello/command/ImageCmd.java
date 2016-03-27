package hello.command;

public class ImageCmd {
    private String image;
    private String uploader;
    private String tutorial;

    public ImageCmd(){

    }
    public ImageCmd(String image, String uploader, String tutorial) {
        this.image = image;
        this.uploader = uploader;
        this.tutorial = tutorial;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }

    public String getTutorial() {
        return tutorial;
    }

    public void setTutorial(String tutorial) {
        this.tutorial = tutorial;
    }
}
