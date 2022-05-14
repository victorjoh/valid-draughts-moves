package valid.draughts.moves;

import java.util.List;

public class AdjacentSquare implements Square {
	private final Direction fromOtherSquare;
	private final Square thisSquare;

	public AdjacentSquare(Direction fromOtherSquare, Square thisSquare) {
		this.fromOtherSquare = fromOtherSquare;
		this.thisSquare = thisSquare;
	}

	@Override
	public List<Turn> endManMove(MoveTurn turnSoFar) {
		return thisSquare.endManMove(turnSoFar);
	}

	@Override
	public List<Turn> jumpOverWithMan(CaptureTurn turnSoFar) {
		return thisSquare.jumpOverWithMan(turnSoFar);
	}

	@Override
	public List<Turn> landCaptureWithMan(CaptureTurn turnSoFar) {
		return thisSquare.landCaptureWithMan(turnSoFar);
	}

	@Override
	public List<Turn> moveKing(MoveTurn turnSoFar) {
		return thisSquare.moveKing(turnSoFar);
	}

	@Override
	public List<Turn> jumpOverWithKing(CaptureTurn turnSoFar) {
		return thisSquare.jumpOverWithKing(turnSoFar);
	}

	@Override
	public List<Turn> landCaptureWithKing(CaptureTurn turnSoFar) {
		return thisSquare.landCaptureWithKing(turnSoFar);
	}

	public Direction getDirection() {
		return fromOtherSquare;
	}
}
