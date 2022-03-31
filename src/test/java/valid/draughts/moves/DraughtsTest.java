package valid.draughts.moves;

import static valid.draughts.moves.PlayerColor.BLACK;
import static valid.draughts.moves.PlayerColor.WHITE;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

// 9:00
// 12:00
public class DraughtsTest {
	private Draughts draughts;

	@BeforeMethod
	void setup() {
		draughts = new Draughts();
	}

	@DataProvider
	Object[][] single_white_man_and_expected_moves() {
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
				{ """
						w""", List.of() },
				{ """
						_.
						.w""", List.of("10-01") },
		};
	}

	@Test(dataProvider = "single_white_man_and_expected_moves")
	void single_white_man_moves_one_step_forward(String position, List<String> expectedMoves) {
		Assertions.assertThat(draughts.getValidMoves(WHITE, position))
				.containsAll(expectedMoves);
	}

	@DataProvider
	Object[][] single_black_man_and_expected_moves() {
		return new Object[][] {
				{ """
						.b
						_.""", List.of("11-00") },
		};
	}

	@Test(dataProvider = "single_black_man_and_expected_moves")
	void single_black_man_moves_one_step_forward(String position, List<String> expectedMoves) {
		Assertions.assertThat(draughts.getValidMoves(BLACK, position))
				.containsAll(expectedMoves);
	}

	@DataProvider
	Object[][] single_white_king_and_expected_moves() {
		return new Object[][] {
				{ """
						._
						K.""", List.of("00-11") },
				{ """
						_._
						._.
						K._""", List.of("00-11", "00-22") },
				{ """
						_.K
						._.
						_._""", List.of("22-11", "22-00") },
		};
	}

	@Test(dataProvider = "single_white_king_and_expected_moves")
	void single_white_king_moves_multiple_steps_in_any_direction(String position, List<String> expectedMoves) {
		Assertions.assertThat(draughts.getValidMoves(WHITE, position))
				.containsAll(expectedMoves);
	}
}
