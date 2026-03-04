import java.util.ArrayList;
import java.util.List;

public class SalleDeSport {
    private List<Adherent> adherents;
    private List<Seance> seances;

    public SalleDeSport() {
        this.adherents = new ArrayList<>();
        this.seances = new ArrayList<>();
    }

    public void ajouterAdherent(Adherent a) {
        adherents.add(a);
    }

    public void ajouterSeance(Seance s) {
        seances.add(s);
    }

    public List<Seance> seancesDisponibles() {
        return new ArrayList<>(seances);
    }

    public List<Adherent> adherentsAvecSauna() {
        List<Adherent> result = new ArrayList<>();
        for (Adherent a : adherents) {
            if (a.getAbonnement().permetAccesSauna()) {
                result.add(a);
            }
        }
        return result;
    }

    public double chiffreAffairesPrestations() {
        double total = 0;
        for (Adherent a : adherents) {
            total += a.depensesTotales();
        }
        return total;
    }

    public Adherent trouverAdherent(int id) {
        for (Adherent a : adherents) {
            if (a.getId() == id) return a;
        }
        throw new RuntimeException("Adhérent introuvable avec l'id : " + id);
    }
}
