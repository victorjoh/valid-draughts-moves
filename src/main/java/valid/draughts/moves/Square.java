package valid.draughts.moves;

import static java.util.Collections.emptyList;

import java.util.List;

interface Square {

	default List<Turn> endManMove(MoveTurn pathSoFar) {
		return emptyList();
	}

	default List<Turn> jumpOverWithMan(CaptureTurn pathSoFar) {
		return emptyList();
	}

	default List<Turn> landCaptureWithMan(CaptureTurn pathSoFar) {
		return emptyList();
	}

	default List<Turn> movePlayerKing(MoveTurn pathSoFar) {
		return emptyList();
	}
}