package ITS.BTinside.Repository;

import ITS.BTinside.Entity.Followers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowersRepo extends JpaRepository<Followers, Long> {
}
