package com.revature.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="login")
@Inheritance(strategy=InheritanceType.JOINED)
public class User 
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="login")
	@SequenceGenerator(name="login", sequenceName="login_seq", allocationSize=1)
	private Integer id;
	public User(Integer id) {
		super();
		this.id = id;
	}

	private String username;
	private String password;
	private String email;
	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(
	        name = "FRIENDS",
	        joinColumns = @JoinColumn(name = "USERID"),
	        inverseJoinColumns = @JoinColumn(name = "FRIENDID")
	)
	
	private List<User> friends;

	
	public User() 
	{
		super();
		this.friends = new ArrayList<>();
	}
	
	public User(Integer id, String username, String password, String email) 
	{
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.friends = new ArrayList<>();
	}
	
	public Integer getId() 
	{
		return id;
	}
	
	public void setId(Integer id) 
	{
		this.id = id;
	}
	
	public String getUsername() 
	{
		return username;
	}
	
	public void setUsername(String username) 
	{
		this.username = username;
	}
	
	public String getPassword() 
	{
		return password;
	}
	
	public void setPassword(String password) 
	{
		this.password = password;
	}
	
	public String getEmail() 
	{
		return email;
	}
	
	public void setEmail(String email) 
	{
		this.email = email;
	}
	
	public List<User> getFriends() {
		return friends;
	}

	public void setFriends(List<User> friends) {
		this.friends = friends;
	}

	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) 
		{
			if (other.email != null)
				return false;
		} 
		else if (!email.equals(other.email))
			return false;
		if (id == null) 
		{
			if (other.id != null)
				return false;
		} 
		else if (!id.equals(other.id))
			return false;
		if (password == null) 
		{
			if (other.password != null)
				return false;
		} 
		else if (!password.equals(other.password))
			return false;
		if (username == null) 
		{
			if (other.username != null)
				return false;
		} 
		else if (!username.equals(other.username))
			return false;
		return true;
	}

//	@Override
//	public String toString() 
//	{
//		return "User [id=" + id + ", username=" + username + ", email=" + email + "]";
//	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", friends=" + friends + "]";
	}
	
}



//package com.revature.beans;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Inheritance;
//import javax.persistence.InheritanceType;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
//import javax.persistence.SequenceGenerator;
//import javax.persistence.Table;
//
//@Entity
//@Table(name="login")
//@Inheritance(strategy=InheritanceType.JOINED)
//public class User 
//{
//	@Id
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="login")
//	@SequenceGenerator(name="login", sequenceName="login_seq", allocationSize=1)
//	private Integer id;
//	public User(Integer id) {
//		super();
//		this.id = id;
//	}
//
//	private String username;
//	private String password;
//	private String email;
//	
////	@JoinTable(
////	        name = "FRIENDS",
////	        joinColumns = @JoinColumn(name = "USERID"),
////	        inverseJoinColumns = @JoinColumn(name = "FRIENDID")
////	)
////	@ManyToMany(fetch=FetchType.LAZY)
////	private List<User> friends;
//	
//	public User() 
//	{
//		super();
//		//this.friends = new ArrayList<>();
//	}
//	
//	public User(Integer id, String username, String password, String email) 
//	{
//		super();
//		this.id = id;
//		this.username = username;
//		this.password = password;
//		this.email = email;
//		//this.friends = new ArrayList<>();
//	}
//	
//	public Integer getId() 
//	{
//		return id;
//	}
//	
//	public void setId(Integer id) 
//	{
//		this.id = id;
//	}
//	
//	public String getUsername() 
//	{
//		return username;
//	}
//	
//	public void setUsername(String username) 
//	{
//		this.username = username;
//	}
//	
//	public String getPassword() 
//	{
//		return password;
//	}
//	
//	public void setPassword(String password) 
//	{
//		this.password = password;
//	}
//	
//	public String getEmail() 
//	{
//		return email;
//	}
//	
//	public void setEmail(String email) 
//	{
//		this.email = email;
//	}
//	
////	public List<User> getFriends() {
////		return friends;
////	}
////
////	public void setFriends(List<User> friends) {
////		this.friends = friends;
////	}
//
//	@Override
//	public int hashCode() 
//	{
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((email == null) ? 0 : email.hashCode());
//		result = prime * result + ((id == null) ? 0 : id.hashCode());
//		result = prime * result + ((password == null) ? 0 : password.hashCode());
//		result = prime * result + ((username == null) ? 0 : username.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) 
//	{
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		User other = (User) obj;
//		if (email == null) 
//		{
//			if (other.email != null)
//				return false;
//		} 
//		else if (!email.equals(other.email))
//			return false;
//		if (id == null) 
//		{
//			if (other.id != null)
//				return false;
//		} 
//		else if (!id.equals(other.id))
//			return false;
//		if (password == null) 
//		{
//			if (other.password != null)
//				return false;
//		} 
//		else if (!password.equals(other.password))
//			return false;
//		if (username == null) 
//		{
//			if (other.username != null)
//				return false;
//		} 
//		else if (!username.equals(other.username))
//			return false;
//		return true;
//	}
//
//	@Override
//	public String toString() 
//	{
//		return "User [id=" + id + ", username=" + username + ", email=" + email + "]";
//	}
//}