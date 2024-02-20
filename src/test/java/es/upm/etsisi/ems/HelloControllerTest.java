package es.upm.etsisi.ems;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(classes = MyWebApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerTest {

    @Autowired
    private TestRestTemplate template;

    @Test
    public void holaOk() throws Exception {
        ResponseEntity<String> response = template.getForEntity("/hola", String.class);
        
        // check that the body contains a <p> tag with the text "¡Hola Mundo!"
        assertThat(response.getBody()).contains("<p>¡Hola Mundo!</p>");
    }

    @Test
    public void holaUser() throws Exception {
        ResponseEntity<String> response = template.getForEntity("/hola?nombre=EMSAlumno", String.class);

        // check that the body contains a <p> tag with the text "¡Hola EMSAlumno!"
        assertThat(response.getBody()).contains("<p>¡Hola EMSAlumno!</p>");
    }
}
