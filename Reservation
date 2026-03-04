import java.util.ArrayList;
import java.util.List;

public class Reservation {
    private Seance seance;
    private List<Prestation> prestations;
    private StatutReservation statut;

    public Reservation(Seance seance) {
        this.seance = seance;
        this.prestations = new ArrayList<>();
        this.statut = StatutReservation.CONFIRMEE;
    }

    public void ajouterPrestation(Prestation p) {
        prestations.add(p);
    }

    public double coutPrestations() {
        double total = 0;
        for (Prestation p : prestations) {
            total += p.getPrix();
        }
        return total;
    }

    public void annuler() {
        this.statut = StatutReservation.ANNULEE;
    }

    public Seance getSeance() { return seance; }
    public StatutReservation getStatut() { return statut; }
    public List<Prestation> getPrestations() { return prestations; }

    @Override
    public String toString() {
        return "Réservation [" + statut + "] → " + seance.getNom()
                + " | Prestations : " + prestations
                + " | Coût prestations : " + coutPrestations() + "€";
    }
}
