package world;

import java.util.Random;
import java.util.Scanner;

import person.Driver;
import places.GasStation;
import transport.Bus;
import transport.Car;
import transport.Truck;
import transport.Vehicles;

public class World {
	
	public static final Random RANDOM = new Random();
	public static final Scanner SC = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Welcome to the Vignette selling production...DhA!");
		System.out.println("Press enter to create a Gasstation...");
		SC.nextLine();
		GasStation Lukoil = new GasStation();
		Driver driver = new Driver("Default", 20000, Lukoil);
		System.out.println("Do you want to print the available Vignettes? [Type] - y/n");
		char createVig = SC.next().charAt(0);
		if (createVig == 'y') {
			Lukoil.printAvailableVignettes();
		}
		while(true) {
			System.out.println("What else do you want to do?");
			System.out.println("1. To create a driver, type [1].");
			System.out.println("2. To create a car, type [2].");
			int temp = SC.nextInt();
			SC.nextLine();
			if (temp == 1) {// Create driver, must be outside check down
				System.out.println("You chose to create driver...");
				System.out.println("Type the driver's Name:");
				String driverName = SC.nextLine();
				int money = 0; 
				while(money <= 0) {
					System.out.println("Type "+ driverName +"'s starting money:");						
					money = SC.nextInt();
				}
				System.out.println("Driver "+driverName + " with capital of "+money+"$ is created and assigned with Lukoil GasStation");
				driver = new Driver("Pesho", 20000, Lukoil);
				System.out.println("_______________________________________________________________________________________________________");
				System.out.println("Do you want to continue? y/n");
				char cont = SC.next().charAt(0);
				if (cont == 'y') {
					continue;
				}else {
					break;
				}
				}
				else if(temp == 2) {
					System.out.println("You chose to create car...");
					int carQuantity = 0;
					while(carQuantity <= 0) {
						System.out.println("How much cars you want to create?");
						System.out.println("Type quantity (Bigger than 0):");
						carQuantity = SC.nextInt();
					}
					System.out.println("A garage with "+carQuantity+" cars is created!");
					Vehicles [] autos = new Vehicles [carQuantity];
					System.out.println("Do you want to make your custom cars or leave the garage with the default ones?");
					System.out.println("Type c/d (Custom/Default)");
					char type = SC.next().charAt(0);
					if (type == 'd') {
						System.out.println("Default cars are being created...");
						autos = createVehicles(autos.length);
					}
					else {
						//TODO za custom cars....
						System.out.println("You choose to create custom cars");
					}
					break;
				}
			}
		System.out.println("I'll be back!");
		//TODO Continue some story
		
		
		
}

	private static Vehicles [] createVehicles(int quantity) {
		Vehicles [] volkswagenGroup = new Vehicles[quantity];
		for (int i = 0; i < volkswagenGroup.length; i++) {
			int chance = World.RANDOM.nextInt(3+1);
			if (chance == 1) {
				volkswagenGroup[i] = new Car(modelGenerator(chance), World.RANDOM.nextInt(18)+1999);
			}else if(chance == 2) {
				volkswagenGroup[i] = new Bus(modelGenerator(chance), World.RANDOM.nextInt(37)+1980);
			}else{
				volkswagenGroup[i] = new Truck(modelGenerator(chance), World.RANDOM.nextInt(67)+1950);
			}
		}
		return volkswagenGroup;
	}

	private static String modelGenerator(int chance) {
		if (chance == 1) {
			String [] carModels = {"Golf", "Passat", "EOS", "Phaeton", "Polo", "Lupo"};
			return carModels[World.RANDOM.nextInt(carModels.length)];
		}else if(chance == 2) {
			String [] busModels = {"LT", "Transporter", "T1", "T2", "T3"};
			return busModels[World.RANDOM.nextInt(busModels.length)];
		}else{
			String [] truckModels = {"MAN-TD3500", "MAN-D8890", "MAN-Unlim", "MAN"};
			return truckModels[World.RANDOM.nextInt(truckModels.length)];
		}
	}
}
