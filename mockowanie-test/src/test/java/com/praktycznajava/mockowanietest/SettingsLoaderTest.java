package com.praktycznajava.mockowanietest;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class SettingsLoaderTest {


    private Settings getSettingsMock(){
        Settings settings = mock(Settings.class);
        List<String> stringList = List.of("praktycznajava");
        when(settings.getSettingsList()).thenReturn(stringList);
        return settings;
    }

    @Test
    public void settingsLoaderTest1()
    {
        Settings settings = getSettingsMock();
        SettingsLoader settingsLoader = new SettingsLoader(settings);
        String settingsString = settingsLoader.loadSettings();
        assertEquals("SETTING LOADED: praktycznajava", settingsString);
    }
}
