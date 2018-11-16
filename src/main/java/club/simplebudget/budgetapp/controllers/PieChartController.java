package club.simplebudget.budgetapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PieChartController {
    @GetMapping("/pie")
    public String pieChartPae() {
        return "users/pie-chart";
    }
}
