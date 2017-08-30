package documents;

import java.util.Comparator;

public abstract class Vignette //implements Comparator<Vignette>{
{
	private final int productionDate;
	private final String color;
	private final int validDays;
	private int price;
	private String type;
	
	Vignette(int productionDate, String color, int validForDays){
		if (productionDate <= 0) {
			this.productionDate = 1;
		}else {
			this.productionDate = productionDate;
		}
		
		this.type = Vignette.checkType(validForDays);
		this.color = color;
		
		if (type.equals("Daily")) {
			this.validDays = 1;
		}else if(type.equals("Weekly")) {
			this.validDays = 31;
		}else {
			this.validDays = 356;
		}
		
		this.price = assignPrice(color, validForDays);
		
	}
	
	public String getType() {
		return this.type;
	}
	private int assignPrice(String color, int days) {
		int price = 0;
		if (color.equalsIgnoreCase("Yellow")) {
			price = 5;
			if(days > 1 && days < 32){
				// Car type - Monthly
				price = (price*7)*10;
			}else if(days > 31) {
				// Car type - Year
				price = (price*7)*10;
				price *= 6;
			}
		}else if(color.equalsIgnoreCase("Blue")){
			price = 9;
			if(days > 1 && days < 32){
				// Bus type - Monthly
				price = (price*7)*10;
			}else if(days > 31){
				// Bus type - Year
				price = (price*7)*10;
				price *= 6;
			}
		}else {// Color - Green
			price = 7;
			if(days > 1 && days < 32){
				// Truck type - Monthly
				price = (price*7)*10;
			}else if(days > 31){
				// Truck type - Year
				price = (price*7)*10;
				price *= 6;
			}
		}
		return price;
	}
	public int getPrice() {
		return this.price;
	}
	
	
//	@Override
//	public int compare(Vignette o1, Vignette o2) {
//		//public int compare(final Vignette o1,Vignette o2) {
//		//TODO	return 1 if o2 should be before o1
//		//		return -1 if o1 should be before o2
//		//		otherwise return 0;
//		if (o1.price < o2.price) {
//			return -1;
//		}else if(o1.price > o2.price) {
//			return 1;
//		}else {
//			return 0;
//		}
//	}

	protected abstract int putOnGlass();
	public abstract String isMadeFor();
	public static String checkType(int validForDays) {
		String type = "";
		if (validForDays <= 1) {
			type = "Daily";
		}else if(validForDays > 1 && validForDays <= 31) {
			type = "Monthly";
		}else {
			type = "Year";
		}
		return type;
	}

	@Override
	public String toString() {
		return "Vignette [color=" + color + "], [price=" + price + "$], [type=" + type + "]";
	}
	
}
