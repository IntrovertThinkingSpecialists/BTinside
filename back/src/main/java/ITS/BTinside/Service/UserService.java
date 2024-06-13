package ITS.BTinside.Service;

import ITS.BTinside.Entity.User;
import ITS.BTinside.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public List<User> getAllUsers(){
        return  userRepo.findAll();

    }
    public  User saveUser(User user){
        return userRepo.save(user);
    }
}
