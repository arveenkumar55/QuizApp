package controller.model;

public class Account {
	
	private String Name;
	private String Password;
	private String Address;
	private String Gender;
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	
	
public Account(String name,String password,String address,String gender)
{
	  Name=name;
	  Password=password;
	  Address=address;
	  Gender=gender;
}

}