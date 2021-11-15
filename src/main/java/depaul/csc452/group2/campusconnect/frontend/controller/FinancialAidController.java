package depaul.csc452.group2.campusconnect;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/financialaid")
public class FinancialAidController {

    @Autowired
    FinancialAidRepository financialAidRepository;

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/info")
    public String findMyFinancialAid() {
        return financialAidRepository.findAll().toString();
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/price/{id}")
    public int currentBalance(@PathVariable Long id ) {
        return financialAidRepository.findBystudentid(id).getAidAmount();
    }





}
