import java.util.*;
public class sprint1 {
	public static void main(String [] str){
		Scanner sc = new Scanner(System.in);
		ArrayList<Customer> cust = new ArrayList<Customer>(); 
		int option=0;
		while(true){
			start();
		option = sc.nextInt();
		switch(option){
		case 1 : System.out.println("You have selected the Policy Listing Feature."); break;
		case 2 : System.out.println("You have selected the Customer Registration Feature.");register(cust); break;
		case 3 : System.out.println("You have selected the Search Customer by Email Feature.");searchByEmail(cust); break;
		case 4 : System.out.println("You have selected the Search Customer by ID Feature.");searchById(cust);break;
		case 5 : System.out.println("You have selected the View Customers by Email Domain Feature.");searchByDomain(cust);break;
		case 6 : break;
		default : System.out.println("You have selected an inappropriate option. Kindly select an appropriate option.");
		}
		if(option == 6){
			System.out.println("Good Bye Administrator!!. Terminating the Program");
			break;
		}
		}
		
		sc.close();
	}
	public static void start(){
		System.out.println("select your choice by pressing keys mentioned:");
		System.out.println("1. Policy Listing");
		System.out.println("2. Customer Registration");
		System.out.println("3. Search Customer by Email");
		System.out.println("4. Search Customer by CustomerID");
		System.out.println("5. View Customer by Email Domain");
		System.out.println("6. Exit");
	}
	
	
	
	public static void register(ArrayList<Customer> Cust){
		Customer obj = new Customer();
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();		
		
		System.out.print("Enter Customer Name (Max 50 characters): ");
        String customerName = sc.nextLine();
        while (customerName.length() > 50) {
            System.out.print("Name too long. Enter a name with a maximum of 50 characters: ");
            customerName = sc.nextLine();
        }
        obj.setName(customerName);
        
        String Email;
		while(true){
			System.out.print("Enter Email: ");
			Email = sc.nextLine();
			while (!Email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
	            System.out.print("Invalid email format. Enter a valid email: ");
	            Email = sc.nextLine();
	        }
		boolean flag=false;
		for(Customer c : Cust){
			if(c.getEmail().equalsIgnoreCase(Email)) {flag=true;}
		}
		if(flag) {
		System.out.println("Email Already Exist!! Try with another email.");
		continue;
		}
		else{
			break;
		}
		}
		obj.setEmail(Email);
		
		
		while(true){
		System.out.print("Password:");
		String password=sc.nextLine();
		if(password.length()<6 || password.length()>12){
			System.out.println("the length of password must be greater than 5 characters or less than 13 characters");
			continue;
		}
		else{
		obj.setPassword(password);
		break;}
		}
		
		//address
		System.out.print("Address :");
		obj.setAddress(sc.nextLine());
		
		 // Mobile Number
        System.out.print("Enter Mobile Number (Max 10 digits): ");
        String mobileNumber = sc.nextLine();
        while (mobileNumber.length() != 10 || !mobileNumber.matches("\\d+")) {
            System.out.print("Invalid input. Enter a mobile number with exactly 10 digits: ");
            mobileNumber = sc.nextLine();
        }
		obj.setContact( mobileNumber);
		
		System.out.print("Nominee name:");
		obj.setNomineeName(sc.nextLine());
		System.out.print("Nominee's Relationship with Customer:");
		obj.setRelationship(sc.nextLine());
		
		//userID
		long random;
		while(true){
		random = rand.nextInt(10000000);
		boolean flag=false;
		for(Customer c : Cust){
			if(c.getId()==random){
				flag=true;
				break;
			}
		}
		if(flag) continue;
		else
		obj.setId(random);
		break;
		}
		System.out.println("Customer Registration is successful");
		Cust.add(obj);
//		sc.close();
	}
	
	public static void searchByEmail(ArrayList<Customer> Cust){
		Scanner sc = new Scanner(System.in);
		System.out.println("Customers Email:");
		String Email = sc.nextLine();
		
		for(Customer c:Cust){
			if(c.getEmail().equalsIgnoreCase(Email)){
				display(c);
			}
			else{
				System.out.println("No Such Customer Exist with the Given Email.");
			}
			
		}
	}
	
	public static void searchById(ArrayList<Customer> Cust){
		Scanner sc = new Scanner(System.in);
		System.out.println("Customers ID:");
		long ID = sc.nextLong();
		
		for(Customer c:Cust){
			if(c.getId()==ID){
				display(c);
			}
			else{
				System.out.println("No Such Customer Exist with the Given ID.");
			}
			
		}
	}
	
	public static void searchByDomain(ArrayList<Customer> Cust){
		Scanner sc = new Scanner(System.in);
		System.out.println("Customers Email Domain:");
		String Domain = sc.nextLine();
		String domain = Domain;
		ArrayList<Customer> matchingCustomers = new ArrayList<Customer>();
		for(Customer c: Cust){
			String email = c.getEmail();
			String emailDomain = email.substring(email.indexOf("@")+1);
			domain = Domain.substring(Domain.indexOf("@")+1);
			if(emailDomain.equalsIgnoreCase(domain)){
				matchingCustomers.add(c);
			}
		}
		if(matchingCustomers.isEmpty()){
			System.out.println("No such customer is registered with "+domain);
		}else{
			matchingCustomers.sort(Comparator.comparingLong(Customer::getId));
			System.out.println("CustomerID CustomerName CustomerEmail");
			for(Customer c : matchingCustomers){
				System.out.println(c.getId()+ " "+c.getName()+" "+c.getEmail());
			}
		}
		
	}
	
	public static void display(Customer c){
		System.out.println("Customer ID: "+c.getId());
		System.out.println("Customer Name: "+ c.getName());
		System.out.println("Email: "+c.getEmail());
		System.out.println("Password: "+c.getPassword());
		System.out.println("Address: "+c.getAddress());
		System.out.println("Contact: "+c.getContact());
		System.out.println("Nominee name: "+c.getNomineeName());
		System.out.println("Nominee's Relationship with Customer: "+c.getRelationship());
	}
}

class Customer{
	private long id;
	
	private String name;
	private String email;
	private String password;
	private String address;
	private String contact;
	private String nomineeName;
	private String relationship;
	public Customer(long id,  String name, String email, String password, String address, String contact,
			String nomineeName, String relationship) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.address = address;
		this.contact = contact;
		this.nomineeName = nomineeName;
		this.relationship = relationship;
	}
	public Customer(){
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getNomineeName() {
		return nomineeName;
	}
	public void setNomineeName(String nomineeName) {
		this.nomineeName = nomineeName;
	}
	public String getRelationship() {
		return relationship;
	}
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	
	
}