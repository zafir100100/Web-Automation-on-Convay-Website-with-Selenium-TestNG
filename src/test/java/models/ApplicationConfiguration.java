package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicationConfiguration {
    @JsonProperty("browser")
    private String browser;

    @JsonProperty("chromeDriverLocation")
    private String chromeDriverLocation;

    @JsonProperty("firefoxDriverLocation")
    private String firefoxDriverLocation;

    @JsonProperty("email")
    private String adminEmail;

    @JsonProperty("password")
    private String adminPassword;
}