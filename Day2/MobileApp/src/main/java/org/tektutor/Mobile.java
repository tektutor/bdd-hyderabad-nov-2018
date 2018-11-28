package org.tektutor;

public class Mobile {
	private ICamera camera;

	public Mobile ( ICamera camera ) {
		this.camera = camera;
	}

	public boolean powerOn() {
		System.out.println ("Mobile PowerOn method");
	
		if ( camera.ON() ) {
			System.out.println ("Camera ON was invoked from Mobile powerOn method ");
			return true;
		}
		
		return false;
	}

	public boolean powerOff() {
		System.out.println ("Mobile PowerOff method");
		return true;
	}
}
