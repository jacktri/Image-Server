package hello.application_service;

import hello.command.TutorialCmd;

public interface TutorialApplicationService {

    boolean addTutorial(TutorialCmd tutorialCmd);
}
