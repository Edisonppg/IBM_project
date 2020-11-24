package ibm.pracpro.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;

@Entity
@Table
public class Dept {

	@Id
	String id;

	String deptName;

	@JSONField(format = "yyyy-MM-dd")
	Date creDate;

	public Dept() {
		super();
		// TODO Auto-generated constructor stub
	}

//	public Dept(String id, String deptName, Date creDate) {
//		super();
//		this.id = id;
//		this.deptName = deptName;
//		this.creDate = creDate;
//	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Date getCreDate() {
		return creDate;
	}

	public void setCreDate(Date creDate) {
		this.creDate = creDate;
	}

	@Override
	public String toString() {
		return "Dept [id=" + id + ", deptName=" + deptName + ", creDate=" + creDate + "]";
	}

}
