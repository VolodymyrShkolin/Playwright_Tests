package com.utils;


import com.microsoft.playwright.*;
import org.testng.IConfigurable;

import javax.swing.plaf.PanelUI;

import static com.config.ConfigurationManager.config;

public enum BrowserFactory {

    CHROMIUM{
        @Override
        public Browser createInstance(final Playwright playwright){
            return playwright.chromium().launch(option());
        }

    },

    FIREFOX{
        @Override
        public Browser createInstance(final Playwright playwright){
            return playwright.firefox().launch(option());
        }
    };

    public BrowserType.LaunchOptions option(){
        return new BrowserType.LaunchOptions()
                .setHeadless(config().headless())
                .setSlowMo(config().slowMotion());
    }

    public abstract Browser createInstance(final Playwright playwright);
}
