package net.rhuanrocha.democadastrousuario.email;

import net.rhuanrocha.democadastrousuario.entities.User;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import java.util.logging.Logger;

@ApplicationScoped
public class EmailSender {

    private static Logger logger = Logger.getLogger(EmailSender.class.getName());
    private static String EMAIL_FROM = "mail.address";
    private static String EMAIL_USER = "mail.smtp.user";
    private static String EMAIL_PASSWORD = "mail.smtp.pass";
    private static String EMAIL_SUBJECT = "Demo Cadastro de Usuário";
    private static String EMAIL_MESSAGE = "Usuario %s cadastrado na Demo.";

    @Resource(lookup = "mail/DemoMailSession")
    private Session sessaoEmail;

    public void send(User user) {

        try {

            MimeMessage mensagem = new MimeMessage(sessaoEmail);
            mensagem.setFrom(System.getProperty(EMAIL_FROM));
            mensagem.setRecipients(Message.RecipientType.TO, user.getEmail());

            mensagem.setSubject(EMAIL_SUBJECT);
            mensagem.setText(String.format(EMAIL_MESSAGE,user.getName()));

            Transport.send(mensagem,
                    sessaoEmail.getProperty(EMAIL_USER),
                    sessaoEmail.getProperty(EMAIL_PASSWORD));
            logger.info("Email sent!");

        } catch (MessagingException e) {
            logger.severe(e.getMessage());
        }
    }

}
