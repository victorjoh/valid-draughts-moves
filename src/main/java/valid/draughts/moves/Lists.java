package valid.draughts.moves;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

class Lists {

	private Lists() {
		throw new IllegalStateException("Utility class");
	}

	@SafeVarargs
	static <T> List<T> concatenate(List<T>... lists) {
		return Stream.of(lists)
				.flatMap(Collection::stream)
				.toList();
	}

	static <T> List<T> reverse(List<T> list) {
		List<T> newList = new ArrayList<>(list);
		Collections.reverse(newList);
		return newList;
	}
}
