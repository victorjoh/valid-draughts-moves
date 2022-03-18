package valid.draughts.moves;

import org.testng.annotations.*;
import static org.testng.Assert.*;

public class LibraryTest {

	@Test
	public void someLibraryMethodReturnsTrue() {
		Library classUnderTest = new Library();
		assertTrue(classUnderTest.someLibraryMethod(), "someLibraryMethod should return 'true'");
	}
}
