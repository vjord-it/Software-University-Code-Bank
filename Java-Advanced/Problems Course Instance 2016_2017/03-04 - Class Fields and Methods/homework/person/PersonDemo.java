package person;

public class PersonDemo {

	public static void main(String[] args) {
		Person pesho = new Person("Pesho", "Peshev", 30, 170, 90.5d, 'm');
		Person gosho = new Person("Gosho", "Geshev", 32, 190, 80.3d, 'M');

		Person mara = new Person();
		mara.setName("Marijka");
		mara.setAge(27);
		mara.setFamilyName("Markova");
		mara.setHeight(160);
		mara.setWeight(45d);
		mara.setSex('f');

		System.out.println(pesho);
		System.out.println(gosho);
		System.out.println(mara);

		pesho.marry(mara);
		System.out.println(pesho);
		System.out.println(mara);

		gosho.makeFriend(pesho);
		System.out.println(gosho);
		System.out.println(pesho);
		
		Person ivancho = new Person("Ivancho", "Ivanov", 29, 180, 85d, 'M');
		
		pesho.makeFriend(ivancho);
		System.out.println(pesho);
		System.out.println(ivancho);
	}
}
