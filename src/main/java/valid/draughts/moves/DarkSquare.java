package valid.draughts.moves;

import static java.util.Collections.emptyList;

abstract class DarkSquare implements Square {
	private final int x;
	private final int y;
	private AdjacentSquares adjacentSquares;

	DarkSquare(int x, int y) {
		this(x, y, new AdjacentSquares(emptyList()));
	}

	DarkSquare(int x, int y, AdjacentSquares adjacentSquares) {
		this.x = x;
		this.y = y;
		this.adjacentSquares = adjacentSquares;
	}

	AdjacentSquare getAdjacentSquare(Direction direction) {
		return adjacentSquares.get(direction);
	}

	AdjacentSquares getAdjacentSquares() {
		return adjacentSquares;
	}

	void setAdjacentSquare(Direction fromThisSquare, Square adjecentSquare) {
		this.adjacentSquares = adjacentSquares.add(new AdjacentSquare(fromThisSquare, adjecentSquare));
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