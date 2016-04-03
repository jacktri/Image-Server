package hello.data_service.impl;

import hello.command.TutorialCmd;
import hello.data_access.TutorialRepository;
import hello.data_service.TutorialDataService;
import hello.domain.Tutorial;
import hello.exceptions.ErrorUploadingImageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TutorialDataServiceImpl implements TutorialDataService {

    @Autowired
    protected TutorialRepository tutorialRepository;

    public boolean saveTutorial(String uploader, String tutorialName){
        try {
            tutorialRepository.save(new Tutorial(uploader,tutorialName));
        }
        catch(Exception exception){
            throw new ErrorUploadingImageException(1);
        }
        return true;
    }
}
