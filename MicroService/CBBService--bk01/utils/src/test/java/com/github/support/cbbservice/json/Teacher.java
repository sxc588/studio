package com.github.support.cbbservice.json;

public class Teacher
{
	
    private String name;  
    private int age;  
  
    public Teacher() {  
          
    }  
      
    public Teacher(String name, int age) {  
        super();  
        this.name = name;  
        this.age = age;  
    }  
  
    public void setName(String name) {  
        this.name = name;  
    }  
  
    public String getName() {  
        return name;  
    }  
  
    public void setAge(int age) {  
        this.age = age;  
    }  
  
    public int getAge() {  
        return age;  
    }  

}
