package valid.draughts.moves;

import java.util.List;

interface Piece {
	List<String> getMoves();

	void setSquare(DarkSquare square);
}