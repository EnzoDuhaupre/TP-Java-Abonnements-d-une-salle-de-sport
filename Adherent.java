import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Adherent {
    private int id;
    private String nom;
    private Abonnement abonnement;
    private List<Reservation> reservations;

    public Adherent(int id, String nom, Abonnement abonnement) {
        this.id = id;
        this.nom = nom;
        this.abonnement = abonnement;
        this.reservations = new ArrayList<>();
    }

    public void reserver(Seance s) {
        Reservation r = new Reservation(s);
        reservations.add(r);
    }

    public double depensesTotales() {
        double total = 0;
        for (Reservation r : reservations) {
            if (r.getStatut() == StatutReservation.CONFIRMEE) {
                total += r.coutPrestations();
            }
        }
        return total;
    }

    public List<Reservation> reservationsFutures() {
        List<Reservation> futures = new ArrayList<>();
        LocalDateTime maintenant = LocalDateTime.now();
        for (Reservation r : reservations) {
            if (r.getSeance().getDateHeure().isAfter(maintenant)
                    && r.getStatut() == StatutReservation.CONFIRMEE) {
                futures.add(r);
            }
        }
        return futures;
    }

    public int getId() { return id; }
    public String getNom() { return nom; }
    public Abonnement getAbonnement() { return abonnement; }
    public List<Reservation> getReservations() { return reservations; }

    @Override
    public String toString() {
        return "Adhérent #" + id + " - " + nom + "\n  Abonnement : " + abonnement;
    }
}
