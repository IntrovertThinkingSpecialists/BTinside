package ITS.BTinside.Service;

import ITS.BTinside.Entity.Subscription;
import ITS.BTinside.Entity.User;
import ITS.BTinside.Repository.SubscriptionRepo;
import ITS.BTinside.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;

@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionRepo subscriptionRepository;

    @Autowired
    private UserRepo userRepository;

    public Subscription subscribeUser(Long userId, String subscriptionType) {
        Optional<User> userOpt = userRepository.findById(String.valueOf(userId));
        if (userOpt.isEmpty()) {
            throw new IllegalArgumentException("Invalid user ID");
        }

        User user = userOpt.get();
        Subscription subscription = new Subscription();
        subscription.setUser(user);
        subscription.setSubscriptionType(subscriptionType);
        subscription.setStartDate(new Timestamp(System.currentTimeMillis()));
        // 예제에서는 1년 구독을 가정합니다.
        subscription.setEndDate(new Timestamp(System.currentTimeMillis() + 365L * 24 * 60 * 60 * 1000));

        return subscriptionRepository.save(subscription);
    }

    public Subscription getSubscription(Long userId) {
        return subscriptionRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("No subscription found for user ID " + userId));
    }
}
