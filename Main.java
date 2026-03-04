import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Créer les prestations
        Prestation sauna     = new Prestation("SAUNA",     "Accès sauna",        5.0);
        Prestation coach     = new Prestation("COACH",     "Séance avec coach",  25.0);
        Prestation serviette = new Prestation("SERVIETTE", "Location serviette", 2.0);

        System.out.println("=== PRESTATIONS ===");
        System.out.println(sauna);
        System.out.println(coach);
        System.out.println(serviette);

        // Créer les séances
        Seance seance1 = new Seance(1, "BodyPump",   LocalDateTime.now().plusDays(1),  20);
        Seance seance2 = new Seance(2, "Yoga",       LocalDateTime.now().plusDays(3),  15);
        Seance seance3 = new Seance(3, "CrossFit",   LocalDateTime.now().minusDays(1), 10); // passée

        System.out.println("\n=== SÉANCES ===");
        System.out.println(seance1);
        System.out.println(seance2);
        System.out.println(seance3);

        // Créer les abonnements
        Abonnement basic   = new AbonnementBasic("BASIC-001",   LocalDate.now(), 3, 19.99);
        Abonnement premium = new AbonnementPremium("PREM-001",  LocalDate.now(), 6, 39.99, 4);

        // Créer les adhérents
        Adherent alice = new Adherent(1, "Alice",  basic);
        Adherent bob   = new Adherent(2, "Bob",    premium);

        System.out.println("\n=== ADHÉRENTS ===");
        System.out.println(alice);
        System.out.println(bob);

        // Créer des réservations et ajouter des prestations
        alice.reserver(seance1);
        alice.reserver(seance3); // séance passée

        // Récupérer les réservations d'alice
        alice.getReservations().get(0).ajouterPrestation(serviette);
        alice.getReservations().get(0).ajouterPrestation(coach);

        bob.reserver(seance1);
        bob.reserver(seance2);
        bob.getReservations().get(0).ajouterPrestation(sauna);
        bob.getReservations().get(0).ajouterPrestation(coach);
        bob.getReservations().get(1).ajouterPrestation(sauna);

        // Annuler une réservation de bob
        bob.getReservations().get(1).annuler();


        // Créer la salle de sport
        SalleDeSport salle = new SalleDeSport();
        salle.ajouterAdherent(alice);
        salle.ajouterAdherent(bob);
        salle.ajouterSeance(seance1);
        salle.ajouterSeance(seance2);
        salle.ajouterSeance(seance3);

        // Affichages
        System.out.println("\n=== RÉSERVATIONS FUTURES D'ALICE ===");
        List<Reservation> futuresAlice = alice.reservationsFutures();
        if (futuresAlice.isEmpty()) {
            System.out.println("Aucune réservation future.");
        } else {
            for (Reservation r : futuresAlice) System.out.println(r);
        }

        System.out.println("\n=== RÉSERVATIONS DE BOB ===");
        for (Reservation r : bob.getReservations()) System.out.println(r);

        System.out.println("\n=== ADHÉRENTS AVEC ACCÈS SAUNA ===");
        List<Adherent> avecSauna = salle.adherentsAvecSauna();
        for (Adherent a : avecSauna) System.out.println("→ " + a.getNom());

        System.out.println("\n=== DÉPENSES PRESTATIONS ===");
        System.out.println("Alice : " + alice.depensesTotales() + "€");
        System.out.println("Bob   : " + bob.depensesTotales() + "€");
        System.out.println("Chiffre d'affaires total : " + salle.chiffreAffairesPrestations() + "€");


        // Test exception adhérent introuvable

        System.out.println("\n=== TEST EXCEPTION ===");
        try {
            salle.trouverAdherent(99);
        } catch (RuntimeException e) {
            System.out.println("Exception attrapée : " + e.getMessage());
        }
    }
}
