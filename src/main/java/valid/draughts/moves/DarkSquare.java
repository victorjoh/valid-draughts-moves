package valid.draughts.moves;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

abstract class DarkSquare implements Square {
	private final Map<Direction, AdjacentSquare> adjacentSquares = new EnumMap<>(Direction.class);
	private final int x;
	private final int y;

	DarkSquare(int x, int y) {
		this.x = x;
		this.y = y;
	}

	AdjacentSquare getAdjacentSquare(Direction direction) {
		return adjacentSquares.get(direction);
	}

	List<AdjacentSquare> getAdjacentSquares() {
		return List.copyOf(adjacentSquares.values());
	}

	void setAdjacentSquare(Direction fromThisSquare, Square adjecentSquare) {
		adjacentSquares.put(fromThisSquare, new AdjacentSquare(fromThisSquare, adjecentSquare));
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