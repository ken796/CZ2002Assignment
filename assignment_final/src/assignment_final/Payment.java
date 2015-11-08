package assignment_final;
import java.util.*;
import java.io.*;
public class Payment implements Serializable {
	ArrayList<Pricetype> pricelist = new ArrayList<Pricetype>();
	Pricetype regular = new Pricetype();
	Pricetype gold = new Pricetype();
	double price;
	Scanner sc = new Scanner(System.in);
	
	
	public void setPriceRegular(){
		try {
			FileInputStream fis = new FileInputStream("login.txt");
			ObjectInputStream in = new ObjectInputStream(fis);
			pricelist = (ArrayList) in.readObject();
			regular = pricelist.get(0);
			gold = pricelist.get(1);
			in.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		System.out.println("Set Adult Price: ");
		price = sc.nextDouble();
		regular.setAdultPrice(price);
		System.out.println("Set Children Price: ");
		price = sc.nextDouble();
		regular.setChildrenPrice(price);
		System.out.println("Set Senior Price: ");
		price = sc.nextDouble();
		regular.setSeniorPrice(price);
		System.out.println("Set student Price: ");
		price = sc.nextDouble();
		regular.setStudentPrice(price);
		pricelist.add(regular);
		pricelist.add(gold);
		try {
			FileOutputStream fos = new FileOutputStream("pricelist.txt");
			ObjectOutputStream out = new ObjectOutputStream(fos);
			out.writeObject(pricelist);
			out.close();
			System.out.println("Object saved");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
	}
	public void setPriceGold(){
		try {
			FileInputStream fis = new FileInputStream("login.txt");
			ObjectInputStream in = new ObjectInputStream(fis);
			pricelist = (ArrayList) in.readObject();
			regular = pricelist.get(0);
			gold = pricelist.get(1);
			in.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		System.out.println("Set Adult Price: ");
		price = sc.nextDouble();
		gold.setAdultPrice(price);
		System.out.println("Set Children Price: ");
		price = sc.nextDouble();
		gold.setChildrenPrice(price);
		System.out.println("Set Senior Price: ");
		price = sc.nextDouble();
		gold.setSeniorPrice(price);
		System.out.println("Set student Price: ");
		price = sc.nextDouble();
		gold.setStudentPrice(price);
		pricelist.add(regular);
		pricelist.add(gold);
		try {
			FileOutputStream fos = new FileOutputStream("pricelist.txt");
			ObjectOutputStream out = new ObjectOutputStream(fos);
			out.writeObject(pricelist);
			out.close();
			System.out.println("Object saved");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
	}
	
	

}
