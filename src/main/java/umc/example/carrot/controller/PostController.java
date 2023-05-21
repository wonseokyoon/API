package umc.example.carrot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.example.carrot.entity.Post;
import umc.example.carrot.service.PostService;

import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("")
    public ResponseEntity<Long> createPost(@RequestBody Post post) {    //게시글 작성
        Long postId = postService.createPost(post);
        return ResponseEntity.ok(postId);
    }

    @GetMapping("")
    public ResponseEntity<List<Post>> getAllPosts() {       //모든 게시물 보기
        List<Post> posts = postService.getAllPosts();
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {    // 특정 유저 게시물 조회
        Post post = postService.getPostById(id);
        return ResponseEntity.ok(post);
    }

    @PutMapping("/{id}")  //게시글 수정
    public ResponseEntity<Long> updatePost(@PathVariable Long id, @RequestBody Post updatedPost) {
        Long postId = postService.updatePost(id, updatedPost);
        return ResponseEntity.ok(postId);
    }

    @DeleteMapping("/{id}")     //게시글 삭제
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }


}
