package com.revature.beans;

public class ShowGenre {
	private Integer showId;
	private Integer genreId;
	
	public ShowGenre() {
		super();
	}
	public ShowGenre(Integer showId, Integer genreId) {
		super();
		this.showId = showId;
		this.genreId = genreId;
	}
	public Integer getShowId() {
		return showId;
	}
	public void setShowId(Integer showId) {
		this.showId = showId;
	}
	public Integer getGenreId() {
		return genreId;
	}
	public void setGenreId(Integer genreId) {
		this.genreId = genreId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((genreId == null) ? 0 : genreId.hashCode());
		result = prime * result + ((showId == null) ? 0 : showId.hashCode());
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
		ShowGenre other = (ShowGenre) obj;
		if (genreId == null) {
			if (other.genreId != null)
				return false;
		} else if (!genreId.equals(other.genreId))
			return false;
		if (showId == null) {
			if (other.showId != null)
				return false;
		} else if (!showId.equals(other.showId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ShowGenre [showId=" + showId + ", genreId=" + genreId + "]";
	}
	
	
}
