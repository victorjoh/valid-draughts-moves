package valid.draughts.moves;

import java.util.List;

interface DarkSquareWithMyPiece extends DarkSquare {
	List<Turn> getTurns();
}