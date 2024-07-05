package ITS.BTinside.Service;

import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import com.stripe.param.CustomerCreateParams;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    public String createCustomer(String email, String token) throws StripeException {
        CustomerCreateParams params =
                CustomerCreateParams.builder()
                        .setEmail(email)
                        .setSource(token)
                        .build();

        Customer customer = Customer.create(params);
        return customer.getId();
    }

    public Charge chargeCustomer(String customerId, int amount) throws StripeException {
        Map<String, Object> chargeParams = new HashMap<>();
        chargeParams.put("amount", amount);
        chargeParams.put("currency", "usd");
        chargeParams.put("customer", customerId);

        return Charge.create(chargeParams);
    }
}