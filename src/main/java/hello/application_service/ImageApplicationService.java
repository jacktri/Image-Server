package hello.application_service;

import hello.command.ImageCmd;
import hello.command.TutorialCmd;

import java.util.List;

public interface ImageApplicationService {
    List<ImageCmd> getImages();
    boolean addImages(TutorialCmd tutorial);
}
