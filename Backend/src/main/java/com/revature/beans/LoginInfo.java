package com.revature.beans;

public class LoginInfo {
	private Admin admin;
	private User user;
	
	public LoginInfo() {
		super();
	}
	
	public LoginInfo(Admin admin, User user) {
		super();
		this.admin = admin;
		this.user = user;
	}
	
	
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((admin == null) ? 0 : admin.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginInfo other = (LoginInfo) obj;
		if (admin == null) {
			if (other.admin != null)
				return false;
		} else if (!admin.equals(other.admin))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LoginInfo [user=");
		builder.append(user);
		builder.append(", admin=");
		builder.append(admin);
		builder.append("]");
		return builder.toString();
	}


}
