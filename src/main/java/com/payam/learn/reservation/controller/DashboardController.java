package com.payam.learn.reservation.controller;

import com.payam.learn.reservation.dto.model.BusDto;
import com.payam.learn.reservation.dto.model.StopDto;
import com.payam.learn.reservation.dto.model.TripDto;
import com.payam.learn.reservation.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class DashboardController {

    @Autowired
    ReservationService reservationService;

    @GetMapping("/trip")
    public ModelAndView createTrip() {
        ModelAndView modelAndView = addTripsToModel(new ModelAndView());
        modelAndView = addStopsToModel(modelAndView);
        modelAndView = addBusesToModel(modelAndView);
        modelAndView.addObject("trip", new TripDto());
        return modelAndView;
    }

    @PostMapping("/trip")
    public ModelAndView createTrip(@Valid @ModelAttribute("trip") TripDto tripDto, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        if (!bindingResult.hasErrors()) {
            reservationService.addTrip(tripDto);
            modelAndView.addObject("trip", new TripDto());

        }
        modelAndView = addTripsToModel(modelAndView);
        modelAndView = addStopsToModel(modelAndView);
        modelAndView = addBusesToModel(modelAndView);
        return modelAndView;
    }


    @GetMapping("/stop")
    public ModelAndView createStop() {
        ModelAndView modelAndView = addStopsToModel(new ModelAndView("stop"));
        StopDto stopDto = new StopDto();
        modelAndView.addObject("stop", stopDto);
        return modelAndView;
    }

    @PostMapping("/stop")
    public ModelAndView createStop(@Valid @ModelAttribute("stop") StopDto stop, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        if (!bindingResult.hasErrors()) {
            reservationService.addStop(stop);
            modelAndView.addObject("stop", new StopDto());
        }
        modelAndView = addStopsToModel(modelAndView);

        return modelAndView;
    }


    @GetMapping("/bus")
    public ModelAndView createBus() {
        ModelAndView modelAndView = addBusesToModel(new ModelAndView());
        BusDto busDto = new BusDto();
        modelAndView.addObject("bus", busDto);
        return modelAndView;

    }

    @PostMapping("/bus")
    public ModelAndView createBus(@Valid @ModelAttribute("bus") BusDto busDto, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        if (!bindingResult.hasErrors()) {
            reservationService.addBus(busDto);
            modelAndView.addObject("bus", new BusDto());
        }
        modelAndView = addBusesToModel(modelAndView);
        return modelAndView;
    }


    private ModelAndView addBusesToModel(ModelAndView modelAndView) {
        List<BusDto> busDtos = reservationService.getAllBus();
        modelAndView.addObject("buses", busDtos);
        return modelAndView;
    }


    private ModelAndView addStopsToModel(ModelAndView modelAndView) {
        List<StopDto> stops = reservationService.getAllStops();
        modelAndView.addObject("stops", stops);
        return modelAndView;
    }

    private ModelAndView addTripsToModel(ModelAndView modelAndView) {
        List<TripDto> trips = reservationService.getAllTrip();
        modelAndView.addObject("trips", trips);
        return modelAndView;
    }
}
