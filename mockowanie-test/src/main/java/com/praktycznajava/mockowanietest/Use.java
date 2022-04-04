package com.praktycznajava.mockowanietest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Use {

    private final SettingsLoader settingsLoader;

    @Autowired
    public Use(SettingsLoader settingsLoader)
    {
        this.settingsLoader = settingsLoader;
        use();
    }

    public void use()
    {
        String settings = settingsLoader.loadSettings();
        System.out.println(settings);
    }
}

