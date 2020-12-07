package dev.fun.recursion;

public class Thing {
	
	private int volume;
	private int value;
	private String title;
	
	public int getVolume() {
		return volume;
	}
	
	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public Thing(int volume, int value, String title) {
		this.volume = volume;
		this.value = value;
		this.title = title;
	}
	
	public Thing() {
		
	}

	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + value;
		result = 31 * result + volume;
		result = 31 * result + title.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}		
		Thing thing = (Thing) obj;		
		return 
				thing.getValue() == this.value 
				&& thing.getVolume() == this.volume 
				&& thing.getTitle().equals(this.title);
	}
	
	@Override
	public String toString() {
		return String.format("{title: %s, volume: %d, value: %d}", title, volume, value);
	}
}
