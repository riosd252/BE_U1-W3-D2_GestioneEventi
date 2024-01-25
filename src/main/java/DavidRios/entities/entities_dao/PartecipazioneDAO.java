package DavidRios.entities.entities_dao;

import DavidRios.entities.Partecipazione;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.transaction.TransactionalException;

public class PartecipazioneDAO {
    private final EntityManager em;

    public PartecipazioneDAO(EntityManager em) {
        this.em = em;
    }

    public void savePartecipazione (Partecipazione partecipazione) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(partecipazione);
            transaction.commit();
            System.out.println("Partecipazione aggiunta!");
        } catch (TransactionalException terr) {
            System.err.println(terr.getMessage());
        }
    }

    public Partecipazione findById (long id) {
        return em.find(Partecipazione.class, id);
    }

    public void findAndDelete (long id) {
        Partecipazione found = findById(id);
        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            try {
                transaction.begin();
                em.remove(found);
                transaction.commit();
                System.out.println("Partecipazione rimossa.");
            } catch (Exception notFound) {
                System.err.println(notFound.getMessage());
            }
    } else {
            System.out.println("Partecipazione non trovata.");
        }
    }
}
