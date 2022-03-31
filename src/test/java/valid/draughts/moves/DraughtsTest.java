package valid.draughts.moves;

import static valid.draughts.moves.PlayerColor.WHITE;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

// 8:30
public class DraughtsTest {
	private Draughts draughts;

	@BeforeMethod
	void setup() {
		draughts = new Draughts();
	}

	@DataProvider
	Object[][] white_man_moves() {
		return new Object[][] {
				{ """
						._
						w.""", List.of("00-11") },
				{ """
						._._
						_.w.""", List.of("20-11", "20-31") },
				{ """
						._._
						_.w.
						._._""", List.of("21-12", "21-32") },
		};
	}

	@Test(dataProvider = "white_man_moves")
	void white_man_moves_one_square(String position, List<String> expectedMoves) {
		Assertions.assertThat(draughts.getValidMoves(WHITE, position))
				.containsAll(expectedMoves);
	}
}
