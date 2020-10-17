package edu.homework09.url;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrlAnalyzer {

	public static void main(String[] args) {
		String text = "hghg:// hg://http://www.google.com/path/to/resource?arg=1 hg://ewrewr? weeee://ererew/werewr ftp://abv.bg/mail/storage   ";
		String regex = "(?<fullMatch>(?<protocol>[a-zA-Z]+?)://(?!\\.)(?<server>([^/\\s:.]+\\.[^/\\s:.]+)+)(?<resource>/[^?:\\s]+))";

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(text);

		while (matcher.find()) {
			System.out.println("Full match = " + matcher.group("fullMatch"));
			System.out.println("Protocol = " + matcher.group("protocol"));
			System.out.println("Server = " + matcher.group("server"));
			System.out.println("Resource = " + matcher.group("resource"));
			System.out.println();
		}
	}

}
