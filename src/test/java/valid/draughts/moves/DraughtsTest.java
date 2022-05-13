package valid.draughts.moves;

import static org.assertj.core.api.Assertions.assertThat;
import static valid.draughts.moves.PlayerColor.BLACK;
import static valid.draughts.moves.PlayerColor.WHITE;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DraughtsTest {

	private static String[] turns(String... expectedTurns) {
		return expectedTurns;
	}

	@DataProvider
	Object[][] white_man_move_turns() {
		return new Object[][] {
				{ """
						._
						w.""", turns("00-11") },
				{ """
						._._
						_.w.""", turns("20-11", "20-31") },
				{ """
						._._
						_.w.
						._._""", turns("21-12", "21-32") },
				{ """
						w""", turns() },
				{ """
						_.
						.w""", turns("10-01") },
		};
	}

	@Test(dataProvider = "white_man_move_turns")
	void white_man_moves_one_step_forward(String position, String[] expectedTurns) {
		assertThat(Draughts.getValidMoves(WHITE, position))
				.containsExactlyInAnyOrder(expectedTurns);
	}

	@DataProvider
	Object[][] black_man_move_turns() {
		return new Object[][] {
				{ """
						.b
						_.""", turns("11-00") },
		};
	}

	@Test(dataProvider = "black_man_move_turns")
	void black_man_moves_one_step_forward(String position, String[] expectedTurns) {
		assertThat(Draughts.getValidMoves(BLACK, position))
				.containsExactlyInAnyOrder(expectedTurns);
	}

	@DataProvider
	Object[][] white_king_move_turns() {
		return new Object[][] {
				{ """
						._
						K.""", turns("00-11") },
				{ """
						_._
						._.
						K._""", turns("00-11", "00-22") },
				{ """
						_.K
						._.
						_._""", turns("22-11", "22-00") },
				{ """
						K._
						._.
						_._""", turns("02-11", "02-20") },
				{ """
						_._
						._.
						_.K""", turns("20-11", "20-02") },
				{ """
						_._
						.K.
						_._""", turns("11-02", "11-22", "11-20", "11-00") },
		};
	}

	@Test(dataProvider = "white_king_move_turns")
	void white_king_moves_multiple_steps_in_any_direction(String position, String[] expectedTurns) {
		assertThat(Draughts.getValidMoves(WHITE, position))
				.containsExactlyInAnyOrder(expectedTurns);
	}

	@DataProvider
	Object[][] black_king_move_turns() {
		return new Object[][] {
				{ """
						_._
						.B.
						_._""", turns("11-02", "11-22", "11-20", "11-00") },
		};
	}

	@Test(dataProvider = "black_king_move_turns")
	void black_king_moves_multiple_steps_in_any_direction(String position, String[] expectedTurns) {
		assertThat(Draughts.getValidMoves(BLACK, position))
				.containsExactlyInAnyOrder(expectedTurns);
	}

	@DataProvider
	public Object[][] white_man_single_capture_turns() {
		return new Object[][] {
				{ """
						_._
						.b.
						w._""", turns("00x22") },
				{ """
						_._
						.b.
						_.w""", turns("20x02") },
				{ """
						_.w
						.b.
						_._""", turns("22x00") },
				{ """
						w._
						.b.
						_._""", turns("02x20") },
		};
	}

	@Test(dataProvider = "white_man_single_capture_turns")
	void white_man_can_capture_black_pieces(String position, String[] expectedTurns) {
		assertThat(Draughts.getValidMoves(WHITE, position))
				.containsExactlyInAnyOrder(expectedTurns);
	}

	@DataProvider
	public Object[][] white_king_single_capture_turns() {
		return new Object[][] {
				{ """
						._._
						_._.
						.b._
						K._.""", turns("00x22", "00x33") },
				{ """
						_._.
						._._
						_.b.
						._.K""", turns("30x12", "30x03") },
				{ """
						._.K
						_.b.
						._._
						_._.""", turns("33x11", "33x00") },
				{ """
						K._.
						.b._
						_._.
						._._""", turns("03x21", "03x30") },
		};
	}

	@Test(dataProvider = "white_king_single_capture_turns")
	void white_king_can_capture_black_pieces(String position, String[] expectedTurns) {
		assertThat(Draughts.getValidMoves(WHITE, position))
				.containsExactlyInAnyOrder(expectedTurns);
	}
}
