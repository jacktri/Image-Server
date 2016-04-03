package hello.application_service.impl;

import hello.application_service.ImageApplicationService;
import hello.command.ImageCmd;
import hello.command.TutorialCmd;
import hello.data_service.ImageDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;
import java.util.List;

import static hello.constant.ImageConstants.*;

@Service
public class ImageApplicationServiceImpl implements ImageApplicationService {

    @Autowired
    protected ImageDataService imageDataService;

    public List<ImageCmd> getImages() {
        return imageDataService.findAll();
    }

    public boolean addImages(TutorialCmd tutorial) {
        ImageCmd[] imageArray = tutorial.getImages();
        String folderName = TUTORIAL_FOLDER + tutorial.getUploader() + tutorial.getTutorialName();
        makeFolder(folderName);
        saveImagesAndHost(imageArray, folderName, tutorial.getUploader(), tutorial.getTutorialName());
        folderName = HOSTED_TUTORIALS_FOLDER + tutorial.getUploader() + tutorial.getTutorialName();
        makeFolder(folderName);
        return saveImagesAndHost(imageArray, folderName, tutorial.getUploader(), tutorial.getTutorialName());
    }

    protected void makeFolder(String folderName){
        File imageFolder = new File(folderName);
        imageFolder.mkdir();
    }

    protected boolean saveImagesAndHost(ImageCmd[] imageArray, String folderName, String uploader, String tutorialName) {
        boolean result = true;
        for (int i = 0; i < imageArray.length; i++) {
            if (result) {
                String fileName = uploader + tutorialName + i;
                result = createImage(imageArray[i].getImage(), imageArray[i].getImageType(), folderName, fileName);
            } else {
                return false;
            }
        }
        return true;
    }


    protected void storeImage(byte[] image, String uploader, String tutorial, String fileType) {
        File file = new File(uploader + tutorial + DOT + fileType);
    }

    protected boolean createImage(String imageDataString, String fileType, String folderName, String fileName) {
        byte[] data = Base64.getDecoder().decode(imageDataString);
        File file = new File(folderName + SLASH + fileName + DOT + fileType);
        try (OutputStream stream = new FileOutputStream(file)) {
            stream.write(data);
        } catch (IOException exception) {
            System.out.println("failed creating folder/files");
            return false;
        }
        return true;
    }
}
