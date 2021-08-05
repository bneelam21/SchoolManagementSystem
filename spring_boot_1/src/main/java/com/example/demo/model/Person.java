package com.example.demo.model;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Person 
{

		private String name;
		private String age;
		private String gender;
		private String address;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAge() {
			return age;
		}
		public void setAge(String age) {
			this.age = age;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public Person(String name, String age, String gender, String address) 
		{
			this.name = name;
			this.age = age;
			this.gender = gender;
			this.address = address;
		}
		public Person()
		{
			
		}

		
		

}
