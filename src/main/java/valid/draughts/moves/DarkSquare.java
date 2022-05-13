package valid.draughts.moves;

import java.util.EnumMap;
import java.util.Map;

abstract class DarkSquare implements Square {
	protected final Map<Direction, Square> adjacentSquares;
	private final int x;
	private final int y;

	DarkSquare(int x, int y) {
		adjacentSquares = new EnumMap<>(Direction.class);
		this.x = x;
		this.y = y;
	}

	void setAdjacentSquare(Direction fromThisSquare, Square adjecentSquare) {
		adjacentSquares.put(fromThisSquare, adjecentSquare);
	}

	int getX() {
		return x;
	}

	int getY() {
		return y;
	}

	String getId() {
		return "" + x + y;
	}
}