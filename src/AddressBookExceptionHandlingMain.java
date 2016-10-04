
import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookExceptionHandlingMain {
	static Scanner scan = new Scanner(System.in);
	static ArrayList<Contact> Contacts = new ArrayList<Contact>();

	public static void main(String[] args){

		boolean loop = true;

		do {
			printMenu();
			int choice = scan.nextInt();
			scan.nextLine();

			switch (choice){
			case 1: 
				addContact(getUserContact());
				break;
			case 2: 
				System.out.println("Please enter contact's number on list you want to edit: ");
				editContact(getArrayListIndex());
				break;
			case 3: 
				System.out.println("Please enter contact's number on list you want to delete: ");				
				deleteContact(getArrayListIndex());
				break;
			case 4: 
				printContactsList(Contacts);
				break;
			case 5: 
				loop = false;
				break;
			}
		}while (loop == true);
		scan.close();
	}

	public static Contact getUserContact(){
		boolean isValid = false;
		Contact newContact = null;
		while(!isValid){
			System.out.print("Enter Contact name: \n");
			String newName = scan.nextLine();
			System.out.print("Enter Contact email: \n");
			String newEmail = scan.nextLine();
			System.out.print("Enter Contact phone: \n");
			String newPhone = scan.nextLine();
			try {
				newContact = new Contact(newName, newEmail, newPhone);
				isValid = true;
			} catch (InvalidEmailTypeException e) {
				System.out.println(e.getMessage());
				scan.nextLine();
				isValid = false;
			} catch (InvalidPhoneException e) {
				System.out.println(e.getMessage());
				scan.nextLine();
				isValid = false;
			}
		}
		return newContact;
	}

	public static void addContact(Contact newContact){

		Contacts.add(newContact);
	}

	public static void editContact(int index){		
		System.out.println("Please chose what would you like to edit inside " + Contacts.get(index).getName());
		System.out.println("1) for Name, 2) for Email, 3) for Phone Number");
		int choice = scan.nextInt();

		if(choice == 1){
			scan.nextLine();
			System.out.print("please enter new Name: \n");
			String newName = scan.nextLine();
			Contacts.get(index).setName(newName);
		}
		else if(choice == 2){
			boolean isValid = false;
			while (!isValid){
				scan.nextLine();
				System.out.print("please enter new Email: \n");
				String newEmail = scan.nextLine();
				try {
					Contacts.get(index).setEmail(newEmail);
					isValid = true;
				} catch (InvalidEmailTypeException e) {
					System.out.print(e.getMessage());
					isValid = false;
				}
			}
		}
		else {
			boolean isValid = false;
			while (!isValid){
				scan.nextLine();
				System.out.print("please enter new Phone Number: \n");
				String newPhone = scan.nextLine();
				try {
					Contacts.get(index).setPhone(newPhone);
					isValid = true;
				} catch (InvalidPhoneException e) {
					System.out.println(e.getMessage());
					isValid = false;
				}
			}
		}
	}

	public static void deleteContact(int index){
		Contacts.remove(index);
	}

	public static void printContactsList(ArrayList<Contact> Contacts){
		System.out.println("CONTACTS LIST");
		System.out.println("Name\t\tEmail\t\tPhone Number");
		for (int i = 0; i < Contacts.size(); i++) {
			System.out.print(Contacts.get(i).printContact() + "\n");
		}

	}

	public static int getArrayListIndex(){
		int index = scan.nextInt();
		index -= 1; 
		return index;
	}

	public static void printMenu(){
		System.out.println("CONTACT BOOK");
		System.out.print("Please chose from menu\n"
				+ "1 - ADD a new Contact\n"
				+ "2 - EDIT existing Contact\n"
				+ "3 - DELETE existing Contact\n"
				+ "4 - SHOW all Contacts\n"
				+ "5 - QUIT\n");
	}
}
