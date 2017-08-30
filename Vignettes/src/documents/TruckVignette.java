package documents;

public class TruckVignette extends Vignette {

	private final static String COLOR = "Green";
	
	public TruckVignette(int productionDate, int validForDays) {
		super(productionDate, TruckVignette.COLOR, validForDays);
		String type = "";
		//System.out.println("A "+type+" Truck vignette with: " +TruckVignette.COLOR+" is created, Price:"+super.getPrice());
	}

	@Override
	protected int putOnGlass() {
		return 20;
	}

	@Override
	public String isMadeFor() {
		return "Truck";
	}
	
	

}
