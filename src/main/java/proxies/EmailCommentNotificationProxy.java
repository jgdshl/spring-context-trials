package proxies;

import org.springframework.stereotype.Component;

import models.Comment;

@Component
public class EmailCommentNotificationProxy implements CommentNotificationProxy {
    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sending comment in email : " + comment.getText());
    }
}
