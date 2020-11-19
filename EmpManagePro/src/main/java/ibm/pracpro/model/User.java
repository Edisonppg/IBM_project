package ibm.pracpro.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // 自增长主键
	String id;

	String userName;

	String realName;

	String password;

	String sex;

	Integer privilege;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User( String userName, String realName, String password, String sex) {
		super();
		this.userName = userName;
		this.realName = realName;
		this.password = password;
		this.sex = sex;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getPrivilege() {
		return privilege;
	}

	public void setPrivilege(Integer privilege) {
		this.privilege = privilege;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", realName=" + realName + ", password=" + password
				+ ", sex=" + sex + ", privilege=" + privilege + "]";
	}

}
