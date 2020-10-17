package edu.pragmatic;

public class NumberConcatinater {
	
	public String slowConcat(long num){
		String str = "";
		for (int i = 0 ; i < num ; i++){
			//System.out.println(i);
			str += i;
		}
			
		return str;
	}
	
	public String quickConcat(long num){
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < num ; i++ ){
			//System.out.println(i);
			sb.append(i);
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		NumberConcatinater concatinater = new NumberConcatinater();
		long start = System.currentTimeMillis();
		concatinater.slowConcat(100_000L);
		long end = System.currentTimeMillis();
		long slowTime = end - start;
		
		start = System.currentTimeMillis();
		concatinater.quickConcat(100_000L);
		end = System.currentTimeMillis();
		long quickTime = end - start;

		System.out.println("Quick concat (ms): " + quickTime);
		System.out.println("Slow concat (ms): " + slowTime);
	}

}
