package hello.data_service;

import java.util.List;

public interface CommentDataService {

    boolean saveComments(List<String> comments, String uploader, String tutorialName);
}
