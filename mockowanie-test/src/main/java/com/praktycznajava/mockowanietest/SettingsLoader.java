package com.praktycznajava.mockowanietest;

import org.springframework.stereotype.Component;

@Component
public class SettingsLoader {

    private final Settings settings;

    public SettingsLoader(Settings settings)
    {
        this.settings = settings;
    }

    public String loadSettings()
    {
        StringBuilder result = new StringBuilder();

        for (String s : settings.getSettingsList())
        {
            result.append("SETTING LOADED: ").append(s);
        }
        return result.toString();
    }
}
