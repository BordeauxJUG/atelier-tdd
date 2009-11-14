package org.bordeauxjug.tdd.wombat.model;

public enum Kingdom {

	ANIMAL {
		@Override
		public String toString()
		{
			return "Je suis un lapin";
		}
	},
	VEGETAL {
		@Override
		public String toString()
		{
			return "Je suis un végétal";
		}
	},
	MINERAL {
		@Override
		public String toString()
		{
			return "Je suis un minéral";
		}
	}
}
