package az.charming.teachermanagement.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UrlConfiguration {

    @Value("${students.url}")
    private String studentsUrl;

    public String getStudentsUrl() {
        return studentsUrl;
    }
}
