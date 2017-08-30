package documents;

public class CarVignette extends Vignette {

	private final static String COLOR = "Yellow";
	
	
	
	public CarVignette(int productionDate, int validForDays) {
		super(productionDate, CarVignette.COLOR, validForDays);
		String type = "";
		//System.out.println("A "+type+" Car vignette with: " +CarVignette.COLOR+" color is created, Price:"+super.getPrice());
		
	}

	@Override
	protected int putOnGlass() {
		return 5;
	}

	@Override
	public String isMadeFor() {
		return "Car";
	}



}
