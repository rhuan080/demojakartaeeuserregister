package net.rhuanrocha.democadastrousuario.event;

import net.rhuanrocha.democadastrousuario.email.EmailSender;
import net.rhuanrocha.democadastrousuario.entities.User;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.ObservesAsync;
import javax.inject.Inject;

@ApplicationScoped
public class UserObserver {

    @Inject
    private EmailSender emailSender;

    public void sendEmail(@ObservesAsync @Insert User user){
        emailSender.send(user);
    }


}
