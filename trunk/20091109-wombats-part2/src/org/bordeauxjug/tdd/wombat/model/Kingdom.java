package org.bordeauxjug.tdd.wombat.model;

public enum Kingdom {

	ANIMAL {
		@Override
		public String toString()
		{
			return "Je suis un animal";
		}
	},
	VEGETAL {
		@Override
		public String toString()
		{
			return "Je suis un vegetal";
		}
	},
	MINERAL {
		@Override
		public String toString()
		{
			return "Je suis un mineral";
		}
	}
}
