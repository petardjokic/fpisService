package fon.is.fpis.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum WorkerPosition {
	UNKNOWN("N/A"), WORKER("Worker");

	private final String position;

	public static WorkerPosition findWorkerPostion(String position) {
		for (WorkerPosition p : WorkerPosition.values()) {
			if (p.getPosition().equals(position)) {
				return p;
			}
		}
		return UNKNOWN;
	}

}
