package dev.fun.polymorph;

public class Circle extends Figure {
	
	private static final float PI = 3.14f;
	
	private float radius;
	
	public float getRadius() {
		return radius;
	}

	public void setRadius(float radius) {
		this.radius = radius;
	}

	public Circle(float radius) {
		this.radius = radius;
	}

	@Override
	public float area() {
		return PI * radius * radius;
	}

}
