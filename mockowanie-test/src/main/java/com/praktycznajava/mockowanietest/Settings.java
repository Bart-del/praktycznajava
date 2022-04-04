package com.praktycznajava.mockowanietest;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Component
public final class Settings {

    private final List<String> settingsList;

    public Settings()
    {
        this.settingsList = new ArrayList<>();
        setSettingsList();
    }

    public List<String> getSettingsList() {
        return settingsList;
    }

    private void setSettingsList()
    {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("settings.txt");
             InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
        BufferedReader bf = new BufferedReader(isr))
        {
            String line;
            while ((line = bf.readLine()) != null) {
                settingsList.add(line);
            }
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}

