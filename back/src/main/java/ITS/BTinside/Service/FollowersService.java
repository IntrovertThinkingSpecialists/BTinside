package ITS.BTinside.Service;

import ITS.BTinside.Entity.Followers;
import ITS.BTinside.Repository.FollowersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FollowersService {

    @Autowired
    private FollowersRepo followersRepo;

    public List<Followers> findAll() {
        return followersRepo.findAll();
    }

    public Optional<Followers> findById(Long id) {
        return followersRepo.findById(id);
    }

    public Followers save(Followers followers) {
        return followersRepo.save(followers);
    }

    public void deleteById(Long id) {
        followersRepo.deleteById(id);
    }
}
