package valid.draughts.moves;

enum Direction {
	FORWARD_LEFT,
	FORWARD_RIGHT,
	BACKWARD_LEFT,
	BACKWARD_RIGHT;

	Direction getOpposite() {
		switch (this) {
			case FORWARD_LEFT:
				return BACKWARD_RIGHT;
			case FORWARD_RIGHT:
				return BACKWARD_LEFT;
			case BACKWARD_LEFT:
				return FORWARD_RIGHT;
			case BACKWARD_RIGHT:
			default:
				return FORWARD_LEFT;
		}
	}
}