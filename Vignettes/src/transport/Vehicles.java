package transport;

import documents.Vignette;

public abstract class Vehicles {
	
	private final String model;
	private final int productionYear;
	
	public Vehicles(String model, int productionYear){
		if (model.isEmpty() || model == null) {
			this.model = "Unknown";
		}else {
			this.model = model;
		}
		
		if (productionYear < 1700 && productionYear > 2017) {
			this.productionYear = 2000;
		}else {
			this.productionYear = productionYear;
		}
	}

	
	@Override
	public String toString() {
		return this.model+ " year: "+this.productionYear;
	}


	public abstract void setVignette(Vignette newVignette);
}
