package utilities;

import java.util.Random;
import java.util.Scanner;

public final class Utility {

	public static final Random RANDOM = new Random();
	public static final Scanner SCAN = new Scanner(System.in);
	
	
	public static String generatePhone() {
		String start = "08";
		byte temp = (byte)Utility.RANDOM.nextInt(3);
		if (temp == 0) {
			start += "7";
		}else if(temp == 1) {
			start += "8";
		}else {
			start += "9";
		}
		String end = Integer.toString(Utility.RANDOM.nextInt(8999999)+1000000);
		return start+end;
	}

	
	public static String generateName() {
		String [] names = {"Пешо", "Гошо", "Иван",
							"Тошо","Методи","Мето",
							"Ицо","Петър","Владо",
							"Ники","Крум","Стефан",
							"Пенчо","Гришо","Виктор",
							"Генчо","Наско","Сашо",
							"Кирил","Кольо", "Фики"};
		return names[Utility.RANDOM.nextInt(names.length)];
	}

	public static String generateAddress() {
		String [] address = {"бул. България №","ул. Витоша №","бул. Сливница №","ул. Раковски №","ул. К.Охридски №","бул. Дондуков №",};
		return "гр. "+generateLocalCity()+" "+address[Utility.RANDOM.nextInt(address.length)] +""+Utility.RANDOM.nextInt((30)+1);
	}
	
	public static String generateLocalCity() {
		String [] cities = {"София","Пловдив","Варна",
							"Бургас","Ямбол","Стара Загора",
							"Видин","Перник","Краснодар",
							"Смолян","Асеновград","Несебър",
							"Слънчев Бряг","Китен","Добрич",
							"Плевен","Хасково","Харманли",
							"Дупница","Димитровград","Айтос",
							"Велико Търново","Пазарджик","Каварна"
							};
		return cities [Utility.RANDOM.nextInt(cities.length)];
	}
	/*
	 * public static <T> T randomElement(T[] elements) {
		return elements[rand.nextInt(elements.length)];
		}
		като се извиква така :
		randomElement( <- тук си слагаш името на Enuma -> .values())
	 */
	public static <T> T getRandomENUM(T[] type){
		return type[Utility.RANDOM.nextInt(type.length)];
		
	}
	
}
