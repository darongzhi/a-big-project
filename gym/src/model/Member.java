package model;

import java.sql.Date;

public class Member {
   private int id;
   private String name;
   private int sex;
   private int age;
   private String phone;
   private String email;
   private String address;
   private Date starts;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getSex() {
	return sex;
}
public void setSex(int sex) {
	this.sex = sex;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public Date getStarts() {
	return starts;
}
public void setStarts(Date starts) {
	this.starts = starts;
}
@Override
public String toString() {
	return "Member [id=" + id + ", name=" + name + ", sex=" + sex + ", age=" + age + ", phone=" + phone + ", email="
			+ email + ", address=" + address + ", starts=" + starts + "]";
}



   
   
}
