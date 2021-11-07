import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;


// This is just my initial, non-completed test class that I created during 
// class. Your goal is to complete this with more test cases (either using
// parameterized testing or just the regular @Test methods. Look at the 
// specification.

// Here is the specification, for convenience:

/* Specification: This method takes three integers as input and outputs an
 * integer. The three input variables each describe the lengths of each 
 * side of a triangle. The lengths of the sides of the triangle should be 
 * less than or equal to 1000. The output of this method will be one of 
 * 5 possible values: 
 * 		1 for a scalene triangle, 
 * 		2 for an isosceles triangle, 
 * 		3 for an equilateral triangle, 
 * 		4 for values that do not describe a triangle, and 
 * 		5 for values that are out of bounds.
 */
class TriangleTyperTest {
	@Test
	void testTyper()
	{
		TriangleTyper expected = new TriangleTyper();
		Assertions.assertEquals(expected instanceof TriangleTyper, true);
	}
		// Parameterized version (you just need to add more values to the @CsvSource)
	@ParameterizedTest(name="{0}: sides {1}, {2}, {3} Expected= {4}")
	@CsvSource({"'Equilateral', 5, 5, 5, 3",
		"'Scalene a<b<c', 3, 4, 5, 1",
		"'Isoceles', 3,3,6,4",
		"'Isoceles', 3,3,5,2",
		"'Isoceles', 3,6,3,4",
		"'Isoceles', 3,5,3,2",
		"'Isoceles', 6,3,3,4",
		"'Isoceles', 5,3,3,2",
		"'Not A Triangle',0,0,0,4",
		"'Not A Triangle',1,0,0,4",
		"'Not A Triangle',1,1,0,4",
		"'Not A Triangle',1,2,3,4",
		"'Not A Triangle',3,2,1,4",
		"'Not A Triangle',1,3,2,4",
		"'Out of bounds',1001,10,10,5",
		"'Out of bounds',10,2000,30,5",
		"'Out of bounds',10,20,3000,5"
		})
	void testTyper(String name, int a, int b, int c, int expected) {
		int type = TriangleTyper.typer(a, b, c);
		Assertions.assertEquals(expected, type);
	}
	@Test
	void checkObjectIsoc()
	{
		Triangle t = new Triangle(3,3,5);
		TriangleType type = TriangleTyper.typer(t);
		Assertions.assertEquals(TriangleType.ISOSCELES, type);
	}
	@Test
	void checkObjectEqual()
	{
		Triangle t = new Triangle(3,3,3);
		TriangleType type = TriangleTyper.typer(t);
		Assertions.assertEquals(TriangleType.EQUILATERAL, type);
	}
	@Test
	void checkObjectNAT()
	{
		Triangle t = new Triangle(0,0,0);
		TriangleType type = TriangleTyper.typer(t);
		Assertions.assertEquals(TriangleType.NOT_TRIANGLE, type);
	}
	@Test
	void checkObjectOOB()
	{
		Triangle t = new Triangle(1001,3,5);
		TriangleType type = TriangleTyper.typer(t);
		Assertions.assertEquals(TriangleType.OOB, type);
	}

	@Test
	void checkObjectForNotNull() 
	{
			Triangle t = new Triangle(3,4,5);
	        TriangleTyper.typer(t);
		}
	@Test
	void checkObjectForNull() 
	{
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
	        Triangle t = null;
	        TriangleTyper.typer(t);
		});
	}
	@Test
	void CheckMockObj() 
	{
		Triangle t = new Triangle(3,4,5);
		TriangleTyper test = mock(TriangleTyper.class);
		test.setTriangleType(t);
	}
	@Test
	void CheckMockObjForError() 
	{
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
	        Triangle t = null;
	        TriangleTyper test = mock(TriangleTyper.class);
	        test.setTriangleType(t);;
		});
	}
}
