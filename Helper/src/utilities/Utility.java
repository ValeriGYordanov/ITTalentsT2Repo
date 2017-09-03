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

	
}
