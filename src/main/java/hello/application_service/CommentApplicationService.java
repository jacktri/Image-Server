package hello.application_service;

import hello.command.TutorialCmd;

public interface CommentApplicationService {

    boolean saveComments(TutorialCmd tutorialCmd);
}
