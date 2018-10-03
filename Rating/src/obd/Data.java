package obd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Data {

	private static String url = "jdbc:oracle:thin:@ora3.elka.pw.edu.pl:1521:ora3inf";
	private static String uzytkownik = "pcielma";
	private static String haslo = "pcielma";

	private static ResultSet rs;
	private static Statement polecenie;
	private static Connection polaczenie;

	public static void openConnection() {
		try {
			polaczenie = DriverManager.getConnection(url, uzytkownik, haslo);
			// System.out.println("AutoCommit: " + polaczenie.getAutoCommit());
			polecenie = polaczenie.createStatement();
		} catch (SQLException e) {
			System.out.println("Błąd programu!");
			e.printStackTrace();
		}
	}

	public static void closeConnection() {
		try {
			polaczenie.close();
		} catch (SQLException e) {
			System.out.println("Błąd programu!");
			e.printStackTrace();
		}
	}

	public static void insertOcenianie(String sql) {
		try {
			System.out.println("execute: " + polecenie.executeUpdate(sql));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static boolean checkExist(String sql) {
		boolean exist = false;
		try {
			rs = polecenie.executeQuery(sql);
			exist = rs.next();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return exist;
	}
	
	public static void isNumber(Scanner input) {
		while (!input.hasNextInt()) {
			System.out.println("\nWprowadź liczbę:");
			input.next();
		}
	}
}