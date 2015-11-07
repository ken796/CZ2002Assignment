package assignment_final;

import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

public class user {
	Scanner sc = new Scanner(System.in);
	ArrayList<ArrayList> array_movie = new ArrayList<ArrayList>();
	ArrayList<Movie> NowShowing = new ArrayList<Movie>();
	ArrayList<Movie> Preview = new ArrayList<Movie>();
	ArrayList<Movie> ComingSoon = new ArrayList<Movie>();
	ArrayList<Schedule> array_Schedule = new ArrayList<Schedule>();

	public void userApp() {
		try {
			FileInputStream fis = new FileInputStream("scheduleDatabase.txt");
			ObjectInputStream in = new ObjectInputStream(fis);
			array_Schedule = (ArrayList) in.readObject();
			in.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		printMenu();
		int option;
		do{
		option = sc.nextInt();
		sc.nextLine();
		System.out.println();
		switch (option) {
		case 1: {
			try {
				FileInputStream fis = new FileInputStream("movieDatabase.txt");
				ObjectInputStream in = new ObjectInputStream(fis);
				array_movie = (ArrayList) in.readObject();
				NowShowing = array_movie.get(2);
				ComingSoon = array_movie.get(0);
				Preview = array_movie.get(1);
				in.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			} catch (ClassNotFoundException ex) {
				ex.printStackTrace();
			}
			System.out.println("Now Showing: ");
			for (int i = 0; i < NowShowing.size(); i++) {
				System.out.println((i + 1) + ". " + NowShowing.get(i).getTitle());
			}
			System.out.println("Preview: ");
			for (int i = 0; i < Preview.size(); i++) {
				System.out.println((i + 1) + ". " + Preview.get(i).getTitle());
			}
			System.out.println("Coming Soon: ");
			for (int i = 0; i < ComingSoon.size(); i++) {
				System.out.println((i + 1) + ". " + ComingSoon.get(i).getTitle());
			}
			System.out.println();
			break;
		}
		case 2: {
			booking();
			userApp();
			break;
		}
		case 3: {

			break;
		}
		case 4:
			break;
		case 5: {
			return;
		}
		default :
			System.out.println("Input Error! Try again!\n");

		}
		printMenu();
		}while(option != 5);
	}

	public void booking() {
		Date dnow = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(dnow);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int date = cal.get(Calendar.DATE);

		for (int i = 0; i < array_Schedule.size(); i++) {
			String[] a = new String[4];
			a = array_Schedule.get(i).date.split(" ");
			int y = Integer.parseInt(a[3]);
			int m = Integer.parseInt(a[2]);
			int d = Integer.parseInt(a[1]);
			if (y >= year) {
				if (m >= month) {
					if (d >= date)
						System.out.println(i+1+ ". " + array_Schedule.get(i).date);
				}
			}

		}
		System.out.println("Enter a choice(-1 to return): ");
		int choice = sc.nextInt();
		System.out.println();
		if(choice == -1){
			return;
		}
		array_Schedule.get(choice).printSchedule();
		System.out.println("Choose theatre :");
		int tno = sc.nextInt();
		System.out.println("Enter the time :");
		int time = sc.nextInt();
		System.out.println();
		if (tno == 1) {
			array_Schedule.get(choice).theatre1.slot[time].occupySeat();

		} else if (tno == 2) {
			array_Schedule.get(choice).theatre2.slot[time].occupySeat();
		} else {
			array_Schedule.get(choice).theatre3.slot[time].occupySeat();
		}
		try {
			FileOutputStream fos = new FileOutputStream("scheduleDatabase.txt");
			ObjectOutputStream out = new ObjectOutputStream(fos);
			out.writeObject(array_Schedule);
			out.close();
			System.out.println();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

	public void printMenu() {
		System.out.println("What do you want to do?");
		System.out.println("1. Search/List movie");
		System.out.println("2. Book and purchase ticket");
		System.out.println("3. View booking history");
		System.out.println("4. Top 5 ranking by ticket sales");
		System.out.println("5. Exit");
	}

}
