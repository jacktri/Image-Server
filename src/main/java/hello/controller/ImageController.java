package hello.controller;

import hello.application_service.ImageApplicationService;
import hello.command.ImageCmd;
import hello.command.ServiceError;
import hello.exceptions.ErrorUploadingImageException;
import hello.exceptions.ImageNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/images")
public class ImageController {

    @Autowired
    protected ImageApplicationService imageApplicationService;

    @RequestMapping(method = RequestMethod.GET)
    public List<ImageCmd> get() {
        System.out.println("heck");
        List<ImageCmd> images = imageApplicationService.getImages();
        if(images == null){
            throw new ImageNotFoundException(4);
        }
        return images;
    }

    @RequestMapping(method = RequestMethod.POST)
//    @ResponseStatus(HttpStatus.CREATED)
    public String add(@RequestBody ImageCmd image) {
        System.out.println("in here");
       boolean result =  imageApplicationService.addImage(image);
        if(result!=true) {
            throw new ErrorUploadingImageException(1);
        }
        int i = 4;
        return "images uploaded successfully";
    }
    @ExceptionHandler(ImageNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ServiceError imageNotFound(ImageNotFoundException exception){
        Integer id = exception.getImageId();
        ServiceError serviceError = new ServiceError(4, "image not found for image " + id);
        return serviceError;
    }
    @ExceptionHandler(ErrorUploadingImageException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ServiceError uploadUnsuccessful(ErrorUploadingImageException exception){
        Integer numberOfImages = exception.getImageCount();
        ServiceError serviceError = new ServiceError(4, "Error uploading " + numberOfImages + " images");
        return serviceError;
    }
}
