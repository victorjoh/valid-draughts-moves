package valid.draughts.moves;

import static valid.draughts.moves.Direction.BACKWARDS_LEFT;
import static valid.draughts.moves.Direction.BACKWARDS_RIGHT;
import static valid.draughts.moves.Direction.FORWARD_LEFT;
import static valid.draughts.moves.Direction.FORWARD_RIGHT;
import static valid.draughts.moves.PlayerColor.WHITE;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import com.google.common.collect.Lists;

public class Draughts {

	@SafeVarargs
	public static <T> List<T> concatenate(List<T>... lists) {
		return Stream.of(lists)
				.flatMap(Collection::stream)
				.toList();
	}

	public static List<String> getValidMoves(PlayerColor player, String position) {
		return parseBoardPosition(player, position).stream()
				.map(DarkSquareWithPlayerPiece::getPlayerTurns)
				.flatMap(Collection::stream)
				.map(Object::toString)
				.toList();
	}

	private static final char WHITE_MAN = 'w';
	private static final char WHITE_KING = 'K';
	private static final char BLACK_MAN = 'b';
	private static final char BLACK_KING = 'B';
	private static final char DARK_SQUARE = '_';
	private static final OutOfBoundsSquare OUT_OF_BOUNDS = new OutOfBoundsSquare();

	static List<DarkSquareWithPlayerPiece> parseBoardPosition(PlayerColor player, String position) {
		List<String> rows = Lists.reverse(position.lines().toList());

		char myMan;
		char myKing;
		char opponentMan;
		char opponentKing;
		int forward;
		if (player.equals(WHITE)) {
			myMan = WHITE_MAN;
			myKing = WHITE_KING;
			opponentMan = BLACK_MAN;
			opponentKing = BLACK_KING;
			forward = 1;
		} else {
			myMan = BLACK_MAN;
			myKing = BLACK_KING;
			opponentMan = WHITE_MAN;
			opponentKing = WHITE_KING;
			forward = -1;
		}
		
		List<DarkSquareWithPlayerPiece> myPieces = new ArrayList<>();
		List<List<DarkSquare>> parsedRows = new ArrayList<>();
		for (int y = 0; y < rows.size(); y++) {
			String row = rows.get(y);
			List<DarkSquare> parsedRow = new ArrayList<>();
			for (int x = 0; x < row.length(); x++) {
				if (row.charAt(x) == DARK_SQUARE) {
					parsedRow.add(new EmptyDarkSquare(x, y));
				} else if (row.charAt(x) == myMan) {
					DarkSquareWithPlayerMan darkSquareWithMyMan = new DarkSquareWithPlayerMan(x, y);
					parsedRow.add(darkSquareWithMyMan);
					myPieces.add(darkSquareWithMyMan);
				} else if (row.charAt(x) == myKing) {
					DarkSquareWithPlayerKing darkSquareWithMyKing = new DarkSquareWithPlayerKing(x, y);
					parsedRow.add(darkSquareWithMyKing);
					myPieces.add(darkSquareWithMyKing);
				} else if (row.charAt(x) == opponentMan || row.charAt(x) == opponentKing) {
					parsedRow.add(new DarkSquareWithOpponentPiece(x, y));
				}
			}
			parsedRows.add(parsedRow);
		}
		
		for (List<DarkSquare> parsedRow : parsedRows) {
			for (DarkSquare darkSquare : parsedRow) {
				int x = darkSquare.getX();
				int y = darkSquare.getY();
				darkSquare.setAdjacentSquare(FORWARD_LEFT, getSquare(parsedRows, x - 1, y + forward));
				darkSquare.setAdjacentSquare(FORWARD_RIGHT, getSquare(parsedRows, x + 1, y + forward));
				darkSquare.setAdjacentSquare(BACKWARDS_LEFT, getSquare(parsedRows, x - 1, y - forward));
				darkSquare.setAdjacentSquare(BACKWARDS_RIGHT, getSquare(parsedRows, x + 1, y - forward));
			}
		}

		return myPieces;
	}

	private static Square getSquare(List<List<DarkSquare>> parsedRows, int x, int y) {
		if (y < 0 || y >= parsedRows.size()) {
			return OUT_OF_BOUNDS;
		}
		for (DarkSquare darkSquare : parsedRows.get(y)) {
			if (darkSquare.getX() == x) {
				return darkSquare;
			}
		}
		return OUT_OF_BOUNDS;
	}

	class BoardPosition {
		List<DarkSquareWithPlayerPiece> myPieces;

		public void addMyPiece(DarkSquareWithPlayerPiece myPiece) {
			myPieces.add(myPiece);
		}
	}
}
