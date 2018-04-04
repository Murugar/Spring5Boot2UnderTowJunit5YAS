package com.iqmsoft.web;

import org.springframework.web.bind.annotation.*;

import com.iqmsoft.service.WelcomeService;
import com.iqmsoft.service.Language;

import java.util.List;

@RestController
@RequestMapping("/greeting")
public class WelcomeController {

    private final List<WelcomeService> greetingServices;

    public WelcomeController(final List<WelcomeService> greetingServices) {
        this.greetingServices = greetingServices;
    }

    @GetMapping("/casual")
    String casualGreeting(@RequestParam(value = "lang", required = false) final String language) {
        return getGreetingService(language).casualGreeting();
    }

    @GetMapping("/morning")
    String morningGreeting(@RequestParam(value = "lang", required = false) final String language) {
        return getGreetingService(language).goodMorning();
    }

    private WelcomeService getGreetingService(final String language) {
        return greetingServices.stream()
                .filter(service -> service.accepts(Language.fromKey(language)))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }


}
