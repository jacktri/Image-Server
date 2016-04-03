package hello.data_service.impl;

import hello.data_access.CommentRepository;
import hello.data_service.CommentDataService;
import hello.domain.Comment;
import hello.exceptions.ErrorUploadingImageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentDataServiceImpl implements CommentDataService {

    @Autowired
    protected CommentRepository commentRepository;

    public boolean saveComments(List<String> comments, String uploader, String tutorialName){
        try {
            comments.stream().forEach(comment -> saveComment(comment, uploader, tutorialName));
        }
            catch(Exception exception){
                throw new ErrorUploadingImageException(1);
            }
        return true;
    }
    protected void saveComment(String comment, String uploader, String tutorialName){
        commentRepository.save(new Comment(comment,uploader,tutorialName));
    }
}
