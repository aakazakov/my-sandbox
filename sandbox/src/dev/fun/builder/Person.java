package dev.fun.builder;

public class Person {
	
	private String firstName;
	private String lastName;
	private String middleName;
	private String country;
	private String address;
	private String phone;
	private int age;
	private String gender;
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	public String getMiddleName() {
		return middleName;
	}
	
	public String getCountry() {
		return country;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getPhone() {
		return phone;
	}

	public int getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}
	
	public static class PersonBuilder {
		
		private String firstName;
		private String lastName;
		private String middleName;
		private String country;
		private String address;
		private String phone;
		private int age;
		private String gender;
		
		public PersonBuilder setFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public PersonBuilder setLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public PersonBuilder setMiddleName(String middleName) {
			this.middleName = middleName;
			return this;
		}

		public PersonBuilder setCountry(String country) {
			this.country = country;
			return this;
		}

		public PersonBuilder setAddress(String address) {
			this.address = address;
			return this;
		}

		public PersonBuilder setPhone(String phone) {
			this.phone = phone;
			return this;
		}

		public PersonBuilder setAge(int age) {
			this.age = age;
			return this;
		}

		public PersonBuilder setGender(String gender) {
			this.gender = gender;
			return this;
		}
		
		private PersonBuilder() {
		
		}
		
		public Person build() {
			return new Person(firstName, lastName, middleName, country, address, phone, age, gender);
		}
		
	}
	
	private Person(
			String firstName, 
			String lastName, 
			String middleName, 
			String country, 
			String address, 
			String phone,
			int age, 
			String gender
			) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.country = country;
		this.address = address;
		this.phone = phone;
		this.age = age;
		this.gender = gender;
	}
	
	private Person() {
		
	}

	public static PersonBuilder builder() {
		return new PersonBuilder();
	}

}
