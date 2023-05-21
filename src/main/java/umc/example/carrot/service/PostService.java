package umc.example.carrot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.example.carrot.entity.Post;
import umc.example.carrot.entity.User;
import umc.example.carrot.repository.PostRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public Long createPost(Post post) { //게시글 작성
        Post savedPost = postRepository.save(post);
        return savedPost.getId();
    }

    public List<Post> getAllPosts() {   //모든 게시글 조회
        return postRepository.findAll();
    }

    public Post getPostById(Long id) {  // 특정 유저 게시글 조회
        return postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid post ID: " + id));
    }

    public Long updatePost(Long id, Post updatedPost) { //게시글 수정
        Post post = getPostById(id);
        post.setTitle(updatedPost.getTitle());
        post.setContent(updatedPost.getContent());
        // Update other properties as needed
        postRepository.save(post);
        return post.getId();
    }

    public void deletePost(Long id) {   // 게시글 삭제    
        Post post = getPostById(id);
        postRepository.delete(post);
    }


    // 필요한 다른 메소드들을 추가로 구현할 수 있습니다.
}
