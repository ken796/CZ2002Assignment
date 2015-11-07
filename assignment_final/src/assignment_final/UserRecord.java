package assignment_final;
import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;
public class UserRecord implements Serializable{
	private Date date;
	private String MovieTitle;
	private double payment;

	public UserRecord(Date date, String movieTitle, double payment)
	{
		this.date = date;
		this.MovieTitle = movieTitle;
		this.payment = payment;
	}
	public String getDate()
	{
		SimpleDateFormat ft = new SimpleDateFormat("E dd MM yyyy");
		return ft.format(date);
	}
	public String getMovieTitle(){
		return MovieTitle;
	}
	public double getPayment(){
		return payment;
	}
}
