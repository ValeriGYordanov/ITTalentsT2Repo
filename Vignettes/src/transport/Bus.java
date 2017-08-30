package transport;

import documents.Vignette;

public class Bus extends Vehicles {

	private Vignette vignette;
	
	public Bus(String model, int productionYear) {
		super(model, productionYear);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setVignette(Vignette newVignette) {
		// Moje da se sloji i proverka za validnost (Nqma smisul da se slaga iztekla vinetka)
		if (newVignette == null) {
			return;
		}else {
			this.vignette = newVignette;
		}
	}
	
}


