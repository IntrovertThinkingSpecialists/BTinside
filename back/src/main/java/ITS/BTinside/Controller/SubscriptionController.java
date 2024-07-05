package ITS.BTinside.Controller;

import ITS.BTinside.Entity.Subscription;
import ITS.BTinside.Service.PaymentService;
import ITS.BTinside.Service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/subscription")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;
    @Autowired
    private PaymentService paymentService;


    @PostMapping("/subscribe")
    public Subscription subscribeUser(@RequestBody Map<String, Object> payload) throws Exception {
        Long userId = Long.valueOf(payload.get("userId").toString());
        String subscriptionType = payload.get("subscriptionType").toString();
        String token = payload.get("token").toString();
        String email = payload.get("email").toString();

        // 결제 처리
        String customerId = paymentService.createCustomer(email, token);
        paymentService.chargeCustomer(customerId, 1000); // 예제에서 1000 달러로 가정

        return subscriptionService.subscribeUser(userId, subscriptionType);
    }

    @GetMapping("/{userId}")
    public Subscription getSubscription(@PathVariable Long userId) {
        return subscriptionService.getSubscription(userId);
    }
}
