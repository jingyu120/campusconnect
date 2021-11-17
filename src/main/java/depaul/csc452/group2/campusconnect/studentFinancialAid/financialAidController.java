package depaul.csc452.group2.campusconnect.studentFinancialAid;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@RestController
@RequestMapping("/financialaid")
public class financialAidController {

    @Autowired
    FinancialAidRepository financialAidRepository;

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/financialAidInformation")
    public String studentFinancialAid() {
        return financialAidRepository.findAll().toString();
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/amount/{id}")
    public int currentBalance(@PathVariable Long id ) {
        return financialAidRepository.findBystudentid(id).getAidAmount();
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/financialAidInformation")
    public static class Payment {
        protected String type;
        protected double amount;
        protected List<Payment> payments = new ArrayList<>();


        public Payment(String type, double amount) {
            super();
            this.type = type;
            this.amount = amount;
        }



        public void makePayment(Payment payment) {
            payments.add(payment);
            payment.pay();
        }
         public void pay() {
            System.out.println(type + " " + "$" + amount);
        }

    }

        @CrossOrigin(origins = "http://localhost:8080")
        @GetMapping("/amount/{id}")
        public void applyForScholarship() {
            if (student.eligibleScholarships.isEmpty())
            {
                System.out.println("You are not eligible for scholarships.");
            }
            else
            {
                for (Scholarship school: student.eligibleScholarships)
                {
                    Scanner scan = new Scanner(System.in);
                    int choice = -1;
                    int i = 1;

                    while (choice != 0)
                    {
                      //  check Eligible Scholarships();
                       choice = scan.nextInt();
                        if (choice == 0)
                        {
                            break;
                        }
                        else
                        {
                            student.appliedScholarships.add(student.eligibleScholarships.get(choice - 1));
                            System.out.println("You applied to: ");
                            System.out.println(student.eligibleScholarships.get(choice - 1).toString());

                            System.out.println(student.eligibleScholarships.get(choice - 1).reward + "added to your balance.");
                            student.balance += student.eligibleScholarships.get(choice - 1).reward;
                           // currentBalance();
                        }
                    }
                }



}
