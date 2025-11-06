import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TestRestoran {
    public static void main(String[] args) {
        // Kreiranje restorana
        Restoran restoran = new Restoran("Zlatni Lav", "Kneza Mihajla 15, Beograd", "107123456");

        System.out.println("=".repeat(60));
        System.out.println("           SISTEM ZA UPRAVLJANJE RESTORANOM");
        System.out.println("=".repeat(60));
        System.out.println(restoran);
        System.out.println();

        // Kreiranje zaposlenih
        System.out.println("DODAVANJE ZAPOSLENIH:");
        System.out.println("-".repeat(40));

        // Konobari
        Konobari konobar1 = new Konobari("K001", "Marko", "Petrović", 8.0, 40, 5);
        Konobari konobar2 = new Konobari("K002", "Ana", "Nikolić", 7.5, 38, 8);

        // Kuvari
        Kuvari kuvar1 = new Kuvari("KU001", "Stefan", "Jovanović", 12.0, 42);
        Kuvari kuvar2 = new Kuvari("KU002", "Milica", "Stojanović", 11.5, 40);

        // Menadžeri
        Menadzeri menadzer1 = new Menadzeri("M001", "Petar", "Milosavljević", 15.0, 45, 500.0);

        // Dodavanje u restoran
        restoran.dodajZaposlenog(konobar1);
        restoran.dodajZaposlenog(konobar2);
        restoran.dodajZaposlenog(kuvar1);
        restoran.dodajZaposlenog(kuvar2);
        restoran.dodajZaposlenog(menadzer1);

        System.out.println("\nUkupan broj zaposlenih: " + restoran.getZaposleni().size());
        System.out.println();

        // Test pretrage zaposlenog
        System.out.println("TEST PRETRAGE ZAPOSLENOG:");
        System.out.println("-".repeat(40));
        Zaposleni pronadjen = restoran.pronadjiZaposlenog("K001");
        if (pronadjen != null) {
            System.out.println("Pronađen zaposleni: " + pronadjen.getIme() + " " + pronadjen.getPrezime());
        }
        System.out.println();

        // Kreiranje smjena (opciono)
        System.out.println("KREIRANJE SMJENA:");
        System.out.println("-".repeat(40));

        Smjena jutarnja = new Smjena(
            LocalDate.of(2025, 11, 1),
            LocalTime.of(8, 0),
            LocalTime.of(16, 0),
            Smjena.TipSmjene.JUTARNJA
        );
        jutarnja.dodajZaposlenog(konobar1);
        jutarnja.dodajZaposlenog(kuvar1);

        Smjena popodnevna = new Smjena(
            LocalDate.of(2025, 11, 1),
            LocalTime.of(16, 0),
            LocalTime.of(23, 59),
            Smjena.TipSmjene.POPODNEVNA
        );
        popodnevna.dodajZaposlenog(konobar2);
        popodnevna.dodajZaposlenog(kuvar2);
        popodnevna.dodajZaposlenog(menadzer1);

        System.out.println(jutarnja);
        System.out.println("Trajanje: " + String.format("%.1f", jutarnja.izracunajTrajanjeSmjeneUSatima()) + " sati");
        System.out.println();
        System.out.println(popodnevna);
        System.out.println("Trajanje: " + String.format("%.1f", popodnevna.izracunajTrajanjeSmjeneUSatima()) + " sati");
        System.out.println();

        // Generisanje obračuna plata
        System.out.println("GENERISANJE OBRAČUNA PLATA:");
        restoran.generirajObracunPlata(11, 2025);
        System.out.println();

        // Kreiranje obračuna plata za čuvanje istorije
        System.out.println("KREIRANJE OBRAČUNA ZA ISTORIJU:");
        System.out.println("-".repeat(50));
        List<ObracunPlate> obracuni = new ArrayList<>();

        for (Zaposleni z : restoran.getZaposleni()) {
            ObracunPlate obracun = ObracunPlate.kreirajObracun(11, 2025, z);
            obracuni.add(obracun);
            System.out.println(obracun);
        }
        System.out.println();

        // Statistike
        System.out.println("STATISTIKE RESTORANA:");
        System.out.println("-".repeat(40));
        double ukupanTrosak = restoran.izracunajUkupanTrosakPlata();
        System.out.println("Ukupan trošak plata za mjesec: " + String.format("%.2f", ukupanTrosak) + " EUR");
        System.out.println("Prosječna plata po zaposlenom: " +
                          String.format("%.2f", ukupanTrosak / restoran.getZaposleni().size()) + " EUR");

        // Analiza po tipovima zaposlenih
        int brojKonobara = 0, brojKuvara = 0, brojMenadzera = 0;
        double ukupnoKonobari = 0, ukupnoKuvari = 0, ukupnoMenadzeri = 0;

        for (Zaposleni z : restoran.getZaposleni()) {
            if (z instanceof Konobari) {
                brojKonobara++;
                ukupnoKonobari += z.obracunajPlatu();
            } else if (z instanceof Kuvari) {
                brojKuvara++;
                ukupnoKuvari += z.obracunajPlatu();
            } else if (z instanceof Menadzeri) {
                brojMenadzera++;
                ukupnoMenadzeri += z.obracunajPlatu();
            }
        }

        System.out.println();
        System.out.println("ANALIZA PO TIPOVIMA:");
        if (brojKonobara > 0) {
            System.out.println("Konobari (" + brojKonobara + "): " +
                              String.format("%.2f", ukupnoKonobari) + " EUR (prosjek: " +
                              String.format("%.2f", ukupnoKonobari/brojKonobara) + " EUR)");
        }
        if (brojKuvara > 0) {
            System.out.println("Kuvari (" + brojKuvara + "): " +
                              String.format("%.2f", ukupnoKuvari) + " EUR (prosjek: " +
                              String.format("%.2f", ukupnoKuvari/brojKuvara) + " EUR)");
        }
        if (brojMenadzera > 0) {
            System.out.println("Menadžeri (" + brojMenadzera + "): " +
                              String.format("%.2f", ukupnoMenadzeri) + " EUR (prosjek: " +
                              String.format("%.2f", ukupnoMenadzeri/brojMenadzera) + " EUR)");
        }

        System.out.println();
        System.out.println("=".repeat(60));
        System.out.println("           ZAVRŠETAK TESTIRANJA SISTEMA");
        System.out.println("=".repeat(60));
    }
}
