package valid.draughts.moves;

import static java.util.Collections.emptyList;

import java.util.List;

interface Square {

	default List<Turn> endManMove(MoveTurn turnSoFar) {
		return emptyList();
	}

	default List<Turn> jumpOverWithMan(CaptureTurn turnSoFar) {
		return emptyList();
	}

	default List<Turn> landCaptureWithMan(CaptureTurn turnSoFar) {
		return emptyList();
	}

	default List<Turn> moveKing(MoveTurn turnSoFar) {
		return emptyList();
	}

	default List<Turn> jumpOverWithKing(CaptureTurn turnSoFar) {
		return emptyList();
	}

	default List<Turn> landCaptureWithKing(CaptureTurn turnSoFar) {
		return emptyList();
	}
}