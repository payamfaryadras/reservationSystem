package com.payam.learn.reservation.controller;

import com.payam.learn.reservation.ReservationSystemApplication;
import com.payam.learn.reservation.model.Trip;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.servlet.ModelAndView;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;




@WebMvcTest(controllers = {DashboardController.class},secure = false)
public class DashboardControllerTest {
    @Autowired
    private MockMvc mockMvc;

    //@WithMockUser(roles = "USER")
    @Test
    public void get_trip_model() throws Exception {
        mockMvc.perform(get("/trip"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"))
                .andExpect(view().name("trip"))
                .andExpect(MockMvcResultMatchers.view().name("trip"))
                .andExpect(model().attribute("trip",hasProperty("fare",is(0.0))))
                .andDo(print());

    }

}