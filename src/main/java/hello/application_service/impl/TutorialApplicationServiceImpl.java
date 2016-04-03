package hello.application_service.impl;

import hello.application_service.TutorialApplicationService;
import hello.command.ImageCmd;
import hello.command.TutorialCmd;
import hello.data_service.TutorialDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TutorialApplicationServiceImpl implements TutorialApplicationService{

    @Autowired
    protected TutorialDataService tutorialDataService;

    public boolean addTutorial(TutorialCmd tutorialCmd){
        return tutorialDataService.saveTutorial(tutorialCmd.getUploader(),tutorialCmd.getTutorialName());
    }
}
