package pack1;

import java.io.Serializable;

public class Color implements Serializable {

	private String colorName;
	private int colorIntensity;

	public Color(String name, int intensity) {
		colorName = name;
		colorIntensity = intensity;
	}

}
