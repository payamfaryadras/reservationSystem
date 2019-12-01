package com.payam.learn.reservation.controller;

import com.payam.learn.reservation.model.Trip;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DashboardController {

    @GetMapping("/trip")
    public String getTrip(final Model model) {
        Trip trip = new Trip();
        model.addAttribute("trip",trip);
        return "trip";
    }

}
