package pack1;

import java.io.Serializable;

public class SpaceFactory implements Serializable {

	private String name;

	public SpaceFactory(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
