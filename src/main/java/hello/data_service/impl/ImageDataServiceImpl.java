package hello.data_service.impl;

import hello.command.ImageCmd;
import hello.data_service.ImageDataService;
//import hello.domain.Image;
import hello.exceptions.ErrorUploadingImageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ImageDataServiceImpl implements ImageDataService {
//
//    @Autowired
//    protected ImageRepository imageRepository;

    public List<ImageCmd> findAll() {
//        List<Image> images = imageRepository.findAll();
        List<ImageCmd> returnImages = new ArrayList<>();
//        images.stream().forEach((image) -> returnImages.add(setImageCmd(image)));
        return returnImages;
    }

//    protected ImageCmd setImageCmd(Image image) {
////        return new ImageCmd(image.getImage(), image.getUploader(), image.getTutorial(), image.getFileType());
//        return null;
//    }
//    protected Image setImage(ImageCmd imageCmd){
////        return new Image(imageCmd.getImage(), imageCmd.getUploader(), imageCmd.getTutorial(), imageCmd.getFileType());
//  return null;
//    }
    public boolean saveImages(List<ImageCmd> images){
//        images.stream().forEach((image) -> imageRepository.save(setImage(image)));
        return true;
    }
    public boolean saveImage(ImageCmd image){
        try {
//            imageRepository.save(setImage(image));
        }
        catch(Exception exception){
            throw new ErrorUploadingImageException(1);
        }
        return true;
    }
}
