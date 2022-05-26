package valid.draughts.moves;

import static valid.draughts.moves.Lists.concatenate;

import java.util.List;

class EmptyDarkSquare extends DarkSquare {

	EmptyDarkSquare(int x, int y) {
		super(x, y);
	}

	EmptyDarkSquare(int x, int y, AdjacentSquares adjacentSquares) {
		super(x, y, adjacentSquares);
	}

	@Override
	public List<Turn> endManMove(MoveTurn turnSoFar) {
		return List.of(new MoveTurn(turnSoFar, this));
	}

	@Override
	public List<Turn> landCaptureWithMan(CaptureTurn turnSoFar) {
		CaptureTurn turnLandingHere = turnSoFar.addCheckpoint(this);
		return concatenate(
				List.of(turnLandingHere),
				getAdjacentSquares()
						.continueCapture(Square::jumpOverWithMan)
						.withTurnSoFar(turnLandingHere));
	}

	@Override
	public List<Turn> moveKing(MoveTurn turnSoFar) {
		MoveTurn turnLandingHere = new MoveTurn(turnSoFar, this);
		return concatenate(
				List.of(turnLandingHere),
				getAdjacentSquare(turnSoFar.getDirection()).moveKing(turnSoFar));
	}

	@Override
	public List<Turn> jumpOverWithKing(CaptureTurn turnSoFar) {
		return getAdjacentSquare(turnSoFar.getDirection()).jumpOverWithKing(turnSoFar);
	}

	@Override
	public List<Turn> landCaptureWithKing(CaptureTurn turnSoFar) {
		CaptureTurn turnLandingHere = turnSoFar.addCheckpoint(this);
		return concatenate(
				List.of(turnLandingHere),
				getAdjacentSquare(turnSoFar.getDirection()).landCaptureWithKing(turnSoFar),
				getAdjacentSquares()
						.continueCapture(Square::jumpOverWithKing)
						.withTurnSoFar(turnLandingHere));
	}
}