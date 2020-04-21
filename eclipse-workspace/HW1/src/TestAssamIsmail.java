import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class TestAssamIsmail 
{	AssamIsmail test;
	@BeforeEach
	public void setup()
	{
		test = new AssamIsmail();
	}
	@Test
    public void getFullName() 
	{
        String result = test.getFullName();
        Assertions.assertEquals("Assam Ismail",result);
    }
	@Test
    public void getFirstName() 
	{
        String result = test.getFirstName();
        Assertions.assertEquals("Assam",result);
    }
	@Test
    public void getLastName() 
	{
        String result = test.getLastName();
        Assertions.assertEquals("Ismail",result);
    }
	@Test
    public void getUCInetID() 
	{
        String result = test.getUCInetID();
        Assertions.assertEquals("anismail",result);
    }
	@Test
    public void getStudentNumber() 
	{
        int result = test.getStudentNumber();
        Assertions.assertEquals(59169097,result);
    }
	@Test
    public void getRotatedFullNamePositive() 
	{
        String result = test.getRotatedFullName(2);
        Assertions.assertEquals("sam IsmailAs",result);
    }
	@Test
	 public void getRotatedFullNameNegative() 
		{
	        String result = test.getRotatedFullName(-5);
	        System.out.println(result);
	        Assertions.assertEquals("smailAssam I",result);
	    }
}
