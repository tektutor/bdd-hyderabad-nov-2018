package org.tektutor;

public class Training {

	private int id;
	private String name;
	private String duration;

	public Training() {
		id = 0;
	}

	public void setId( int id ) {
		this.id = id;
	}

	public void setName( String name ) {
		this.name = name;
	}

	public void setDuration ( String duration ) {
		this.duration = duration;
	}

	public int getId( ) {
		return id;
	}

	public String getName( ) {
		return name;
	}

	public String getDuration( ) {
		return duration;
	}
	
}
