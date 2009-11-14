package org.bordeauxjug.tdd.wombat.model;

import java.util.List;

public interface ISensor {

	List<IPrey> getPreysInTheVicinityOf(Coordinates c);
}
