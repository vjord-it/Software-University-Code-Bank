package bg.pragmatic.homework.io.serialization;

import java.io.*;
import java.util.*;

public class ClientDemo {
	public static void serialize(List<Client> list, String fileName) throws FileNotFoundException, IOException {
		try(FileOutputStream outputStream = new FileOutputStream(fileName);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);) {
			
			objectOutputStream.writeObject(list);
		}
	}
	
	@SuppressWarnings("unchecked")
	public static List<Client> deserialize(String fileName)
			throws FileNotFoundException, IOException, ClassNotFoundException {
		try(FileInputStream inputStream = new FileInputStream(fileName);
			ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);) {
			
			return (List<Client>)objectInputStream.readObject();
		}
	}
	
	public static void main(String[] args) 
			throws FileNotFoundException, ClassNotFoundException, IOException {
		List<Client> clients = new ArrayList<>();
		clients.add(new Client(1234, "Name1", "ASD", "0899123456789", "name1@test.com", "address1"));
		clients.add(new Client(1357, "Name2", "qwerty", "0899111111", "name2@test.com", "address2"));
		clients.add(new Client(1123, "Name3", "GUID", "0899987654321", "name3@test.com", "address3"));
		
		System.out.println("Clients size: " + clients.size()); // 3
		
		serialize(clients, "clients.dat");
		
		clients.clear();
		
		System.out.println("Clients size: " + clients.size()); // 0
		
		clients = deserialize("clients.dat");
		
		System.out.println("Clients size: " + clients.size()); // 3
	}
}
