package com.revature.beans;

public class MovieGenre {
	private Integer movieId;
	private Integer genreId;
	
	public MovieGenre() {
		super();
	}
	public MovieGenre(Integer movieId, Integer genreId) {
		super();
		this.movieId = movieId;
		this.genreId = genreId;
	}
	public Integer getMovieId() {
		return movieId;
	}
	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
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
		result = prime * result + ((movieId == null) ? 0 : movieId.hashCode());
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
		MovieGenre other = (MovieGenre) obj;
		if (genreId == null) {
			if (other.genreId != null)
				return false;
		} else if (!genreId.equals(other.genreId))
			return false;
		if (movieId == null) {
			if (other.movieId != null)
				return false;
		} else if (!movieId.equals(other.movieId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "MovieGenre [movieId=" + movieId + ", genreId=" + genreId + "]";
	}
	
	
}
