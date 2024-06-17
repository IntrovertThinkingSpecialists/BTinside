package ITS.BTinside.Controller;

import ITS.BTinside.Entity.Profile;
import ITS.BTinside.Service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/profiles")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping
    public List<Profile> getAllProfiles() {
        return profileService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profile> getProfileById(@PathVariable Long id) {
        Optional<Profile> profile = profileService.findById(id);
        return profile.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Profile createProfile(@RequestBody Profile profile) {
        return profileService.save(profile);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Profile> updateProfile(@PathVariable Long id, @RequestBody Profile profileDetails) {
        Optional<Profile> profile = profileService.findById(id);
        if (profile.isPresent()) {
            Profile updatedProfile = profile.get();
            updatedProfile.setProfile_pic(profileDetails.getProfile_pic());
            updatedProfile.setProfile_name(profileDetails.getProfile_name());
            updatedProfile.setProfile_type(profileDetails.getProfile_type());
            updatedProfile.setUser(profileDetails.getUser());
            return ResponseEntity.ok(profileService.save(updatedProfile));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfile(@PathVariable Long id) {
        Optional<Profile> profile = profileService.findById(id);
        if (profile.isPresent()) {
            profileService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
