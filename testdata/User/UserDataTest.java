package User;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class UserDataTest {
    public static UserDataTest getFile(String fileName) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(new File(fileName), UserDataTest.class);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @JsonProperty("firstname")
    String firstname;

    @JsonProperty("lastname")
    String lastname;

    @JsonProperty("email")
    String email;

    @JsonProperty("password")
    String password;

    @JsonProperty("company")
    String company;

    @JsonProperty("date")
    String date;

    @JsonProperty("month")
    String month;

    @JsonProperty("year")
    String year;

    @JsonProperty("gender")
    String gender;

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getCompany() {
        return company;
    }

    public String getDate() {
        return date;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public String getGender() {
        return gender;
    }
}
