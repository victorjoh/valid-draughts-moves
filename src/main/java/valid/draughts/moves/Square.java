package valid.draughts.moves;

import java.util.List;

interface Square {
	List<Turn> endManMove(MovePath pathSoFar);

	List<Turn> jumpOverWithMan(CapturePath pathSoFar);

	List<Turn> landCaptureWithMan(CapturePath pathSoFar);

	List<Turn> endKingMove(MovePath movePath);
}