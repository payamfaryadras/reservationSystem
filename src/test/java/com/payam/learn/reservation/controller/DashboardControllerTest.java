package com.payam.learn.reservation.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.payam.learn.reservation.dto.model.TripDto;
import com.payam.learn.reservation.model.Stop;
import com.payam.learn.reservation.services.ReservationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;


import java.util.ArrayList;
import java.util.List;


import static org.hamcrest.Matchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class DashboardControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReservationService reservationService;

//    @Test
//    public void get_all_trip() throws Exception {
//        //given
//        List<TripDto> trips = new ArrayList<>();
//        trips.add(new TripDto());
//        trips.add(new TripDto());
//        //when
//        when(reservationService.getAllTrips()).thenReturn(trips);
//        //then
//        mockMvc.perform(get("/trips")
//                .contentType(MediaType.APPLICATION_JSON)).andExpect(jsonPath("$", hasSize(2))).andDo(print());
//    }

//    @Test
//    public void postTrips_shouldReturnSaved_trip() throws Exception {
//
//        TripDto tripDto = new TripDto();
//        when(reservationService.addTrip(any(TripDto.class))).thenReturn(tripDto);
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        String tripJson = objectMapper.writeValueAsString(tripDto);
//
//        ResultActions resultActions = mockMvc.perform(post("/trip")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(tripJson));
//        resultActions.andExpect(status().isCreated())
//                .andExpect(jsonPath("$.id").value(tripDto.getId().toString()));
//
//    }
//    @Test
//    public void postTrip_sourceStop_Should_not_null() throws Exception {
//        TripDto tripDto = new TripDto();
//        Stop source = new Stop("Stop A","this is a Test");
//        Stop destination = new Stop("Stop B","this is a Test");
//        tripDto.setSourceStop(source.getId());
//        when(reservationService.addTrip(any(TripDto.class))).thenReturn(tripDto);
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        String tripJson = objectMapper.writeValueAsString(tripDto);
//
//        ResultActions resultActions = mockMvc.perform(post("/trip")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(tripJson))
//                .andExpect(jsonPath("$.sourceStop").value(tripDto.getSourceStop()));
//
//    }
//
//    @Test
//    public void get_trip_must_be_return_trip() throws Exception {
//
//        mockMvc.perform(get("/trip")).andExpect(status().isOk());
//
//
//    }


    @Test
    public void get_stop_should_not_null_stop() throws Exception {
        mockMvc.perform(get("/stop"))
                .andExpect(model().attribute("stop",notNullValue()));
    }

    @Test
    public void get_stop_shuold_render_stop_view() throws Exception {

        mockMvc.perform(get("/stop"))
                .andExpect(view().name("stop"));
    }


    @Test
    public void post_stop_raise_error_when_name_not_valid() throws Exception {

        mockMvc.perform(post("/stop").param("name",""))
                .andExpect(model().attributeHasFieldErrors("stop","name"));
    }

    @Test
    public void post_stop_raise_error_when_description_not_valid() throws Exception {
        mockMvc.perform(post("/stop").param("description",""))
                .andExpect(model().attributeHasFieldErrors("stop","description"));

    }
}
