package DavidRios.entities.entities_dao;

import DavidRios.entities.Evento;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.transaction.TransactionalException;

public class GestioneEventiDAO {
    private final EntityManager em;

    public GestioneEventiDAO (EntityManager em) {
        this.em = em;
    }

    public void saveEvent (Evento ev) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(ev);
            transaction.commit();
            System.out.println("Evento salvato con successo!");
        } catch (TransactionalException terr) {
            System.err.println(terr.getMessage());
        }
    }

    public Evento findById (long id) {
        return em.find(Evento.class, id);
    }

    public void findAndDelete (long id) {
        Evento found = findById(id);
        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            try {
                transaction.begin();
                em.remove(found);
                transaction.commit();
                System.out.println("Evento rimosso.");
            } catch (Exception notFound) {
                System.err.println(notFound.getMessage());
            }
    } else {
            System.out.println("Evento non trovato.");
        }
    }
}
