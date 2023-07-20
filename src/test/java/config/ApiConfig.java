package config;

import org.aeonbits.owner.Config;

public interface ApiConfig extends Config {

    @Key("baseUrl")
    @DefaultValue("https://reqres.in")
    String baseUrl();

    @Key("basePath")
    @DefaultValue("/api")
    String basePath();

}
