package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="USERFRIENDS")

public class Friends { 
//	@Id
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="friends")
//	@SequenceGenerator(name="friend", sequenceName="userFriend_seq", allocationSize=1)
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="f")
	@SequenceGenerator(name="f", sequenceName="f_seq", allocationSize=1)

	private Integer id;
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="friendName")
	private String friendName;
	
	public Friends() {
		super();
	}

	public Friends(Integer id, String friendName) {
		super();
		this.id = id;
		this.friendName = friendName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFriendName() {
		return friendName;
	}

	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((friendName == null) ? 0 : friendName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Friends other = (Friends) obj;
		if (friendName == null) {
			if (other.friendName != null)
				return false;
		} else if (!friendName.equals(other.friendName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Friends [id=" + id + ", friendName=" + friendName + "]";
	}
	
}
