package valid.draughts.moves;

import static org.assertj.core.api.Assertions.assertThat;
import static valid.draughts.moves.PlayerColor.BLACK;
import static valid.draughts.moves.PlayerColor.WHITE;

import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DraughtsTest {

	@DataProvider
	Object[][] white_man_move_turns() {
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

	@Test(dataProvider = "white_man_move_turns")
	void white_man_moves_one_step_forward(String position, List<String> expectedMoves) {
		assertThat(Draughts.getValidMoves(WHITE, position))
				.containsAll(expectedMoves);
	}

	@DataProvider
	Object[][] black_man_move_turns() {
		return new Object[][] {
				{ """
						.b
						_.""", List.of("11-00") },
		};
	}

	@Test(dataProvider = "black_man_move_turns")
	void black_man_moves_one_step_forward(String position, List<String> expectedMoves) {
		assertThat(Draughts.getValidMoves(BLACK, position))
				.containsAll(expectedMoves);
	}

	@DataProvider
	Object[][] white_king_move_turns() {
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
				{ """
						K._
						._.
						_._""", List.of("02-11", "02-20") },
				{ """
						_._
						._.
						_.K""", List.of("20-11", "20-02") },
				{ """
						_._
						.K.
						_._""", List.of("11-02", "11-22", "11-20", "11-00") },
		};
	}

	@Test(dataProvider = "white_king_move_turns")
	void white_king_moves_multiple_steps_in_any_direction(String position, List<String> expectedMoves) {
		assertThat(Draughts.getValidMoves(WHITE, position))
				.containsAll(expectedMoves);
	}

	@DataProvider
	Object[][] black_king_move_turns() {
		return new Object[][] {
				{ """
						_._
						.B.
						_._""", List.of("11-02", "11-22", "11-20", "11-00") },
		};
	}

	@Test(dataProvider = "black_king_move_turns")
	void black_king_moves_multiple_steps_in_any_direction(String position, List<String> expectedMoves) {
		assertThat(Draughts.getValidMoves(BLACK, position))
				.containsAll(expectedMoves);
	}

	@DataProvider
	public Object[][] white_man_capture_turns() {
		return new Object[][] {
				{ """
						_._
						.b.
						w._""", List.of("00x22") },
		};
	}

	@Test(dataProvider = "white_man_capture_turns")
	void white_man_can_capture_black_pieces(String position, List<String> expectedMoves) {
		assertThat(Draughts.getValidMoves(WHITE, position))
				.containsAll(expectedMoves);
	}
}
