package com.revature.data;

import com.revature.beans.Admin;

public interface AdminDAO {
	
	
	public Admin getAdmin(Admin a);
	
	public Admin getAdmin(String u, String p);

}
