package ITS.BTinside.Service;

import ITS.BTinside.Entity.Subscription;
import ITS.BTinside.Entity.SubscriptionPlan;
import ITS.BTinside.Entity.User;
import ITS.BTinside.Repository.SubscriptionRepo;
import ITS.BTinside.Repository.SubscriptionPlanRepo;
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

    @Autowired
    private SubscriptionPlanRepo subscriptionPlanRepository;

    public Subscription subscribeUser(Long userId, String subscriptionType) {
        Optional<User> userOpt = userRepository.findById(String.valueOf(userId));
        if (userOpt.isEmpty()) {
            throw new IllegalArgumentException("Invalid user ID");
        }

        User user = userOpt.get();
        SubscriptionPlan plan = subscriptionPlanRepository.findByName(subscriptionType)
                .orElseThrow(() -> new IllegalArgumentException("Invalid subscription plan"));

        Subscription subscription = new Subscription();
        subscription.setUser(user);
        subscription.setSubscriptionPlan(plan);
        subscription.setStartDate(new Timestamp(System.currentTimeMillis()));
        subscription.setEndDate(new Timestamp(System.currentTimeMillis() + plan.getDuration() * 30L * 24 * 60 * 60 * 1000));  // 구독 기간 설정

        return subscriptionRepository.save(subscription);
    }

    public Subscription getSubscription(Long userId) {
        return subscriptionRepository.findByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("No subscription found for user ID " + userId));
    }
}
