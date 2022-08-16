package MailTest;

import Mail.EnviarMail;
import Mail.VerificacionMail;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class MailTest {

    @Test
    public void comprobarMailValido() throws Exception {
        boolean esMailValido = VerificacionMail.esMailValido("ldelpieri@frba.utn.edu.ar");
        Assertions.assertEquals(esMailValido, true);
    }

    @Test
    public void comprobarMailInvalido() throws Exception {
        boolean esMailValido = VerificacionMail.esMailValido("ldelpieri");
        Assertions.assertEquals(esMailValido, false);
    }

    @Test
    public void enviarMailConPuntaje() {
        EnviarMail.enviarPuntaje("luca.delpieri@gmail.com", 92);
    }
}
