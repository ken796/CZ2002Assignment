package assignment_final;
import java.util.*;
import java.io.*;

public class UserId implements Serializable {
	private String id;
	private String password;
	private int phone;
	ArrayList<UserRecord> array_record = new ArrayList<UserRecord>();
	
	public void addUserRecord()
	{
		UserRecord record = new UserRecord(date, movieTitle, payment);
		array_record.add(record);
	}
	

}
