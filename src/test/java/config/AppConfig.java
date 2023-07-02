package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config/app.properties"
})
public interface AppConfig extends Config {

    @Key("login")
    String getLogin();

    @Key("password")
    String getPassword();

    @Key("baseUrl")
    String getBaseUrl();

    @Key("basePath")
    String getBasePath();

}