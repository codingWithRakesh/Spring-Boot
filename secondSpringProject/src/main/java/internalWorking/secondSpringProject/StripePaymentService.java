package internalWorking.secondSpringProject;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//All Same
//@Component
//@Service
//@RestController
//@Repository

@Component
@ConditionalOnProperty(name = "payment.provider", havingValue = "stripe")
public class StripePaymentService implements PaymentService {
    @Override
    public String pay(){
        String payment = "Stripe Payment";
        System.out.println("Payment from"+payment);
        return payment;
    }
}
