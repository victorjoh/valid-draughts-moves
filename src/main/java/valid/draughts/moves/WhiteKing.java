package valid.draughts.moves;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class WhiteKing implements Piece {
	DarkSquare square;

	@Override
	public List<Move> getMoves() {
		List<DarkSquare> moveEndSquares = new ArrayList<>();
		Optional<DarkSquare> moveEndSquare;
		DarkSquare squareBefore = square;
		while ((moveEndSquare = squareBefore.getTopRightSquare()).isPresent()) {
			moveEndSquares.add(moveEndSquare.get());
			squareBefore = moveEndSquare.get();
		}

		return moveEndSquares.stream()
				.map(targetSquare -> new Move(square, targetSquare))
				.toList();
	}

	@Override
	public void setSquare(DarkSquare square) {
		this.square = square;
	}
}
