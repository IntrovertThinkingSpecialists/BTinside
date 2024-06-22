package ITS.BTinside.Service;

import ITS.BTinside.Entity.User;
import ITS.BTinside.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public Optional<User> findById(String id) {
        return userRepo.findById(id);
    }

    public User save(User user) {
        return userRepo.save(user);
    }

    public void deleteById(String id) {
        userRepo.deleteById(id);
    }
}
