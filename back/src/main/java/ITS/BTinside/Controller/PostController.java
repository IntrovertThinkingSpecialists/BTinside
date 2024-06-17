package ITS.BTinside.Controller;

import ITS.BTinside.Entity.Post;
import ITS.BTinside.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public List<Post> getAllPosts() {
        return postService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        Optional<Post> post = postService.findById(id);
        return post.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postService.save(post);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody Post postDetails) {
        Optional<Post> post = postService.findById(id);
        if (post.isPresent()) {
            Post updatedPost = post.get();
            updatedPost.setPost_title(postDetails.getPost_title());
            updatedPost.setPost_content(postDetails.getPost_content());
            updatedPost.setPost_views(postDetails.getPost_views());
            updatedPost.setPost_likes(postDetails.getPost_likes());
            updatedPost.setPost_file(postDetails.getPost_file());
            updatedPost.setProfile(postDetails.getProfile());
            updatedPost.setCategory(postDetails.getCategory());
            return ResponseEntity.ok(postService.save(updatedPost));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        Optional<Post> post = postService.findById(id);
        if (post.isPresent()) {
            postService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
