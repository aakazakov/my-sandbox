package dev.fun.polymorph;

public abstract class Figure {

	protected String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public abstract float area();
	
}
