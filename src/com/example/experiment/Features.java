package com.example.experiment;

public class Features {
	
	private static final String PREDEFINED_LAYOUT = "predefined.layout";

	public boolean isPredefinedLayout() {
		return Boolean.getBoolean(PREDEFINED_LAYOUT);
	}
}
