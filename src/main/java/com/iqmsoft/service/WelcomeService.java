package com.iqmsoft.service;

public interface WelcomeService {
    boolean accepts(Language language);
    String casualGreeting();
    String goodMorning();
}
