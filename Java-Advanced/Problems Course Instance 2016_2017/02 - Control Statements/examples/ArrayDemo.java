
public class ArrayDemo {

	public static void main(String[] args) {
		
		int[] arr = new int[5];
		arr[1]++;
		System.out.println(arr[1]);
		
		//System.out.println(arr[15]);
		
		System.out.println("all elements:");
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		
		// Masiv s 2 elementa
		float[] f = { 1.2f, 3.4f };
		
		System.out.println("for-each");
		
		for(int element : arr) {
			System.out.println(element);
		}
		
		arr[0] = 9;
		arr[1] = 4;
		arr[2] = -3;
		arr[3] = 10;
		arr[4] = 12;
		
		for(int elem : arr) {
			if(elem > 0) {
				System.out.println(elem);
			}
		}
		
		System.out.println("with break");
		for(int elem : arr) {
			if(elem > 0) {
				System.out.println(elem);
			} else {
				break;
			}
		}
	}
}
