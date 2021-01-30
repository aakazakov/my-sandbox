package dev.fun.polymorph;

public class Triangle extends Figure {
	
	private float base;
	private float height;
	
	public float getBase() {
		return base;
	}

	public void setBase(float base) {
		this.base = base;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	@Override
	public float area() {
		return base * height / 2;
	}

	public Triangle(float base, float height) {
		this.base = base;
		this.height = height;
	}
	
}
