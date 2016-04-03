package hello.command;

import java.util.List;

public class TutorialCmd {
    private String uploader;
    private String tutorialName;
    private ImageCmd[] images;

    public TutorialCmd(String uploader, String tutorialName, ImageCmd[] images) {
        this.uploader = uploader;
        this.tutorialName = tutorialName;
        this.images = images;
    }

    public TutorialCmd() {

    }

    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }

    public String getTutorialName() {
        return tutorialName;
    }

    public void setTutorialName(String tutorialName) {
        this.tutorialName = tutorialName;
    }

    public ImageCmd[] getImages() {
        return images;
    }

    public void setImages(ImageCmd[] images) {
        this.images = images;
    }
}

