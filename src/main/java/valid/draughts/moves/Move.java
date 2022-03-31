package valid.draughts.moves;

class Move implements Turn {
	private DarkSquare source;
	private DarkSquare target;

	Move(DarkSquare source, DarkSquare target) {
		this.source = source;
		this.target = target;
	}

	@Override
	public String toString() {
		return source.getId() + "-" + target.getId();
	}
}
