package valid.draughts.moves;

import static java.util.Collections.emptyList;
import static valid.draughts.moves.ListUtil.concatenate;

import java.util.List;
import java.util.stream.Stream;

class MaxTurns {
	private final List<Turn> turns;

	private MaxTurns(List<Turn> turns) {
		this.turns = turns;
	}

	static MaxTurns noTurns() {
		return new MaxTurns(emptyList());
	}

	MaxTurns getTurnsWithMaxNbrOfCaptures(Turn other) {
		return getTurnsWithMaxNbrOfCaptures(new MaxTurns(List.of(other)));
	}

	MaxTurns getTurnsWithMaxNbrOfCaptures(MaxTurns other) {
		int thisNbrOfCaptures = this.getNbrOfCaptures();
		int otherNbrOfCaptures = other.getNbrOfCaptures();
		if (thisNbrOfCaptures > otherNbrOfCaptures) {
			return this;
		} else if (otherNbrOfCaptures > thisNbrOfCaptures) {
			return other;
		} else {
			return new MaxTurns(concatenate(this.turns, other.turns));
		}
	}

	private int getNbrOfCaptures() {
		return this.turns.stream()
				.findAny()
				.map(Turn::getNbrOfCaptures)
				.orElse(0);
	}

	public Stream<Turn> stream() {
		return turns.stream();
	}
}