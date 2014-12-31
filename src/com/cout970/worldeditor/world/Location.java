package com.cout970.worldeditor.world;

import com.google.gson.annotations.Expose;

public class Location {

	@Expose public double X;
	@Expose public double Y;
	@Expose public double Z;
	
	public Location(double f, double g, double h) {
		X = f;
		Y = g;
		Z = h;
	}

	public Location() {
	}
}
