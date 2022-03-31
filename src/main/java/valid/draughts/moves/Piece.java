package valid.draughts.moves;

import java.util.List;

interface Piece {
	List<Turn> getPossibleTurns();

	void setSquare(DarkSquare square);
}