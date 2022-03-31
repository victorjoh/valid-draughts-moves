package valid.draughts.moves;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

class King implements Piece {
	DarkSquare square;

	@Override
	public List<Turn> getPossibleTurns() {
		var directions = Stream.of((Function<DarkSquare, Optional<DarkSquare>>)
				DarkSquare::getTopLeftSquare,
				DarkSquare::getTopRightSquare,
				DarkSquare::getBottomLeftSquare,
				DarkSquare::getBottomRightSquare);
		return directions
				.map(this::getAllSquaresTowards)
				.flatMap(List::stream)
				.map(this::getTurn)
				.toList();
	}

	private Turn getTurn(DarkSquare targetSquare) {
		return new Move(square, targetSquare);
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
