import java.time.LocalDate;

public class AbonnementPremium extends Abonnement {
    private int creditsCoach;

    public AbonnementPremium(String reference, LocalDate dateDebut, int dureeMois, double prixMensuel, int creditsCoach) {
        super(reference, dateDebut, dureeMois, prixMensuel);
        this.creditsCoach = creditsCoach;
    }

    @Override
    public boolean permetAccesSauna() { return true; }

    @Override
    public int creditsCoachInclus() { return creditsCoach; }
}
