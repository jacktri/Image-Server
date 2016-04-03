package hello.application_service.impl;

import hello.application_service.CommentApplicationService;
import hello.command.ImageCmd;
import hello.command.TutorialCmd;
import hello.data_service.CommentDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentApplicationServiceImpl implements CommentApplicationService {

    @Autowired
    protected CommentDataService commentDataService;

    public boolean saveComments(TutorialCmd tutorialCmd){
        List<String> comments = new ArrayList<>();
        ImageCmd[] imageArray = tutorialCmd.getImages();
        for(int i = 0; i < imageArray.length; i++){
            comments.add(imageArray[i].getComment());
        }
        return commentDataService.saveComments(comments,tutorialCmd.getUploader(),tutorialCmd.getTutorialName());
    }
}
