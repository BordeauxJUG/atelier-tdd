package org.jug.tdd.model;

import java.util.List;

public interface ISensor {

	List<IPrey> getPreysInTheVicinityOf(Coordinates c);
}
