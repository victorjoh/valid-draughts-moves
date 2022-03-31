package valid.draughts.moves;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

class WhiteKing implements Piece {
	DarkSquare square;

	@Override
	public List<Move> getMoves() {
		return Stream.of((Function<DarkSquare, Optional<DarkSquare>>)
				DarkSquare::getTopRightSquare,
				DarkSquare::getBottomLeftSquare)
				.map(this::getAllSquaresTowards)
				.flatMap(List::stream)
				.map(targetSquare -> new Move(square, targetSquare))
				.toList();
	}

	private List<DarkSquare> getAllSquaresTowards(
			Function<DarkSquare, Optional<DarkSquare>> direction
	) {
		List<DarkSquare> squares = new ArrayList<>();
		Optional<DarkSquare> nextSquare;
		DarkSquare currentSquare = square;
		while ((nextSquare = direction.apply(currentSquare)).isPresent()) {
			squares.add(nextSquare.get());
			currentSquare = nextSquare.get();
		}
		return squares;
	}

	@Override
	public void setSquare(DarkSquare square) {
		this.square = square;
	}
}
