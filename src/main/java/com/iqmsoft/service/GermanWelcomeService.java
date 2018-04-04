package com.iqmsoft.service;

import org.springframework.stereotype.Service;

@Service
public class GermanWelcomeService implements WelcomeService {

    @Override
    public boolean accepts(Language language) {
        return Language.DE == language;
    }

    @Override
    public String casualGreeting() {
        return "Hallo!";
    }

    @Override
    public String goodMorning() {
        return "Guten Morgen";
    }
}
