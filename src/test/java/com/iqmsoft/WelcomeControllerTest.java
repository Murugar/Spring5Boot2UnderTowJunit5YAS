package com.iqmsoft;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;

import com.iqmsoft.service.WelcomeService;
import com.iqmsoft.web.WelcomeController;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringJUnitConfig(WelcomeControllerTest.Config.class)
@WebMvcTest
@DisplayName("When a greeting is requested")
class WelcomeControllerTest {

    @ComponentScan(basePackageClasses = WelcomeController.class)
    static class Config {
    }

    @Autowired
    MockMvc mockMvc;
    @MockBean
    WelcomeService greetingService;

    @Test
    @DisplayName("for a casual occasion a GreetingService should produce a result")
    void casual_greeting_should_invoke_greetingService() throws Exception {
        when(greetingService.accepts(any())).thenReturn(true);
        MockHttpServletResponse response = mockMvc.perform(get("/greeting/casual")).andReturn().getResponse();
        assertTrue(response.getStatus() == 200);
        verify(greetingService).casualGreeting();
    }

    @Test
    @DisplayName("for a morning greeting a GreetingService should produce a result")
    void morning_greeting_should_invoke_greetingService() throws Exception {
        when(greetingService.accepts(any())).thenReturn(true);
        MockHttpServletResponse response = mockMvc.perform(get("/greeting/morning")).andReturn().getResponse();
        assertTrue(response.getStatus() == 200);
        verify(greetingService).goodMorning();
    }

}
