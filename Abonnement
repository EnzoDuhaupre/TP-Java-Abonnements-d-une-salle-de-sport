import java.time.LocalDate;

public abstract class Abonnement {
    private String reference;
    private LocalDate dateDebut;
    private int dureeMois;
    private double prixMensuel;

    // Description de l'abonement

    public Abonnement(String reference, LocalDate dateDebut, int dureeMois, double prixMensuel) {
        this.reference = reference;
        this.dateDebut = dateDebut;
        this.dureeMois = dureeMois;
        this.prixMensuel = prixMensuel;
    }

    public LocalDate dateFin() {
        return dateDebut.plusMonths(dureeMois);
    }

    public double coutTotal() {
        return prixMensuel * dureeMois;
    }

    public abstract boolean permetAccesSauna();
    public abstract int creditsCoachInclus();

    public String getReference() { return reference; }
    public LocalDate getDateDebut() { return dateDebut; }
    public int getDureeMois() { return dureeMois; }
    public double getPrixMensuel() { return prixMensuel; }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " [" + reference + "]"
                + " du " + dateDebut + " au " + dateFin()
                + " | " + prixMensuel + "€/mois → total : " + coutTotal() + "€"
                + " | Sauna : " + permetAccesSauna()
                + " | Crédits coach : " + creditsCoachInclus();
    }
}
