package edu.homework10.task2_registry;

public class Demo {

	public static void main(String[] args) {
		try {
			System.out.println("Registry<Integer>");
			Registry<Integer> intReg = new Registry<>("Integer", 3);
			System.out.println(intReg);
			printRegistry(intReg.getElements());

			boolean added = true;
			for (int i = 0; i < 5 && added; i++) {
				added = intReg.add(i);
				if (!added) {
					System.out.println("Failed to add new element to Registry");
					System.out.println(intReg);
				}
			}

			System.out.print("Object[]: ");
			printRegistry(intReg.getElements());
			System.out.print("<G> G[] : ");
			printRegistry(intReg.getElementsGen());

			intReg.remove(1);
			System.out.println(intReg);
			printRegistry(intReg.getElements());

			intReg.add(99);
			System.out.println(intReg);
			printRegistry(intReg.getElements());

			System.out.println();
			System.out.println("Registry<String>");
			Registry<String> strReg = new Registry<>("String", 3);
			System.out.println(strReg);
			added = true;
			for (int i = 0; i < 5 && added; i++) {
				added = strReg.add("Str" + i);
				if (!added) {
					System.out.println("Failed to add new element to Registry");
					System.out.println(strReg);
				}
			}

			System.out.print("Object[]: ");
			printRegistry(strReg.getElements());
			System.out.print("<G> G[] : ");
			printRegistry(strReg.getElementsGen());

		} catch (RegistryException e) {
			System.out.println(e.getMessage());
		}

	}

	private static <T> void printRegistry(T[] registry) {
		if (registry != null) {
			for (T element : registry) {
				System.out.print(element + "; ");
			}
			System.out.println();
		}
	}
}
