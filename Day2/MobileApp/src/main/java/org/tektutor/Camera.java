package org.tektutor;

public class Camera implements ICamera {

	public boolean ON() {
		System.out.println ("Camera Powered ON ...");
		return true;
	}

	public boolean OFF() {
		System.out.println ("Camera Powered OFF ...");
		return true;
	}

}
