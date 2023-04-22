public class Candle {

	public String color;
	public int height;
	public float diameter;
	public boolean isLit;

	public Candle(String color, int height, float diameter) {
		
		this.color = color;
		this.height = height;
		this.diameter = diameter;
		isLit = false;
	}
	
	public void lightCandle() {
		if (isLit == true) {
			System.out.println("The candle is already lit.");
		} else {			
			isLit = true;
		}
	}
	
	public void extinguishCandle() {
		if (isLit == false) {
			System.out.println("The candle is already extinguished.");
		} else {			
			isLit = false;
		}
	}
	
	public void updateHeight(int height) {
		if ((height > this.height) || (height < 0)) {
			System.out.println("The new height must be less than the current height and more than 0.");
		} else {
			this.height = height;
		}
	}

	
	public String toString() {
		
		return "Candle [color = "+color+", height = "+height+", diameter = "+diameter+", isLit = "+isLit+"]";
	
	}
	
	
}
