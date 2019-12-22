package model;

public class Coach {
   private int id;
   private String name;
   private int sex;
   private int age;
   private String phone;
   private String teach;
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
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getTeach() {
	return teach;
}
public void setTeach(String teach) {
	this.teach = teach;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
@Override
public String toString() {
	return "Coach [id=" + id + ", name=" + name + ", sex=" + sex + ", age=" + age + ", phone=" + phone + ", teach="
			+ teach + "]";
}
  
   
}
