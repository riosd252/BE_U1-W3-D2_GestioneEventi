package DavidRios.entities;

import DavidRios.entities.utilities.Stato;

import javax.persistence.*;

@Entity
@Table(name = "partecipazioni")
public class Partecipazione {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_persona")
    private Persona persona;
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_evento")
    private Evento evento;
    @Enumerated(EnumType.STRING)
    private Stato stato;

    // CONSTRUCTORS
    public Partecipazione () {};

    public Partecipazione(Persona persona, Evento evento, Stato stato) {
        this.persona = persona;
        this.evento = evento;
        this.stato = stato;
    }

    // OVERRIDES

    @Override
    public String toString() {
        return "Partecipazione{" +
                "id=" + id +
                ", persone=" + persona +
                ", evento=" + evento +
                ", stato=" + stato +
                '}';
    }


    // GETTERS


    public long getId() {
        return id;
    }

    public Persona getPersona() {
        return persona;
    }

    public Evento getEvento() {
        return evento;
    }

    public Stato getStato() {
        return stato;
    }

    // SETTERS


    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public void setStato(Stato stato) {
        this.stato = stato;
    }
}
