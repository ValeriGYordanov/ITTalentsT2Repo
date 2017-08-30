package places;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import documents.BusVignette;
import documents.CarVignette;
import documents.TruckVignette;
import documents.Vignette;
import documents.VignetteComparatorByPrice;
import transport.Vehicles;
import world.World;

public class GasStation {

	private int dailyMoney;
	private ArrayList<Vignette> availableVignettes;
	
	public GasStation(){
		System.out.println("A default Gas-Station with 500 random vignettes is made.");
		this.dailyMoney = 0;
		this.availableVignettes = new ArrayList<>();
		this.generateVignetes();
		this.arrangeVignettes();
	}

	private void generateVignetes() {
		for (int i = 0; i < 500; i++) {
			int chance = World.RANDOM.nextInt(3);
			if (chance == 0) {
				this.availableVignettes.add(new CarVignette(1, World.RANDOM.nextInt(60+1)));
			}
			else if(chance == 1) {
				this.availableVignettes.add(new BusVignette(1, World.RANDOM.nextInt(60+1)));
			}
			else {
				this.availableVignettes.add(new TruckVignette(1, World.RANDOM.nextInt(60+1)));
			}
		}
	}
	private void arrangeVignettes() {
		this.availableVignettes.sort(Comparator.comparing(Vignette::getPrice));
	}
	
	public void printAvailableVignettes() {
		int truckVignettes = 0;
		int truckVignettesPrice = 0;
		int carVignettes = 0;
		int carVignettesPrice = 0;
		int busVignettes = 0;
		int busVignettesPrice = 0;
		for (int i = 0; i < this.availableVignettes.size(); i++) {
			if (this.availableVignettes.get(i) instanceof BusVignette) {
				busVignettes++;
				busVignettesPrice += this.availableVignettes.get(i).getPrice();
			}
			else if(this.availableVignettes.get(i) instanceof CarVignette) {
				carVignettes++;
				carVignettesPrice += this.availableVignettes.get(i).getPrice();
			}else {
				truckVignettes++;
				truckVignettesPrice += this.availableVignettes.get(i).getPrice();
			}
		}
		System.out.println("The "+this.getClass().getSimpleName()+" have in stock:");
		System.out.println(truckVignettes+" - Truck Vignettes, Total Price:"+truckVignettesPrice+"$");
		System.out.println(carVignettes+" - Car Vignettes, Total Price:"+carVignettesPrice+"$");
		System.out.println(busVignettes+" - Bus Vignettes, Total Price:"+busVignettesPrice+"$");
	}
	
	public int askForPrice(int time, String vehicleType) {
		if (time <= 0) {
			System.out.println("Invalid duration inserted!");
			time = 1;
		}
		
		String VignetteType = Vignette.checkType(time);
		int idx = 0;
		
		Vignette c = this.availableVignettes.get(0);
		for (int i = 0; i < this.availableVignettes.size(); i++) {
			c = this.availableVignettes.get(i);
			if (c.getType().equalsIgnoreCase(VignetteType) && c.isMadeFor().equals(vehicleType)) {
				idx = i;
				break;
			}
		}
		
		int temp = this.availableVignettes.get(idx).getPrice();
		return temp;
	}
	public Vignette sellVignette(int time, String vehicleType) {
		if (time <= 0) {
			System.out.println("Invalid duration inserted!");
			time = 1;
		}
		
		String VignetteType = Vignette.checkType(time);
		int idx = 0;
		
		Vignette c = this.availableVignettes.get(0);
		for (int i = 0; i < this.availableVignettes.size(); i++) {
			c = this.availableVignettes.get(i);
			if (c.getType().equalsIgnoreCase(VignetteType) && c.isMadeFor().equals(vehicleType)) {
				idx = i;
				break;
			}
		}
		
		this.dailyMoney += this.availableVignettes.get(idx).getPrice();
		Vignette temp = this.availableVignettes.remove(idx);
		
		return temp;
	}
	
	@Override
	public String toString() {
		return "The Gas-Station is has "+this.availableVignettes.size()+" available vignettes for sale.Daily fortune measures at: "+this.dailyMoney+"$";
	}
}
