package ITS.BTinside.Service;

import ITS.BTinside.Entity.Payment;
import ITS.BTinside.Entity.Subscription;
import ITS.BTinside.Entity.SubscriptionPlan;
import ITS.BTinside.Entity.User;
import ITS.BTinside.Repository.PaymentRepository;
import ITS.BTinside.Repository.SubscriptionPlanRepo;
import ITS.BTinside.Repository.SubscriptionRepo;
import ITS.BTinside.Repository.UserRepo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class DataLoader {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private SubscriptionPlanRepo subscriptionPlanRepo;

    @Autowired
    private SubscriptionRepo subscriptionRepo;

    @Autowired
    private PaymentRepository paymentRepository;

    @PostConstruct
    public void loadData() {
        // Create and save users
        User user1 = new User();
        user1.setName("John Doe");
        user1.setPw("password");
        user1.setPhone("123-456-7890");
        userRepo.save(user1);

        // Create and save subscription plans
        SubscriptionPlan basicPlan = new SubscriptionPlan();
        basicPlan.setPlanName("Basic Plan");
        basicPlan.setPrice(10.0);
        basicPlan.setDuration(1);
        basicPlan.setPersonaLimit(5);
        basicPlan.setNeighborLimit(10);
        basicPlan.setDailyPostLimit(10);
        subscriptionPlanRepo.save(basicPlan);

        SubscriptionPlan platinumPlan = new SubscriptionPlan();
        platinumPlan.setPlanName("Platinum Plan");
        platinumPlan.setPrice(30.0);
        platinumPlan.setDuration(1);
        platinumPlan.setPersonaLimit(10);
        platinumPlan.setNeighborLimit(20);
        platinumPlan.setDailyPostLimit(20);
        subscriptionPlanRepo.save(platinumPlan);

        SubscriptionPlan vipPlan = new SubscriptionPlan();
        vipPlan.setPlanName("VIP Plan");
        vipPlan.setPrice(50.0);
        vipPlan.setDuration(1);
        vipPlan.setPersonaLimit(Integer.MAX_VALUE); // For unlimited
        vipPlan.setNeighborLimit(Integer.MAX_VALUE); // For unlimited
        vipPlan.setDailyPostLimit(Integer.MAX_VALUE); // For unlimited
        subscriptionPlanRepo.save(vipPlan);

        // Create and save payment
        Payment payment1 = new Payment();
        payment1.setUser(user1);
        payment1.setSubscriptionPlan(basicPlan);
        payment1.setPaymentDate(new Timestamp(System.currentTimeMillis()));
        payment1.setAmount(10.0);
        paymentRepository.save(payment1);

        // Create and save subscription
        Subscription subscription1 = new Subscription();
        subscription1.setUser(user1);
        subscription1.setSubscriptionPlan(basicPlan);
        subscription1.setStartDate(new Timestamp(System.currentTimeMillis()));
        subscription1.setEndDate(new Timestamp(System.currentTimeMillis() + (30L * 24 * 60 * 60 * 1000)));
        subscription1.setStatus("ACTIVE");
        subscriptionRepo.save(subscription1);
    }

}
