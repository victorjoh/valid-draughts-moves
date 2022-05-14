package valid.draughts.moves;

import static valid.draughts.moves.Direction.BACKWARD_LEFT;
import static valid.draughts.moves.Direction.BACKWARD_RIGHT;
import static valid.draughts.moves.Direction.FORWARD_LEFT;
import static valid.draughts.moves.Direction.FORWARD_RIGHT;

import java.util.ArrayList;
import java.util.List;

class BoardPosition {
	private static final OutOfBoundsSquare OUT_OF_BOUNDS = new OutOfBoundsSquare();

	private final ParsingConfig config;
	private final List<List<DarkSquare>> rows = new ArrayList<>();
	private final List<DarkSquareWithPlayerPiece> playerPieces = new ArrayList<>();

	BoardPosition(ParsingConfig config) {
		this.config = config;
	}

	void addRow(List<DarkSquare> row) {
		rows.add(row);
	}

	void addPlayerPiece(DarkSquareWithPlayerPiece playerPiece) {
		playerPieces.add(playerPiece);
	}

	void linkSquares() {
		for (List<DarkSquare> row : rows) {
			for (DarkSquare square : row) {
				int x = square.getX();
				int y = square.getY();
				square.setAdjacentSquare(FORWARD_LEFT, getSquare(x - 1, y + config.forward()));
				square.setAdjacentSquare(FORWARD_RIGHT, getSquare(x + 1, y + config.forward()));
				square.setAdjacentSquare(BACKWARD_LEFT, getSquare(x - 1, y - config.forward()));
				square.setAdjacentSquare(BACKWARD_RIGHT, getSquare(x + 1, y - config.forward()));
			}
		}
	}

	private Square getSquare(int x, int y) {
		if (y < 0 || y >= rows.size()) {
			return OUT_OF_BOUNDS;
		}
		for (DarkSquare darkSquare : rows.get(y)) {
			if (darkSquare.getX() == x) {
				return darkSquare;
			}
		}
		return OUT_OF_BOUNDS;
	}

	List<DarkSquareWithPlayerPiece> getPlayerPieces() {
		return playerPieces;
	}
}
