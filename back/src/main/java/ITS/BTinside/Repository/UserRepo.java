package ITS.BTinside.Repository;

import ITS.BTinside.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
}
