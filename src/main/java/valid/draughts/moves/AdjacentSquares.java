package valid.draughts.moves;

import java.util.Collection;
import java.util.List;
import java.util.function.BiFunction;

class AdjacentSquares {
	private final List<AdjacentSquare> squares;

	AdjacentSquares(List<AdjacentSquare> squares) {
		this.squares = squares;
	}

	AdjacentSquare get(Direction direction) {
		return squares.stream()
				.filter(square -> square.getDirection().equals(direction))
				.findAny()
				.orElseThrow();
	}

	AdjacentSquares add(AdjacentSquare square) {
		return new AdjacentSquares(Lists.concatenate(squares, List.of(square)));
	}

	AdjacentSquares excluding(Direction direction) {
		return new AdjacentSquares(squares.stream()
				.filter(square -> !square.getDirection().equals(direction))
				.toList());
	}
	
	AdjacentSquaresTurnStep map(BiFunction<Square, CaptureTurn, List<Turn>> turnContinuation) {
		return new AdjacentSquaresTurnStep(turnContinuation);
	}

	class AdjacentSquaresTurnStep {
		private final BiFunction<Square, CaptureTurn, List<Turn>> turnContinuation;

		AdjacentSquaresTurnStep(BiFunction<Square, CaptureTurn, List<Turn>> turnContinuation) {
			this.turnContinuation = turnContinuation;
		}

		public List<Turn> withTurnSoFar(CaptureTurn turnLandingOnCenterSquare) {
			return squares.stream()
					.map(square -> turnContinuation.apply(square,
							turnLandingOnCenterSquare.redirect(square.getDirection())))
					.flatMap(Collection::stream)
					.toList();
		}
	}
}
