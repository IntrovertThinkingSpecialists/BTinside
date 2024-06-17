package ITS.BTinside.Service;

import ITS.BTinside.Entity.Profile;
import ITS.BTinside.Repository.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepo profileRepo;

    public List<Profile> findAll() {
        return profileRepo.findAll();
    }

    public Optional<Profile> findById(Long id) {
        return profileRepo.findById(id);
    }

    public Profile save(Profile profile) {
        return profileRepo.save(profile);
    }

    public void deleteById(Long id) {
        profileRepo.deleteById(id);
    }
}
