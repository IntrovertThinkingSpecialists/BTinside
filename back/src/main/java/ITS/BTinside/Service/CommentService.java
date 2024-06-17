package ITS.BTinside.Service;

import ITS.BTinside.Entity.Comment;
import ITS.BTinside.Repository.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepo commentRepo;

    public List<Comment> findAll() {
        return commentRepo.findAll();
    }

    public Optional<Comment> findById(Long id) {
        return commentRepo.findById(id);
    }

    public Comment save(Comment comment) {
        return commentRepo.save(comment);
    }

    public void deleteById(Long id) {
        commentRepo.deleteById(id);
    }
}
