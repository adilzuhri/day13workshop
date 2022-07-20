package sg.edu.nus.iss.day13workshop;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.fasterxml.jackson.databind.ObjectMapper;

import ch.qos.logback.classic.Logger;
import sg.edu.nus.iss.day13workshop.models.Contact;
import static org.hamcrest.CoreMatchers.*;

@SpringBootTest
public class FunctionTest {

    private Logger logger = Logger.getLogger(FunctionTest.class.getName());

    private Path workingDir;

    @Autowired
    private ObjectMapper objectmapper;

    @Test
    public void readContact() throws IOException {
        this.workingDir = Path.of("", "c:/data");
        Path file = this.workingDir.resolve("70dbb831");
        String content = Files.readString(file);
        assertThat(content, is(notNullValue()));
        
    }
    @Test
    public void saveContact() throws Exception {

    MultiValueMap<String, String> payload = new LinkedMultiValueMap<String, String>();
    payload.add("name", "Adil Zuhri");
    payload.add("email", "adilzuhri@gmail.com");
    payload.add("phone", "91054335");

    logger.log(Level.INFO, "" + objectMapper.writeValueAsString(payload));
    }

}
