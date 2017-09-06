package utilities;

import java.util.Arrays;

public class TestClass {

	public static void main(String[] args) {
		
		System.out.println("Enter something to test the utilities:");
		String testInput = Utility.SCAN.nextLine();
		System.out.println("You've inserted : " + testInput);
		
		System.out.println("=======================================");
		int test = Utility.RANDOM.nextInt(Integer.MAX_VALUE);
		System.out.println("Testing random(Integer) : " + test);
		
		System.out.println("=======================================");
		String phone = Utility.generatePhone();
		System.out.println("Testing random phone : " + phone);
		
		System.out.println("=======================================");
		String name = Utility.generateName();
		System.out.println("Testing random name : " + name);
	
		System.out.println("=======================================");
		String address = Utility.generateAddress();
		System.out.println("Testing random address : " + address);
		
		System.out.println("=======================================");
		Type type = Utility.getRandomENUM(Type.values());
		System.out.println("Testing random ENUM : " + type);
		
		System.out.println("=======================================");
		char [] pass = Utility.generatePassword();
		System.out.println("Testing random password : " + Arrays.toString(pass));
		
		System.out.println("=======================================");
		String temp = Utility.generateRandomString();
		System.out.println("Testing random word : " + temp);
	}

}
