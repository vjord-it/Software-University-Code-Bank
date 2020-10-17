package edu.pragmatic;

import java.util.regex.*;

public class Upcase {
	
	public static void main(String[] args) {
		 String text = "The code between <upcase>the two tags</upcase> is <upcase>always</upcase> uppercase";
		 
		 // Use *? to match non-greedy for . (i.e. any character)
		 Pattern pattern = Pattern.compile("<upcase>(.*?)</upcase>");
		 Matcher matcher = pattern.matcher(text);
		 
		 StringBuilder sb = new StringBuilder();
		 int previousGroupEndIndex = 0;
		 while(matcher.find()) {
			 String foundText = matcher.group(1);
			 sb.append(text.substring(previousGroupEndIndex, matcher.start()));
			 sb.append(foundText.toUpperCase());
			 previousGroupEndIndex = matcher.end();
		 }
		 
		 sb.append(text.substring(previousGroupEndIndex));		 
		 System.out.println(sb.toString());
	}
	
}
