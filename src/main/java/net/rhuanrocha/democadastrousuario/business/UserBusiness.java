package net.rhuanrocha.democadastrousuario.business;

import net.rhuanrocha.democadastrousuario.entities.User;
import net.rhuanrocha.democadastrousuario.event.Insert;


import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

@Stateless
public class UserBusiness {

    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    @Insert
    private Event<User> userEvent;

    public void save (User user){
        entityManager.persist(user);
        userEvent.fireAsync(user);
    }

    public List<User> findAll(){
        return entityManager
                .createNamedQuery(User.QUERY_FIND_ALL,User.class)
                .getResultList();
    }

    public Optional<User> findById(Long id){
        TypedQuery<User> query = entityManager.createNamedQuery(User.QUERY_BY_ID,User.class);
        query.setParameter("id", id);
        return query.getResultStream().findFirst();
    }
}
