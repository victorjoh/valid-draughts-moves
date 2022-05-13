package valid.draughts.moves;

class Turn {
	private final Path path;

	public Turn(Path path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return path.toString();
	}
}