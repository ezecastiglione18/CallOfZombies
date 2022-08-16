package Mail;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.cxf.jaxrs.client.WebClient;
import javax.ws.rs.core.Response;

public class VerificacionMail {

    public static boolean esMailValido(String mail) throws Exception {
        String consulta = "https://verifier.meetchopra.com/verify/" + mail + "?token=92928b756e623357b3bd80e8dc90deae15f179ef3e33514cb9c056095f5475006ae91274971e605811f391d2e35320bf";
        WebClient cliente = WebClient.create(consulta);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        Response response = cliente.header("Content-Type", "application/json").get();


        int status = response.getStatus();
        String responseBody = response.readEntity(String.class);
        MailVerify emailVerify;
        if (status == 200) {
            emailVerify = mapper.readValue(responseBody, MailVerify.class);
        } else {
            throw new Exception("Error de conexión con el servidor de la API");
        }
        return emailVerify.status;
    }
}
