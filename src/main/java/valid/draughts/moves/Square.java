package valid.draughts.moves;

import static java.util.Collections.emptyList;

import java.util.List;

interface Square {

	default List<Turn> endManMove(MovePath pathSoFar) {
		return emptyList();
	}

	default List<Turn> jumpOverWithMan(CapturePath pathSoFar) {
		return emptyList();
	}

	default List<Turn> landCaptureWithMan(CapturePath pathSoFar) {
		return emptyList();
	}

	default List<Turn> movePlayerKing(MovePath pathSoFar) {
		return emptyList();
	}
}