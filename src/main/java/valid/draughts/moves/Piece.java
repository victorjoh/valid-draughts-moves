package valid.draughts.moves;

import java.util.List;

interface Piece {
	List<Move> getMoves();

	void setSquare(DarkSquare square);
}