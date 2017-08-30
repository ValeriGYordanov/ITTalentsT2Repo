package person;

import transport.Vehicles;
import world.World;

import java.util.ArrayList;

import places.GasStation;

public class Driver {

	private String name;
	private ArrayList<Vehicles> vehicles;
	private int money;
	private GasStation gasStation;
	
	public Driver(String name, int money, GasStation gasStation){
		this.setName(name);
		this.setMoney(money);
		this.setGasStation(gasStation);
		this.vehicles = new ArrayList<>();
	}

	private void setGasStation(GasStation gasStation) {
		if (gasStation == null) {
			return;
		} else {
			this.gasStation = gasStation;
		}
	}
	private void setMoney(int money) {
		if (money <= 0) {
			this.money = 300;
		} else {
			this.money = money;
		}
	}
	private void setName(String name) {
		if (name.isEmpty() || name == null) {
			this.name = "Phantom Driver";
		}else {
			this.name = name;
		}
	}
	
	public void assignVehicle(Vehicles vehicle) {
		if (vehicle == null) {
			return;
		} else {
			this.vehicles.add(vehicle);
		}
		System.out.println(this.name + " Has been assigned with " +vehicle.toString());
	}
	
	
	/*
	 * Може да закупува винетки за всички автомобили за които отговаря.
	 */
	public void buyVignetesForAllVehicles() {
		this.buyVignetesForAllVehicles(true);
	}
	private void buyVignetesForAllVehicles(boolean enoughMoney) {
			for (int i = 0; i < this.vehicles.size(); i++) {
				if (enoughMoney) {
					enoughMoney = this.buyVignette(i, World.RANDOM.nextInt(60+1));
				}else {
					return;
				}
		}
		
	}
	/*
	 * може да закупува винетки и за определен автомобил под индекс и за определен период.
	 */
	public boolean buyVignette(int idx, int validForDays) {
		if (idx > this.vehicles.size() || idx < 0) {
			System.out.println("Invalid index for vehicle");
			return false;
		}
		
		String c = this.vehicles.get(idx).getClass().getSimpleName();
		int priceForVignette = this.gasStation.askForPrice(validForDays, c);
		
		if (this.money >= priceForVignette) {
			//Когато купува винетка той се обръща към неговата gasStation.
			this.vehicles.get(idx).setVignette(this.gasStation.sellVignette(validForDays, c));
			//метода на закупуване да намалява парите му и да увеличава дневните на бензиностанцията.
			this.money-=priceForVignette;
			System.out.println(this.name + " has bought vignette for "+this.vehicles.get(idx).toString());
			System.out.println("For "+priceForVignette+"$ "+this.name+" is left with "+this.money+"$");
			return true;
		}else {
			System.out.println("Not enough money!");
			return false;
		}
		
	}
	/* 
	 * По зададен ден месец и година да връша всички автомобили с изтекли винетки
	 */

	
}
