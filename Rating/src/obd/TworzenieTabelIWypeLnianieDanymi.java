package obd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TworzenieTabelIWypeLnianieDanymi {

	private static String url = "jdbc:oracle:thin:@ora3.elka.pw.edu.pl:1521:ora3inf";
	private static String uzytkownik = "pcielma";
	private static String haslo = "pcielma";

	public void createTable() {
		try {

			String sqlPrzedmiotCreateTable = "CREATE TABLE przedmiot(idp integer not null, nazwa_przedmiotu char(20) not null)";
			String sqlNauczycielCreateTable = "CREATE TABLE nauczyciel(idn integer not null, nazwisko_nauczyciela char(30) not null,"
					+ " imie_nauczyciela char(20) not null)";
			String sqlUczenCreateTable = "CREATE TABLE uczen(idu integer not null, nazwisko_ucznia char(30) not null,"
					+ " imie_ucznia char(20) not null)";
			String sqlOcenaCreateTable = "CREATE TABLE ocena(ido integer not null, wartosc_opisowa char(20) not null,"
					+ " wartosc_numeryczna float not null)";
			String sqlOcenianieCreateTable = "CREATE TABLE ocenianie(rodzaj_oceny char(1) not null, idp integer not null,"
					+ "idn integer not null, idu integer not null, ido integer not null)";

			String fillPrzedmiot1 = "INSERT INTO przedmiot(idp, nazwa_przedmiotu) VALUES (1, 'Język polski')";
			String fillPrzedmiot2 = "INSERT INTO przedmiot(idp, nazwa_przedmiotu) VALUES (2, 'Matematyka')";
			String fillPrzedmiot3 = "INSERT INTO przedmiot(idp, nazwa_przedmiotu) VALUES (3, 'Historia')";
			String fillPrzedmiot4 = "INSERT INTO przedmiot(idp, nazwa_przedmiotu) VALUES (4, 'Geografia')";
			String fillPrzedmiot5 = "INSERT INTO przedmiot(idp, nazwa_przedmiotu) VALUES (5, 'Fizyka')";
			String fillPrzedmiot6 = "INSERT INTO przedmiot(idp, nazwa_przedmiotu) VALUES (6, 'Chemia')";
			String fillPrzedmiot7 = "INSERT INTO przedmiot(idp, nazwa_przedmiotu) VALUES (7, 'Biologia')";
			String fillPrzedmiot8 = "INSERT INTO przedmiot(idp, nazwa_przedmiotu) VALUES (8, 'Plastyka')";
			String fillPrzedmiot9 = "INSERT INTO przedmiot(idp, nazwa_przedmiotu) VALUES (9, 'Techanika')";
			String fillPrzedmiot10 = "INSERT INTO przedmiot(idp, nazwa_przedmiotu) VALUES (10, 'Muzyka')";

			String fillNauczyciel1 = "INSERT INTO nauczyciel(idn, nazwisko_nauczyciela, imie_nauczyciela)"
					+ "VALUES (1, 'Kowalski', 'Jan')";
			String fillNauczyciel2 = "INSERT INTO nauczyciel(idn, nazwisko_nauczyciela, imie_nauczyciela)"
					+ "VALUES (2, 'Nowak', 'Paweł')";
			String fillNauczyciel3 = "INSERT INTO nauczyciel(idn, nazwisko_nauczyciela, imie_nauczyciela)"
					+ "VALUES (3, 'Mikołajczyk', 'Piotr')";
			String fillNauczyciel4 = "INSERT INTO nauczyciel(idn, nazwisko_nauczyciela, imie_nauczyciela)"
					+ "VALUES (4, 'Polak', 'Anna')";
			String fillNauczyciel5 = "INSERT INTO nauczyciel(idn, nazwisko_nauczyciela, imie_nauczyciela)"
					+ "VALUES (5, 'Kwiat', 'Małgorzata')";
			String fillNauczyciel6 = "INSERT INTO nauczyciel(idn, nazwisko_nauczyciela, imie_nauczyciela)"
					+ "VALUES (6, 'Gałka', 'Robert')";
			String fillNauczyciel7 = "INSERT INTO nauczyciel(idn, nazwisko_nauczyciela, imie_nauczyciela)"
					+ "VALUES (7, 'Gałka', 'Karolina')";
			String fillNauczyciel8 = "INSERT INTO nauczyciel(idn, nazwisko_nauczyciela, imie_nauczyciela)"
					+ "VALUES (8, 'Kowalski', 'Tomasz')";
			String fillNauczyciel9 = "INSERT INTO nauczyciel(idn, nazwisko_nauczyciela, imie_nauczyciela)"
					+ "VALUES (9, 'Pyra', 'Zbigniew')";
			String fillNauczyciel10 = "INSERT INTO nauczyciel(idn, nazwisko_nauczyciela, imie_nauczyciela)"
					+ "VALUES (10, 'Tyc', 'Michał')";

			String fillUczen1 = "INSERT INTO uczen(idu, nazwisko_ucznia, imie_ucznia)"
					+ "VALUES (1, 'Olaf', 'Marek')";
			String fillUczen2 = "INSERT INTO uczen(idu, nazwisko_ucznia, imie_ucznia)"
					+ "VALUES (2, 'Kowalska', 'Paulina')";
			String fillUczen3 = "INSERT INTO uczen(idu, nazwisko_ucznia, imie_ucznia)"
					+ "VALUES (3, 'Bart', 'Michał')";
			String fillUczen4 = "INSERT INTO uczen(idu, nazwisko_ucznia, imie_ucznia)"
					+ "VALUES (4, 'Parcel', 'Magdalena')";
			String fillUczen5 = "INSERT INTO uczen(idu, nazwisko_ucznia, imie_ucznia)"
					+ "VALUES (5, 'Nowak', 'Piotr')";
			String fillUczen6 = "INSERT INTO uczen(idu, nazwisko_ucznia, imie_ucznia)"
					+ "VALUES (6, 'Bart', 'Anna')";
			String fillUczen7 = "INSERT INTO uczen(idu, nazwisko_ucznia, imie_ucznia)"
					+ "VALUES (7, 'Olaf', 'Agata')";
			String fillUczen8 = "INSERT INTO uczen(idu, nazwisko_ucznia, imie_ucznia)"
					+ "VALUES (8, 'Dark', 'Paweł')";
			String fillUczen9 = "INSERT INTO uczen(idu, nazwisko_ucznia, imie_ucznia)"
					+ "VALUES (9, 'Aktor', 'Stanisław')";
			String fillUczen10 = "INSERT INTO uczen(idu, nazwisko_ucznia, imie_ucznia)"
					+ "VALUES (10, 'Mnich', 'Jolanta')";

			String fillOcena1 = "INSERT INTO ocena(ido, wartosc_opisowa, wartosc_numeryczna) VALUES (1, 'niedostateczny', 1)";
			String fillOcena2 = "INSERT INTO ocena(ido, wartosc_opisowa, wartosc_numeryczna) VALUES (2, 'dopuszczający', 2)";
			String fillOcena3 = "INSERT INTO ocena(ido, wartosc_opisowa, wartosc_numeryczna) VALUES (3, 'dostateczny', 3)";
			String fillOcena4 = "INSERT INTO ocena(ido, wartosc_opisowa, wartosc_numeryczna) VALUES (4, 'dobry', 4)";
			String fillOcena5 = "INSERT INTO ocena(ido, wartosc_opisowa, wartosc_numeryczna) VALUES (5, 'bardzo dobry', 5)";
			String fillOcena6 = "INSERT INTO ocena(ido, wartosc_opisowa, wartosc_numeryczna) VALUES (6, 'celujący', 6)";

			Connection polaczenie = DriverManager.getConnection(url, uzytkownik, haslo);
			System.out.println("AutoCommit: " + polaczenie.getAutoCommit());
			Statement polecenie = polaczenie.createStatement();
			
			System.out.println("execute: " + polecenie.execute(sqlPrzedmiotCreateTable));
			System.out.println("execute: " + polecenie.execute(sqlNauczycielCreateTable));
			System.out.println("execute: " + polecenie.execute(sqlUczenCreateTable));
			System.out.println("execute: " + polecenie.execute(sqlOcenaCreateTable));
			System.out.println("execute: " + polecenie.execute(sqlOcenianieCreateTable));

			System.out.println("execute: " + polecenie.executeUpdate(fillPrzedmiot1));
			System.out.println("execute: " + polecenie.executeUpdate(fillPrzedmiot2));
			System.out.println("execute: " + polecenie.executeUpdate(fillPrzedmiot3));
			System.out.println("execute: " + polecenie.executeUpdate(fillPrzedmiot4));
			System.out.println("execute: " + polecenie.executeUpdate(fillPrzedmiot5));
			System.out.println("execute: " + polecenie.executeUpdate(fillPrzedmiot6));
			System.out.println("execute: " + polecenie.executeUpdate(fillPrzedmiot7));
			System.out.println("execute: " + polecenie.executeUpdate(fillPrzedmiot8));
			System.out.println("execute: " + polecenie.executeUpdate(fillPrzedmiot9));
			System.out.println("execute: " + polecenie.executeUpdate(fillPrzedmiot10));

			System.out.println("execute: " + polecenie.executeUpdate(fillNauczyciel1));
			System.out.println("execute: " + polecenie.executeUpdate(fillNauczyciel2));
			System.out.println("execute: " + polecenie.executeUpdate(fillNauczyciel3));
			System.out.println("execute: " + polecenie.executeUpdate(fillNauczyciel4));
			System.out.println("execute: " + polecenie.executeUpdate(fillNauczyciel5));
			System.out.println("execute: " + polecenie.executeUpdate(fillNauczyciel6));
			System.out.println("execute: " + polecenie.executeUpdate(fillNauczyciel7));
			System.out.println("execute: " + polecenie.executeUpdate(fillNauczyciel8));
			System.out.println("execute: " + polecenie.executeUpdate(fillNauczyciel9));
			System.out.println("execute: " + polecenie.executeUpdate(fillNauczyciel10));

			System.out.println("execute: " + polecenie.executeUpdate(fillUczen1));
			System.out.println("execute: " + polecenie.executeUpdate(fillUczen2));
			System.out.println("execute: " + polecenie.executeUpdate(fillUczen3));
			System.out.println("execute: " + polecenie.executeUpdate(fillUczen4));
			System.out.println("execute: " + polecenie.executeUpdate(fillUczen5));
			System.out.println("execute: " + polecenie.executeUpdate(fillUczen6));
			System.out.println("execute: " + polecenie.executeUpdate(fillUczen7));
			System.out.println("execute: " + polecenie.executeUpdate(fillUczen8));
			System.out.println("execute: " + polecenie.executeUpdate(fillUczen9));
			System.out.println("execute: " + polecenie.executeUpdate(fillUczen10));

			System.out.println("execute: " + polecenie.executeUpdate(fillOcena1));
			System.out.println("execute: " + polecenie.executeUpdate(fillOcena2));
			System.out.println("execute: " + polecenie.executeUpdate(fillOcena3));
			System.out.println("execute: " + polecenie.executeUpdate(fillOcena4));
			System.out.println("execute: " + polecenie.executeUpdate(fillOcena5));
			System.out.println("execute: " + polecenie.executeUpdate(fillOcena6));

			polaczenie.close();
			
			System.out.println("Tabele utworzone i wypełnione");
		} catch (Exception e) {
			System.out.println("Błąd programu!");
			e.printStackTrace();
		}
	}
}
