
public class Demo {

	public static void main(String[] args) {
		
		Person pesho = new Person();
		Person gosho = new Person();
		
		// sravniava dali 2-te referencii sochat kym edin i sysht obekt
		if (pesho == gosho) {
			System.out.println("same");
		} else {
			System.out.println("not same");
		}
		
		
		pesho.age = 20;
		System.out.println(pesho.age);
		System.out.println(gosho.age);
		
		// 'pesho' shte sochi kym syshtiat obekt, kakto i 'gosho'
		pesho = gosho;
		System.out.println(pesho.age);
		gosho.isFemale = true;
		System.out.println(pesho.isFemale);
		Person x = gosho;
		System.out.println(x.isFemale);
		
		if (pesho == gosho) {
			System.out.println("same");
		} else {
			System.out.println("not same");
		}
		
//		pesho = null;
//		
//		if(pesho != null) {
//			pesho.hasCar = true;
//		}
				
		////////
		
		Car bmw = new Car();
		bmw.owner = gosho;
		gosho = null;
		System.out.println(bmw.owner.age);
		
		Car audi = new Car();
		//System.out.println(audi.owner.age);
		System.out.println(audi.owner);
	}
}
