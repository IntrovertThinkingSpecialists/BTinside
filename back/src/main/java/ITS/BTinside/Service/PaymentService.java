package ITS.BTinside.Service;

import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import com.stripe.param.CustomerCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Value("${paypal.client.id}")
    private String paypalClientId;

    @Value("${paypal.secret}")
    private String paypalSecret;

    @Value("${paypal.mode}")
    private String paypalMode;

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

    public Payment createPaypalPayment(Double amount) throws PayPalRESTException {
        APIContext apiContext = new APIContext(paypalClientId, paypalSecret, paypalMode);
        // Payment 객체 생성 및 필요한 설정을 추가합니다.
        // ...

        Payment createdPayment = payment.create(apiContext);
        return createdPayment;
    }

    public Payment executePaypalPayment(String paymentId, String payerId) throws PayPalRESTException {
        APIContext apiContext = new APIContext(paypalClientId, paypalSecret, paypalMode);
        Payment payment = new Payment();
        payment.setId(paymentId);
        PaymentExecution paymentExecute = new PaymentExecution();
        paymentExecute.setPayerId(payerId);
        return payment.execute(apiContext, paymentExecute);
    }
}
