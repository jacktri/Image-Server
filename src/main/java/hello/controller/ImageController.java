package hello.controller;

import hello.application_service.CommentApplicationService;
import hello.application_service.ImageApplicationService;
import hello.application_service.TutorialApplicationService;
import hello.command.ImageCmd;
import hello.command.ServiceError;
import hello.command.TutorialCmd;
import hello.exceptions.ErrorUploadingImageException;
import hello.exceptions.ImageNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.http.HttpStatus.*;
@RestController
@RequestMapping("/images")
public class ImageController {

    @Autowired
    protected ImageApplicationService imageApplicationService;

    @Autowired
    protected TutorialApplicationService tutorialApplicationService;

    @Autowired
    protected CommentApplicationService commentApplicationService;

    @RequestMapping(method = GET)
    public TutorialCmd get() {
        System.out.println("heck");
        TutorialCmd tutorial = new TutorialCmd();
        tutorial.setUploader("the god");
        tutorial.setTutorialName("best tutroial");
        ImageCmd imageCmd = new ImageCmd();
        imageCmd.setComment("neck");
        imageCmd.setImage("sdsdfdsfsdfsdfsdfsfsdf");
        imageCmd.setImageType("gif");
        ImageCmd[] images = new ImageCmd[1];
        images[0] = imageCmd;
        tutorial.setImages(images);
      //  List<ImageCmd> images = imageApplicationService.getImages();
      //  String code = images.get(0).getImage();
//        if(images == null){
//            throw new ImageNotFoundException(4);
//        }
        return tutorial;
    }

    @RequestMapping(method = POST)
    @ResponseStatus(CREATED)
    public String add(@RequestBody TutorialCmd tutorial) {
       // System.out.println("in here" + tutorial.getImages()[0].getComment());
       boolean result =  tutorialApplicationService.addTutorial(tutorial);
        if(result){
            result = saveComments(tutorial);

        }
        if(result!=true) {
            System.out.println("failure");
            throw new ErrorUploadingImageException(1);
        }
        System.out.println("success");
        return "images uploaded successfully";
    }
    protected boolean saveComments(TutorialCmd tutorial){
        boolean result = commentApplicationService.saveComments(tutorial);
        if(result){
            result = imageApplicationService.addImages(tutorial);
        }
        return result;
    }

    @ExceptionHandler(ImageNotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    public ServiceError imageNotFound(ImageNotFoundException exception){
        Integer id = exception.getImageId();
        ServiceError serviceError = new ServiceError(4, "image not found for image " + id);
        return serviceError;
    }
    @ExceptionHandler(ErrorUploadingImageException.class)
    @ResponseStatus(FORBIDDEN)
    public ServiceError uploadUnsuccessful(ErrorUploadingImageException exception){
        Integer numberOfImages = exception.getImageCount();
        ServiceError serviceError = new ServiceError(4, "Error uploading " + numberOfImages + " images");
        return serviceError;
    }
}
