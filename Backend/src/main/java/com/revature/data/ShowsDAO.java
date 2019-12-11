package com.revature.data;

import com.revature.beans.Shows;

public interface ShowsDAO {
	/**
	 * Returns the id of a Show object inserted into the database.
	 * 
	 * @param Show the Show object to be inserted
	 * @return the id of the Show object inserted
	 */
public int addShow(Shows mov);
	
	/**
	 * returns a Show object
	 * 
	 * @param name the name of the Show
	 * @return the Show from the database.
	 */	
	public Shows getShow(String name);
	/**
	 * returns a Show object from the database
	 * 
	 * @param Show previously created Show object
	 * @return the Show from the database that matches the name, director, and year
	 */
	public Shows getShow(Shows mov);
	/**
	 * returns a Show object from the database
	 * 
	 * @param u previously created Show object for updating with Show information
	 * @return the Show from the database that matches the name, director, and year
	 */
	public Shows getShowById(Shows mov);
	
	
	/**
	 * updates a Show in the database
	 * 
	 * @param Shows the Shows to be updated
	 */
	public void updateShow(Shows mov);
}
