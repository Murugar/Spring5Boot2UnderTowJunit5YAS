package com.iqmsoft.service;



import org.springframework.stereotype.Service;

@Service
public class SpanishWelcomeService implements WelcomeService {

    @Override
    public boolean accepts(Language language) {
        return Language.ES == language;
    }

    @Override
    public String casualGreeting() {
        return "Hola!";
    }

    @Override
    public String goodMorning() {
        return "Habla Espanol";
    }
}

