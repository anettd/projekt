package projekt;

import java.util.ArrayList;
import java.util.Scanner;

public class Pojistovna {

    Scanner scanner;
    ArrayList<Pojisteny> pojisteni;
    boolean pokracovat;
    int vstup;

    public Pojistovna() {
        scanner = new Scanner(System.in);
        pojisteni = new ArrayList<Pojisteny>();
        pokracovat = true;
    }

    public void run() {
        this.vypisStart();
        this.vypisHlavicku();
        vstup = this.vratVstup();

        while (pokracovat) {
            switch (vstup) {
                case 1:
                    pojisteni.add(pridejPojisteneho());
                    System.out.println("Data byla uložena. ");
                    vstup = 0;
                    break;

                case 2:
                    vypisPojistene(pojisteni);
                    vstup = 0;
                    break;

                case 3:
                    Pojisteny vysledek = vyhledejPojisteneho(vyhledej());
                    if (vysledek == null) {
                        System.out.println("Pojištěný není v databázi. ");
                    } else {
                        System.out.println(vysledek);
                    }
                    vstup = 0;
                    break;

                case 4:
                    pokracovat = false;
                    break;

                default:
                    vypisHlavicku();
                    vstup = this.vratVstup();
            }
        }
    }

    private static Pojisteny pridejPojisteneho() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Zadejte jméno pojištěného: ");
        String jmeno = scanner.nextLine();

        System.out.println("Zadejte příjmení: ");
        String prijmeni = scanner.nextLine();

        System.out.println("Zadejte telefonní cislo: ");
        int cislo = Integer.parseInt(scanner.nextLine());

        System.out.println("Zadejte vek: ");
        int vek = Integer.parseInt(scanner.nextLine());

        Pojisteny pojisteny = new Pojisteny(jmeno, prijmeni, cislo, vek);

        return pojisteny;
    }

    private static void vypisPojistene(ArrayList<Pojisteny> pojisteni) {
        for (Pojisteny pojisteny : pojisteni) {
            System.out.println(pojisteny);
        }
    }

    private static void vypisStart() {
        System.out.println("-----------");
        System.out.println("Evidence pojištěných");
        System.out.println("-----------");
        System.out.println();
    }

    private static void vypisHlavicku() {
        System.out.println("Vyberte si akci: ");
        System.out.println("1 - Přidat nového pojištěného");
        System.out.println("2 - Vypsat všechny pojištěné");
        System.out.println("3 - Vyhledat pojištěného");
        System.out.println("4 - Konec");
    }

    private int vratVstup() {
        int vstupForParse = 0;
        try {
            vstupForParse = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException ex) {
            System.out.println("Zadej vstup ve spravnym formatu (1 - 4).");
            System.out.println();
            System.out.println();
        }

        return vstupForParse;
    }

    private Pojisteny vyhledej() {
        System.out.println("Zadejte jméno pojištěného: ");
        String jmeno = scanner.nextLine();

        System.out.println("Zadejte příjmení pojištěného: ");
        String prijmeni = scanner.nextLine();

        Pojisteny pojisteny = new Pojisteny(jmeno, prijmeni);
        return pojisteny;
    }

    private Pojisteny vyhledejPojisteneho(Pojisteny pojistenyVstup) {
        for (Pojisteny pojisteny : pojisteni) {
            if (pojisteny.equals(pojistenyVstup)) {
                return pojisteny;
            }
        }
        return null;
    }

}
