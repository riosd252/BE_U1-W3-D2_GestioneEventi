package DavidRios.entities.entities_dao;

import DavidRios.entities.Persona;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.transaction.TransactionalException;

public class PersonaDAO {
    private final EntityManager em;

    public PersonaDAO(EntityManager em) {
        this.em = em;
    }

    public void savePersona (Persona persona) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(persona);
            transaction.commit();
            System.out.println("Persona salvata nel db!");
        } catch (TransactionalException terr) {
            System.err.println(terr.getMessage());
        }
    }

    public Persona findById (long id) {
        return em.find(Persona.class, id);
    }

    public void findAndDelete (long id) {
        Persona found = findById(id);
        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            try {
                transaction.begin();
                em.remove(found);
                transaction.commit();
                System.out.println("Persona rimossa.");
            } catch (Exception notFound) {
                System.err.println(notFound.getMessage());
            }
    } else {
            System.out.println("Persona non trovata.");
        }
    }
}
