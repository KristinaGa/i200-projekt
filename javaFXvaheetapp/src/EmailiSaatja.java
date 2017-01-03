import org.simplejavamail.email.Email;
import org.simplejavamail.mailer.Mailer;
import org.simplejavamail.mailer.config.TransportStrategy;
import javax.mail.Message;
import java.util.HashMap;

public class EmailiSaatja {


    public void saada(Integer user_id, String kuupaev, String soe, String kylm) throws Exception {
        // Kuna oma meiliserverit üles seada on päris keerukas, siis kasutame veebimajutuse oma
        //saame kasutaja andmed
        Veenaidud naidud = new Veenaidud();
        HashMap<String, String> andmed;
        andmed = naidud.saaKasutajaAndmed(user_id);

        String username = andmed.get("username");
        String name = andmed.get("name");
        String address = andmed.get("address");
        String saajaemail = andmed.get("saajaemail");

//        Lisame näitudele eelnevad nullid (6 kohta)
        String fsoe = ("000000" + soe).substring(soe.length());
        String fkylm = ("000000" + kylm).substring(kylm.length());

//        Paneme sõnumi kokku
        String message = String.format("Tere!\nAadressi %s veenäidud seisuga %s:\nSoe: %s\nKülm: %s\nTervitades,\n%s",
                address.trim(), kuupaev.trim(), fsoe, fkylm, name.trim());

//    SimpleMail'iga e-maili saatimine
        Email email = new Email();

        email.setFromAddress(name, username);
        email.addRecipient(saajaemail,saajaemail, Message.RecipientType.TO);
        email.setSubject(address + " veenäidud");
        email.setText(message);

        try {
//            meiliserveri ülesseadmine ja meili saatmine
            new Mailer("mail.veebimajutus.ee", 465, "veenaidud@bordeaux.ee", "EwGwPp7", TransportStrategy.SMTP_SSL).sendMail(email);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

}
