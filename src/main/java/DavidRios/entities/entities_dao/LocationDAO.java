package DavidRios.entities.entities_dao;

import DavidRios.entities.Location;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.transaction.TransactionalException;

public class LocationDAO {
    private final EntityManager em;

    public LocationDAO(EntityManager em) {
        this.em = em;
    }

    public void saveLocation (Location location) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(location);
            transaction.commit();
            System.out.println("Location salvata con successo!");
        } catch (TransactionalException terr) {
            System.err.println(terr.getMessage());
        }
    }

    public Location findById (long id) {
        return em.find(Location.class, id);
    }

    public void findAndDelete (long id) {
        Location found = findById(id);
        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            try {
                transaction.begin();
                em.remove(found);
                transaction.commit();
                System.out.println("Location rimossa.");
            } catch (Exception notFound) {
                System.err.println(notFound.getMessage());
            }
    } else {
            System.out.println("Location non trovata.");
        }
    }
}
