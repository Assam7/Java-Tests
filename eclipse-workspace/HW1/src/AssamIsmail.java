
public class AssamIsmail {
public String getFullName()
{
	String fullName = "Assam Ismail";
	return fullName;
}
public String getFirstName()
{
	String firstName = "Assam";
	return firstName;
}
public String getLastName()
{
	String lastName = "Ismail";
	return lastName;
}
public String getUCInetID()
{
	String UCIid = "anismail";
	return UCIid;
}
public int getStudentNumber()
{
	int studentNum = 59169097;
	return studentNum;
}
public String getRotatedFullName(int shift)
{
	String fullName = getFullName();
	String total = "";
	String result = "";
	StringBuilder rotated = new StringBuilder(fullName);
	System.out.println(rotated.length()-1);
	if (shift >= 0)
	{
		for (int i = 0; i<shift;i++)
		{
			total += fullName.charAt(i);
			rotated.deleteCharAt(i);
		}
		System.out.println(rotated);
		result = rotated+total;
	}
	else
	{
		for (int i = (shift * (-1)); i>0;i--)
		{
			System.out.println("N"+(rotated.length()-1));
			total += fullName.charAt((fullName.length())-i);
			System.out.println(total);
			rotated.deleteCharAt(rotated.length()-1);
			System.out.println("N"+rotated);
		}
		result = total+rotated;
	}
	return result;
	
}
}
