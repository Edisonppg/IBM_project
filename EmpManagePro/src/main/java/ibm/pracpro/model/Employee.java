package ibm.pracpro.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Employee {
	@Id
	String id;
	
	String name;
	
	double salary;
	
	Integer age;
	
	Date empDate;
	
	String did;

	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Employee(String id, String name, double salary, Integer age, Date empDate, String did) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.age = age;
		this.empDate = empDate;
		this.did = did;
	}


	public Date getEmpDate() {
		return empDate;
	}


	public void setEmpDate(Date empDate) {
		this.empDate = empDate;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}


	public String getDid() {
		return did;
	}

	public void setDid(String did) {
		this.did = did;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", age=" + age + ", empDate=" + empDate
				+ ", did=" + did + "]";
	}

	
	
	
}
