import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        Controller controller = new Controller(database);

        Scanner scanner = new Scanner(System.in);

        boolean running = true; // Indikator for om programmet kører

        while (running) {
            System.out.println("Menu:");
            System.out.println("1. Tilføj Superhelt");
            System.out.println("2. Vis alle Superhelte");
            System.out.println("3. Søg efter Superhelt");
            System.out.println("4. Afslut");

            int valg = scanner.nextInt();
            scanner.nextLine(); // Læs en linje for at håndtere Enter-tasten

            switch (valg) {
                case 1:
                    System.out.print("Navn: ");
                    String navn = scanner.nextLine();
                    System.out.print("Rigtigt navn: ");
                    String rigtigtNavn = scanner.nextLine();
                    System.out.print("Er menneske (Ja/Nej): ");
                    boolean erMenneske = scanner.nextLine().equalsIgnoreCase("Ja");
                    System.out.print("Skabelsesår: ");
                    int skabelsesaar = scanner.nextInt();
                    scanner.nextLine(); // Læs en linje for at håndtere Enter-tasten
                    System.out.print("Styrke: ");
                    String styrke = scanner.nextLine();
                    controller.addSuperhero(navn, rigtigtNavn, erMenneske, skabelsesaar, styrke);
                    System.out.println("Superhelt tilføjet!");
                    break;

                case 2:
                    ArrayList<Superhero> superheroeList = controller.getAllSuperheroes();
                    if (superheroeList.isEmpty()) {
                        System.out.println("Der er ingen superhelte i databasen.");
                    } else {
                        System.out.println("Liste over superhelte:");
                        for (Superhero superhero : superheroeList) {
                            System.out.println("Navn: " + superhero.getName());
                            System.out.println("Rigtige navn: " + superhero.getRealName());
                            System.out.println("Er menneske: " + (superhero.isHuman() ? "Ja" : "Nej"));
                            System.out.println("Skabelsesår: " + superhero.getCreationYear());
                            System.out.println("Styrke: " + superhero.getStrength()); // Vis styrken
                            System.out.println();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Indtast navnet på superhelten: ");
                    String searchName = scanner.nextLine();
                    Superhero foundSuperhero = controller.searchSuperheroByName(searchName);

                    if (foundSuperhero != null) {
                        System.out.println("Superhelt fundet!:");
                        System.out.println("Navn: " + foundSuperhero.getName());
                        System.out.println("Rigtigt navn: " + foundSuperhero.getRealName());
                        System.out.println("Er menneske: " + (foundSuperhero.isHuman() ? "Ja" : "Nej"));
                        System.out.println("Skabelsesår: " + foundSuperhero.getCreationYear());
                        System.out.println("Styrke: " + foundSuperhero.getStrength());
                    } else {
                        System.out.println("Ingen matchende superhelte blev fundet.");
                    }
                    break;

                case 4:
                    System.out.println("Farvel!");
                    running = false; // Stop løkken og afslut programmet
                    break;
                default:
                    System.out.println("Ugyldigt valg. Prøv igen.");
            }
        }
        scanner.close(); // Luk scanneren ved afslutning
    }
}
