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
	public Object[][] white_man_single_capture_blocked() {
		return new Object[][] {
				{ """
						_.b
						.b.
						w._""", turns() },
				{ """
						_.K
						.b.
						w._""", turns() },
				{ """
						_.w
						.b.
						w._""", turns() },
				{ """
						_.b
						.w.
						_._""", turns("11-02") },
		};
	}

	@Test(dataProvider = "white_man_single_capture_blocked")
	void white_man_cannot_capture_black_pieces_if_there_is_nowhere_to_land(String position, String[] expectedTurns) {
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
				{ """
						K._.
						._._
						_.b.
						._._""", turns("03x30") },
		};
	}

	@Test(dataProvider = "white_king_single_capture_turns")
	void white_king_can_capture_black_pieces(String position, String[] expectedTurns) {
		assertThat(Draughts.getValidMoves(WHITE, position))
				.containsExactlyInAnyOrder(expectedTurns);
	}

	@DataProvider
	public Object[][] white_king_single_capture_blocked() {
		return new Object[][] {
				{ """
						_.b
						.b.
						K._""", turns() },
				{ """
						_.K
						.b.
						K._""", turns() },
				{ """
						_.w
						.b.
						K._""", turns() },
				{ """
						_.b
						.K.
						_._""", turns("11-02", "11-20", "11-00") },
		};
	}

	@Test(dataProvider = "white_king_single_capture_blocked")
	void white_king_cannot_capture_black_pieces_if_there_is_nowhere_to_land(String position, String[] expectedTurns) {
		assertThat(Draughts.getValidMoves(WHITE, position))
				.containsExactlyInAnyOrder(expectedTurns);
	}

	@DataProvider
	public Object[][] white_man_multiple_capture_turns() {
		return new Object[][] {
				{ """
						_._._
						._._.
						_._._
						.b.B.
						w._._""", turns("00x22x40") },
				{ """
						_._._
						._.B.
						_._._
						.b._.
						w._._""", turns("00x22x44") },
				{ """
						_._._
						.B._.
						_._._
						.b._.
						w._._""", turns("00x22x04") },
				{ """
						_._._
						._._.
						_._._
						.b.B.
						_._.w""", turns("40x22x00") },
				{ """
						_._._
						.b.b.
						_._._
						.b.b.
						w._._""", turns("00x22x40", "00x22x44", "00x22x04") },
		};
	}

	@Test(dataProvider = "white_man_multiple_capture_turns")
	void white_man_can_capture_multiple_black_pieces(String position, String[] expectedTurns) {
		assertThat(Draughts.getValidMoves(WHITE, position))
				.containsExactlyInAnyOrder(expectedTurns);
	}

	@DataProvider
	public Object[][] white_king_multiple_capture_turns() {
		return new Object[][] {
				{ """
						_._._
						._._.
						_._._
						.b.B.
						K._._""", turns("00x22x40") },
				{ """
						_._._
						._.B.
						_._._
						.b._.
						K._._""", turns("00x22x44") },
				{ """
						_._._
						.B._.
						_._._
						.b._.
						K._._""", turns("00x22x04") },
				{ """
						_._._
						._._.
						_._._
						.b.B.
						_._.K""", turns("40x22x00") },
				{ """
						_._._
						.b.b.
						_._._
						.b.b.
						K._._""", turns("00x22x40", "00x22x44", "00x22x04") },
				{ """
						_._._.
						.b._._
						_._.B.
						._._.K""", turns("50x23x01") },
				{ """
						_._._.
						.b._._
						_._._.
						._._._
						_._.B.
						._._.K""", turns("50x32x05", "50x23x05") },
				{ """
						_._._.
						.b._._
						_._._.
						.b._._
						_._.B.
						._._.K""", turns("50x23x01", "50x32x05", "50x23x05") },
		};
	}

	@Test(dataProvider = "white_king_multiple_capture_turns")
	void white_king_can_capture_multiple_black_pieces(String position, String[] expectedTurns) {
		assertThat(Draughts.getValidMoves(WHITE, position))
				.containsExactlyInAnyOrder(expectedTurns);
	}

	@DataProvider
	public Object[][] start_square_revisited() {
		return new Object[][] {
				{ """
						_.w._
						.b.b.
						_._._
						.b.b.
						_._._""", turns("24x42x20x02x24", "24x02x20x42x24") },
				{ """
						_._._
						.b._.
						_.w._
						.b.b.
						_._._
						.b.b.
						_._._""", turns("24x42x20x02x24x06", "24x02x20x42x24x06") },
				{ """
						_.K._
						.b.b.
						_._._
						.b.b.
						_._._""", turns("24x42x20x02x24", "24x02x20x42x24") },
				{ """
						_._._
						.b._.
						_.K._
						.b.b.
						_._._
						.b.b.
						_._._""", turns("24x42x20x02x24x06", "24x02x20x42x24x06") },
				{ """
						._._.
						_.b._
						._._.
						_.K._
						.b.b.
						_._._
						.b.b.
						_._._""", turns("24x42x20x02x35x17", "24x02x20x42x15x37") },
				{ """
						_._._
						.b.b.
						_._._
						._.b.
						_.K._
						._.b.
						_._._""", turns("22x44x26x04x40") },
		};
	}

	@Test(dataProvider = "start_square_revisited")
	void when_capturing_and_landing_on_the_start_square_then_the_start_square_acts_as_an_empty_square(
			String position,
			String[] expectedTurns
	) {
		assertThat(Draughts.getValidMoves(WHITE, position))
				.containsExactlyInAnyOrder(expectedTurns);
	}
}
