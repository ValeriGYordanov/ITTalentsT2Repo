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
		String end = Integer.toString(Utility.RANDOM.nextInt(8999999)+7000000);
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
	
	//Call This : Utility.getRandomEnum(<-Your Enum name -> .values())
	public static <T> T getRandomENUM(T[] type){
		return type[Utility.RANDOM.nextInt(type.length)];
		
	}
	
	public static String generateRandomString() {
		String [] randomWord = {"text","cafemachine","copier","ashtray","cupofjuice","cigarette","lighter",
				"dog","laptop","personalcomputer","keyboard","mousepad","mouse","door","glass","lamp","movie","television","horror",
				"sandals","shoes","cover","element","sound","wooden","shield","zombie","skype","meeting","refuse","defuse","relation","progress"};
		return randomWord[Utility.RANDOM.nextInt(randomWord.length)];
	}
	
	public static char[] generatePassword() {
		char [] password = new char[Utility.RANDOM.nextInt(10)+6];
		for (int i = 0; i < password.length; i++) {
			boolean nextIsDigit = Utility.RANDOM.nextBoolean();
			if (nextIsDigit) {
				password[i] = (char) ((char)Utility.RANDOM.nextInt(10)+49);
			}else {
				password[i] = (char)((char)Utility.RANDOM.nextInt(25)+97);
			}
		}
		return password;
	}
}
