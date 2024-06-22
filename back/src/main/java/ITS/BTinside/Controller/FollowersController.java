package ITS.BTinside.Controller;

import ITS.BTinside.Entity.Followers;
import ITS.BTinside.Service.FollowersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/followers")
public class FollowersController {

    @Autowired
    private FollowersService followersService;

    @GetMapping
    public List<Followers> getAllFollowers() {
        return followersService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Followers> getFollowerById(@PathVariable Long id) {
        Optional<Followers> follower = followersService.findById(id);
        return follower.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Followers createFollower(@RequestBody Followers follower) {
        return followersService.save(follower);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Followers> updateFollower(@PathVariable Long id, @RequestBody Followers followerDetails) {
        Optional<Followers> follower = followersService.findById(id);
        if (follower.isPresent()) {
            Followers updatedFollower = follower.get();
            updatedFollower.setFollowee(followerDetails.getFollowee());
            updatedFollower.setProfile(followerDetails.getProfile());
            return ResponseEntity.ok(followersService.save(updatedFollower));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFollower(@PathVariable Long id) {
        Optional<Followers> follower = followersService.findById(id);
        if (follower.isPresent()) {
            followersService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
