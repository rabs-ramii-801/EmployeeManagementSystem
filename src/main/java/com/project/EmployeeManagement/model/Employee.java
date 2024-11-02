package com.project.EmployeeManagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee { //Employee table schema

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private String mobile;
    private long salary;

    //getter setter methods for this model class starts here

    public long getId(){    //getter method for id
        return id;
    }
    public void setId(long id){ //setter method for id
        this.id=id;
    }

    public String getName(){   //getter method for name
        return name;
    }

    public void setName(String name){   //setter method for name
        this.name=name;
    }

    public String getEmail(){   //getter method for email
        return email;
    }

    public void setEmail(String email){ //setter method for email
        this.email=email;
    }

    public String getMobile(){  //getter method for mobile
        return mobile;
    }
    public void setMobile(String mobile){   //setter method for mobile
        this.mobile=mobile;
    }

    public long getSalary(){    //getter method for salary
        return salary;
    }
    public void setSalary(long salary){    //setter method for salary
        this.salary=salary;
    }

}
