package br.com.rodolfo.lista.service;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

/**
 * EmailService
 */
//A anotação 'Service' informa para o Spring que esta é uma classe de serviço e que precisa ser gerenciada
@Service
public class EmailService {

    public void enviarEmail(String nome, String emailDestinatario) {
        
        try {
        
            Email email = new SimpleEmail();

            email.setHostName("smtp.gmail.com");
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator("credencial@gmail.com", "senha"));
            email.setSSLOnConnect(true);

            
            email.setFrom("credencial@gmail.com");
            email.setSubject("Você foi convidado para participar da LISTA");
            email.setMsg("Olá ".concat(nome).concat(" você acaba de ser convidado pelo LISTA"));
            email.addTo(emailDestinatario);
            email.send();
        
    
        } catch (EmailException e) {
			
			e.printStackTrace();
		}
    }
    
}