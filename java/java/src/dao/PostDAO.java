package dao;

import model.Post;
import java.util.List;

public interface PostDAO {
	// 게시글 작성
	boolean createPost(Post post);

	// 게시글 수정
	boolean updatePost(Post post);

	// 게시글 삭제
	boolean deletePost(String postId);

	// 게시글 조회 (특정 게시글)
	Post getPost(String postId);

	// 전체 게시글 조회 (페이징 처리)
	List<Post> getAllPosts(int pageNumber, int pageSize);
}