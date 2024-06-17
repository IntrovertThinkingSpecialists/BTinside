package ITS.BTinside.Service;

import ITS.BTinside.Entity.Post;
import ITS.BTinside.Repository.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepo postRepo;

    public List<Post> findAll() {
        return postRepo.findAll();
    }

    public Optional<Post> findById(Long id) {
        return postRepo.findById(id);
    }

    public Post save(Post post) {
        return postRepo.save(post);
    }

    public void deleteById(Long id) {
        postRepo.deleteById(id);
    }
}
