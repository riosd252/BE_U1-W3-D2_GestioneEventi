package DavidRios;

import DavidRios.entities.Evento;
import DavidRios.entities.Location;
import DavidRios.entities.Partecipazione;
import DavidRios.entities.Persona;
import DavidRios.entities.entities_dao.GestioneEventiDAO;
import DavidRios.entities.entities_dao.LocationDAO;
import DavidRios.entities.entities_dao.PartecipazioneDAO;
import DavidRios.entities.entities_dao.PersonaDAO;
import DavidRios.entities.utilities.Sesso;
import DavidRios.entities.utilities.Stato;
import DavidRios.entities.utilities.TipoEvento;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        GestioneEventiDAO gedao = new GestioneEventiDAO(em);
        LocationDAO ldao = new LocationDAO(em);
        PartecipazioneDAO padao = new PartecipazioneDAO(em);
        PersonaDAO pedao = new PersonaDAO(em);

        Location teatroDellOpera = new Location("Teatro Dell'Opera", "Roma");
        ldao.saveLocation(teatroDellOpera);
        Evento exclusiveNight = new Evento("Exclusive Night at Opera Theater", LocalDate.now(), teatroDellOpera, "Classy event for classy people.", TipoEvento.PRIVATO, 100);
        gedao.saveEvent(exclusiveNight);
        Persona davidRios = new Persona("David", "Rios", "david@rios.com", LocalDate.of(1997,1,13), Sesso.M);
        pedao.savePersona(davidRios);
        Partecipazione exNiDaRi = new Partecipazione(davidRios, exclusiveNight, Stato.CONFERMATA);
        padao.savePartecipazione(exNiDaRi);

        em.close();
        emf.close();
    }
}
