package services;

import org.springframework.stereotype.Component;

import models.Comment;
import proxies.CommentNotificationProxy;
import repositories.CommentRepository;

@Component
public class CommentService {
   private final CommentNotificationProxy commentNotificationProxy;
   private final CommentRepository commentRepository;
   
   public CommentService(
        CommentNotificationProxy commentNotificationProxy,
        CommentRepository commentRepository) {
            this.commentNotificationProxy = commentNotificationProxy;
            this.commentRepository = commentRepository;
    }

    public void publishComment(Comment comment) {
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
    }
}
