package obd;

import java.util.Scanner;

public class Main {

	private static Scanner sc = new Scanner(System.in);
	private static int input;
	private static boolean run = true;

	public static void main(String[] args) {

		TworzenieTabelIWypeLnianieDanymi tworzenie = new TworzenieTabelIWypeLnianieDanymi();
		Ocenianie ocenianie = new Ocenianie();

		System.out.println("Program do wystawiania ocen\nAutor: Paweł Cielma\n");

		while (run) {
			System.out.println(
					"Utworzyć tabele czy oceniać? [Wybierz:]:\n1: Utwórz tabele bazy danych\n2: Oceniaj\n3: Wyjście z programu");

			while (!sc.hasNextInt()) {
				System.out.println("Wybierz 1, 2 lub 3!\n");
				sc.next();
			}
			do {
				input = sc.nextInt();
				if (input < 1 || input >= 4) {
					System.out.println("Wybierz 1, 2 lub 3!\n");
				}
			} while (input < 1 || input >= 4);

			if (input == 1) {
				run = true;
				tworzenie.createTable();
			} else if (input == 2) {
				run = true;
				ocenianie.ocenianie();
			} else if (input == 3) {
				run = false;
				System.out.println("Koniec programu");
			}
		}
	}
}