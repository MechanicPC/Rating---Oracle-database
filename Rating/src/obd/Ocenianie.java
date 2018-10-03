package obd;

import java.io.IOException;
import java.util.Scanner;

public class Ocenianie {

	private boolean ocenianie = false;
	private Scanner input = new Scanner(System.in);

	public void ocenianie() {

		System.out.println("Czy chcesz wystawić ocenę [t/n] :");
		char yesOrNot = input.next().charAt(0);

		if (Character.toUpperCase(yesOrNot) == 'T') {
			ocenianie = true;
		}
		Data.openConnection();
		while (ocenianie) {

			System.out.println("\nWprowadź rodzaj oceny ['C' - cząstkowa, 'S' - semestralna] :");
			char rodzajOceny = Character.toUpperCase(input.next().charAt(0));

			System.out.println("\nWprowadź id przedmiotu :");
			Data.isNumber(input);
			int przedmiot = input.nextInt();

			System.out.println("\nWprowadź id nauczyciela :");
			Data.isNumber(input);
			int nauczyciel = input.nextInt();

			System.out.println("\nWprowadź id ucznia :");
			Data.isNumber(input);
			int uczen = input.nextInt();

			System.out.println("\nWprowadź id oceny :");
			Data.isNumber(input);
			int ocena = input.nextInt();

			
			if (rodzajOceny == 'C' || rodzajOceny == 'S') {
				if (Data.checkExist("SELECT * FROM przedmiot WHERE idp = " + przedmiot)) {
					if (Data.checkExist("SELECT * FROM nauczyciel WHERE idn = " + nauczyciel)) {
						if (Data.checkExist("SELECT * FROM uczen WHERE idu = " + uczen)) {
							if (Data.checkExist("SELECT * FROM ocena WHERE ido = " + ocena)) {

								Data.insertOcenianie("INSERT INTO ocenianie(rodzaj_oceny, idp, idn, idu, ido) VALUES "
										+ "('" + rodzajOceny + "'," + przedmiot + "," + nauczyciel + "," + uczen + ","
										+ ocena + ")");
							} else
								System.out.println("Oceny nie ma na liście");
						} else
							System.out.println("Ucznia nie ma na liście");
					} else
						System.out.println("Nauczyciela nie ma na liście");
				} else
					System.out.println("Przedmiotu nie ma na liście");
			} else {
				System.out.println("Rodzaj oceny musi być 'C' lub 'S'\n");
			}
			System.out.println("Czy chcesz oceniać kolejnego ucznia: \n");

			yesOrNot = input.next().charAt(0);
			if (Character.toUpperCase(yesOrNot) != 'T') {
				ocenianie = false;
			}
		}
		System.out.println("Koniec oceniania:");
		Data.closeConnection();
	}

	public static void czyscEkran() {
		try {
			Runtime.getRuntime().exec("cls");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}