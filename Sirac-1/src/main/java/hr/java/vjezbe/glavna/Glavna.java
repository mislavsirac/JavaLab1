package hr.java.vjezbe.glavna;

import hr.java.vjezbe.entitet.Ispit;
import hr.java.vjezbe.entitet.Predmet;
import hr.java.vjezbe.entitet.Profesor;
import hr.java.vjezbe.entitet.Student;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Glavna {

    private static final int BROJ_PROFESORA = 2;
    private static final int BROJ_PREDMETA = 3;
    private static final int BROJ_STUDENATA = 3;
    private static final int BROJ_ISPITA = 1;

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        Profesor[] profesori = new Profesor[BROJ_PROFESORA];
        Predmet[] predmeti = new Predmet[BROJ_PREDMETA];
        Student[] studenti = new Student[BROJ_STUDENATA];
        Ispit[] ispiti = new Ispit[BROJ_ISPITA];

        for(int i=0; i<BROJ_PROFESORA;i++){
            System.out.println("Unesite " + (i+1) + ". profesora: ");
            System.out.println("Unesite šifru profesora: ");
            String sifra = sc.nextLine();
            System.out.println("Unesite ime profesora: ");
            String ime = sc.nextLine();
            System.out.println("Unesite prezime profesora: ");
            String prezime = sc.nextLine();
            System.out.println("Unesite titulu profesora: ");
            String titula = sc.nextLine();
            profesori[i] = new Profesor(sifra,ime,prezime,titula);
        }

        for(int i=0; i<BROJ_PREDMETA; i++){
            System.out.println("Unesite " + (i+1) + ". predmet: ");
            System.out.println("Unesite šifru predmeta: ");
            String sifra = sc.nextLine();
            System.out.println("Unesite naziv predmeta: ");
            String naziv = sc.nextLine();
            System.out.println("Unesite broj ECTS bodova za predmet '"+ naziv +"': ");
            Integer brojBodova = Integer.parseInt(sc.nextLine());
            System.out.println("Odaberite profesora:");
            for(int j=0;j<BROJ_PROFESORA;j++){
                System.out.println((j+1) + "." + profesori[j].getIme() + " " + profesori[j].getPrezime());
            }
            Integer brojProfesora = Integer.parseInt(sc.nextLine());
            Profesor profesor = profesori[(brojProfesora-1)];
            System.out.println("Unesite broj studenata za predmet '"+ naziv +"': ");
            Integer brojStudenata = Integer.parseInt(sc.nextLine());
            predmeti[i] = new Predmet(sifra,naziv,brojBodova,profesor,brojStudenata);
        }

        for(int i=0; i<BROJ_STUDENATA; i++){
            System.out.println("Unesite " + (i+1) + ". studenta: ");
            System.out.println("Unesite ime studenta: ");
            String imeStudenta = sc.nextLine();
            System.out.println("Unesite prezime studenta: ");
            String prezime = sc.nextLine();
            System.out.println("Unesite datum rođenja studenta " + imeStudenta + " " + prezime + " u formatu (dd.MM.yyyy.): ");
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
            LocalDate datum = LocalDate.parse(sc.nextLine(),dtf);
            System.out.println("Unesite JMBAG studenta: ");
            String jmbag = sc.nextLine();
            studenti[i] = new Student(imeStudenta,prezime,jmbag,datum);
        }

        for (int i=0;i<BROJ_ISPITA;i++){
            System.out.println("Unesite " + (i+1) + ". ispitni rok: ");
            System.out.println("Odaberite predmet: ");
            for (int j=0;j<BROJ_PREDMETA;j++){
                System.out.println((j+1) + ". " + predmeti[j].getNaziv());
            }
            Integer brojPredmeta = Integer.parseInt(sc.nextLine());
            Predmet predmet = predmeti[(brojPredmeta-1)];
            for (int j=0;j<BROJ_STUDENATA;j++){
                System.out.println((j+1) + ". " + studenti[j].getIme() + " " + studenti[j].getPrezime());
            }
            Integer brojStudenta = Integer.parseInt(sc.nextLine());
            Student student = studenti[(brojStudenta-1)];
            System.out.println("Unesite ocjenu na ispitu (1-5): ");
            Integer ocjena = Integer.parseInt(sc.nextLine());
            System.out.println("Unesite datum i vrijeme ispita u formatu (dd.MM.yyyy.THH:mm): ");
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy.HH:mm");
            LocalDateTime datumIVrijeme = LocalDateTime.parse(sc.nextLine(),dtf);

            ispiti[i] = new Ispit(predmet,student,ocjena,datumIVrijeme);

        }

        for(int i=0;i<BROJ_ISPITA;i++){
            if(ispiti[i].getOcjena() == 5){
                System.out.println("Student " + ispiti[i].getStudent().getIme() + " " + ispiti[i].getStudent().getPrezime() +
                        "  je ostvario ocjenu 'izvrstan' na predmetu '" + ispiti[i].getPredmet().getNaziv() + "' ");
            }
        }
    }
}
