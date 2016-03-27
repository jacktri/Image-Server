package hello.application_service;

import hello.command.ImageCmd;

import java.util.List;

public interface ImageApplicationService {
    List<ImageCmd> getImages();
    boolean addImages(List<ImageCmd> images);
    boolean addImage(ImageCmd image);
}
