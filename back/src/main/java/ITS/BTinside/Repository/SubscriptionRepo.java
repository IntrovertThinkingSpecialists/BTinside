package ITS.BTinside.Repository;

import ITS.BTinside.Entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepo extends JpaRepository<Subscription, Long> {
    void deleteByEmailAndTopic(String email, String topic);
}
