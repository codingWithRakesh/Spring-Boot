package internalWorking.secondSpringProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SecondSpringProjectApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SecondSpringProjectApplication.class, args);
	}

//    1st type dependency injection
//    @Autowired
//    private RazorpayPaymentService paymentService;

//    2nd type of dependency injection   [Best]
    private final PaymentService paymentService;

    public SecondSpringProjectApplication(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Override
    public void run(String... args) throws Exception {
        String payment = paymentService.pay();
        System.out.println("Payment done: "+payment);
    }
}
