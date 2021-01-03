package fr.uga.miage.pc.interfaces;

public enum Comportement {

	/**
	 * enum of possible behaviors of the prisoners and method calculating the number
	 * of points after their confrontation
	*/
	COOPERER {
		@Override
		public int confront(Comportement comportement) {
			switch (comportement) {
			case COOPERER:
				return 3;
			case TRAHIR:
				return 0;
			case RENONCER:
				return 2;
			default:
				throw new IllegalArgumentException(comportement + "is not a valid argument");
			}
		}
	},
	TRAHIR {
		@Override
		public int confront(Comportement comportement) {
			switch (comportement) {
			case COOPERER:
				return 5;
			case TRAHIR:
				return 1;
			case RENONCER:
				return 2;
			default:
				throw new IllegalArgumentException(comportement + "is not a valid argument");
			}
		}
	},
	RENONCER {
		@Override
		public int confront(Comportement comportement) {
			return 2;
		}
	};

	/*
	 * abstract method of calculation points after confrontation of two strategies
	 */
	public abstract int confront(Comportement comportement);
}