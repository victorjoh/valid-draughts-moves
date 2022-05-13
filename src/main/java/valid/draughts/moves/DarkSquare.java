package valid.draughts.moves;

interface DarkSquare extends Square {
	void setAdjacentSquare(Direction fromThisSquare, Square adjecentSquare);

	int getX();

	int getY();
}