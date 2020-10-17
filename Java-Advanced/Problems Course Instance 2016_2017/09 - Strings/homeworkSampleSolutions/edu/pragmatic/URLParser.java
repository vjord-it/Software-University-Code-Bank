package edu.pragmatic;

import java.util.regex.*;

public class URLParser {
	
	public static class UrlInfo {
		private String protocol;
		private String server;
		private String resources;
		
		public String getProtocol() {
			return protocol;
		}
		public String getServer() {
			return server;
		}
		public String getResources() {
			return resources;
		}
		
		@Override
		public String toString() {
			return String.format("protocol : %s\nserver: %s\nresources: %s", 
					              protocol, server, resources );
		}
	}
	
	public UrlInfo parse(String url) {
		UrlInfo urlInfo = new UrlInfo();
		String http = "http";
		String https = "https";
		String protocol = null;
		if (url.indexOf(http) != -1){
			protocol = http;
		}else if (url.indexOf(https) != -1){
			protocol = https;
		}
		
		String protocolPattern = protocol + "://";
		int serverStartup = url.indexOf(protocolPattern) + protocolPattern.length() ;
		int endOfServer = url.indexOf("/", serverStartup);
		String server = url.substring(serverStartup, endOfServer);
		String resource = url.substring( url.indexOf("/", serverStartup), url.length() );
		urlInfo.server = server;
		urlInfo.protocol = protocol;
		urlInfo.resources = resource;
		return urlInfo;
	}
	
	public UrlInfo parseWithRegEx(String url){
		Pattern pattern = Pattern.compile("(https?)://(\\w+\\.\\w+)(/\\w+[/\\w\\?=&]*)");
		Matcher matcher = pattern.matcher(url);
		if(matcher.find()) {
			UrlInfo urlInfo = new UrlInfo();
			urlInfo.server = matcher.group(2);
			urlInfo.protocol = matcher.group(1);
			urlInfo.resources = matcher.group(3);
			
			return urlInfo;
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		URLParser parser = new URLParser();
		System.out.println(parser.parse("http://google.bg/path/to/resource?arg1=value"));
		System.out.println();
		System.out.println(parser.parseWithRegEx("http://google.bg/path/to/resource?arg1=value"));
	}

}
