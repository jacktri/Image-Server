package hello.data_service;

import hello.command.TutorialCmd;

public interface TutorialDataService {
    boolean saveTutorial(String uploader, String tutorialName);
}
