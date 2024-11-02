package dao;

import java.util.List;

import model.Comment;

public interface CommentDAO {
    // 댓글 작성 메서드
    boolean writeComment(Comment comment);

    // 댓글 삭제 메서드
    boolean deleteComment(String commentId);

    // 댓글 조회 메서드
    List<Comment> viewComment(String postId);
}
