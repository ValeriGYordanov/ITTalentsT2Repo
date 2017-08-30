package documents;

public class BusVignette extends Vignette {

	private final static String COLOR = "Blue";

	public BusVignette(int productionDate, int validForDays) {
		super(productionDate, BusVignette.COLOR, validForDays);
		String type = "";
		//System.out.println("A "+type+" Bus vignette with: " +BusVignette.COLOR+" is created, Price:"+super.getPrice());
	}

	@Override
	protected int putOnGlass() {
		return 10;
	}

	@Override
	public String isMadeFor() {
		return "Bus";
	}

}
