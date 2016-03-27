package hello.data_service;

import hello.command.ImageCmd;

import java.util.List;

public interface ImageDataService {
    List<ImageCmd> findAll();
    boolean saveImages(List<ImageCmd> images);
    boolean saveImage(ImageCmd image);
}
