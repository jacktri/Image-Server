package hello.application_service.impl;

import hello.application_service.ImageApplicationService;
import hello.command.ImageCmd;
import hello.data_service.ImageDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageApplicationServiceImpl implements ImageApplicationService {

    @Autowired
    protected ImageDataService imageDataService;

    public List<ImageCmd> getImages(){
       return imageDataService.findAll();
    }
    public boolean addImages(List<ImageCmd> images){
        return imageDataService.saveImages(images);
    }
}
