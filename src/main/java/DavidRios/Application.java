package DavidRios;

import DavidRios.entities.Evento;
import DavidRios.entities.GestioneEventiDAO;
import DavidRios.entities.utilities.TipoEvento;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        Evento nuovoEvento = new Evento("Regular Event", LocalDate.of(2024, 5, 10),"The event regular people.", TipoEvento.PUBBLICO, 250);

        GestioneEventiDAO gedao = new GestioneEventiDAO(em);

        //gedao.saveEvent(nuovoEvento);

        Evento found = gedao.findById(3);
        System.out.println(found);

        gedao.findAndDelete(4);
    }
}
