package umc.example.carrot.controller;

import org.springframework.http.ResponseEntity;
import umc.example.carrot.entity.User;
import umc.example.carrot.entity.Post;
import umc.example.carrot.service.PostService;
import umc.example.carrot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;
    private final PostService postService;

    @PostMapping("/user")
    public Long create(@RequestBody User user) {
        return userService.save(user);
    }



    /*@GetMapping("/user/{id}")
    public User read(@PathVariable Long id) {
        return userService.findById(id);
    }*/
    @GetMapping("/user/{id}")
    public ResponseEntity<User> read(@PathVariable Long id) {
        try {
            User user = userService.findById(id);
            return ResponseEntity.ok(user);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/user/{id}/update")
    public Long update(@PathVariable Long id, @RequestBody User user) {
        return userService.update(id, user);
    }

    @PostMapping("/user/{id}/delete")
    public Long delete(@PathVariable Long id) {
        userService.delete(id);
        return id;
    }



}
