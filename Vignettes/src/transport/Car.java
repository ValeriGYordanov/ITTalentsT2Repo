package transport;

import documents.Vignette;

public class Car extends Vehicles {


	private Vignette vignette;
	
	public Car(String model, int productionYear) {
		super(model, productionYear);
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
