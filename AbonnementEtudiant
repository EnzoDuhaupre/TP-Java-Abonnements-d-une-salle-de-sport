import java.time.LocalDate;

public class AbonnementEtudiant extends Abonnement {
    private double reductionPourcent;

    public AbonnementEtudiant(String reference, LocalDate dateDebut, int dureeMois, double prixMensuel, double reductionPourcent) {
        super(reference, dateDebut, dureeMois, prixMensuel);
        this.reductionPourcent = reductionPourcent;
    }

    @Override
    public double coutTotal() {
        return super.coutTotal() * (1 - reductionPourcent / 100);
    }

    @Override
    public boolean permetAccesSauna() { return false; }

    @Override
    public int creditsCoachInclus() { return 0; }
}
