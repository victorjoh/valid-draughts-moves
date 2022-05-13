package valid.draughts.moves;

import static java.util.Collections.emptyList;

import java.util.List;

class OutOfBoundsSquare implements Square {

	@Override
	public List<Turn> endManMove(MovePath pathSoFar) {
		return emptyList();
	}

	@Override
	public List<Turn> jumpOverWithMan(CapturePath pathSoFar) {
		return emptyList();
	}

	@Override
	public List<Turn> landCaptureWithMan(CapturePath pathSoFar) {
		return emptyList();
	}

	@Override
	public List<Turn> endKingMove(MovePath movePath) {
		return emptyList();
	}
}