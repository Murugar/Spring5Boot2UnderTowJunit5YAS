package com.iqmsoft.service;

import org.springframework.stereotype.Service;

@Service
public class EnglishWelcomeService implements WelcomeService {

    @Override
    public boolean accepts(Language language) {
        return Language.EN == language;
    }

    @Override
    public String casualGreeting() {
        return "Hi!";
    }

    @Override
    public String goodMorning() {
        return "Good Morning";
    }
}
