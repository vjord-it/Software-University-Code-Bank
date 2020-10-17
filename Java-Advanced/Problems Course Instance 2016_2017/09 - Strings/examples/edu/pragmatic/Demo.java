package edu.pragmatic;

import java.util.regex.*;

public class Demo {

	public static void main(String[] args) {
		
		//String s1 = "text";
		//String s2 = new String("text");
		
		String s1 = "text";
		String s2 = "text";
		
		if(s1 == s2) {
			System.out.println("equal");
		} else {
			System.out.println("not equal");
		}
		if(s1.equals(s2)) {
			System.out.println("equal");
		} else {
			System.out.println("not equal");
		}
		
		String s3 = new String("abc");
		String s4 = new String("abc");
		
		if(s3 == s4) {
			System.out.println("equal");
		} else {
			System.out.println("not equal");
		}
		
		if(s3.equals(s4)) {
			System.out.println("equals");
		} else {
			System.out.println("not equals");
		}
		
		String firstName = "Chuk";
		String family = "Noris";
		int age = 30;
		String fullName = firstName + " " + family + " age: " + age;
		System.out.println(fullName);
		
		String ageAsString = "" + age;
		System.out.println(ageAsString.length());
		
		String fullName2 = firstName.concat(family);
		
		String listOfBeers = "Amstel  ,Zagorka,      Tuborg, Becks.";
		String[] beers = listOfBeers.split("\\s*,\\s*");
		System.out.println(beers.length);
		for(String beer : beers) {
			System.out.println(beer);
		}
		
		String regex1 = "(02)?[1-9][0-9]{6}";
		String test = "1123456";
		if(test.matches(regex1)) {
			System.out.println("match");
		} else {
			System.out.println("niama match");
		}
		
		String regexNumbers = "[1-9][0-9]*";
		String sms = "Zdrasti 15, nomer e 432432432, ela 232";
		Pattern p = Pattern.compile(regexNumbers);
		Matcher m = p.matcher(sms);
		
		System.out.println("SMS:");
		while(m.find()) {
			int startIndex = m.start();
			int endIndex = m.end();
			
			String number = sms.substring(startIndex, endIndex);
			System.out.println(number);
		}
		
		sms = "sdasssa <begin> dfsdfd <end> cccxc  <begin> drug tekst <end>";
		String regex3 = "<begin>.*?<end>";
		p = Pattern.compile(regex3);
		m = p.matcher(sms);
		
		System.out.println("SMS begin/end:");
		while(m.find()) {
			int startIndex = m.start();
			int endIndex = m.end();
			
			String number = sms.substring(startIndex, endIndex);
			System.out.println(number);
		}
		
		System.out.println(countChars('d', 100));
	}
	
	public static String countChars(char ch, int count) {
		
		StringBuilder builder = new StringBuilder();
		for(int i = 1; i <= count; i++) {
			builder.append(ch);
		}
		
		return builder.toString();
	}
	
}







