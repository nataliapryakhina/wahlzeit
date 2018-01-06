package org.wahlzeit.utils;

//https://docs.oracle.com/javase/tutorial/java/annotations/declaring.html
public @interface PatternInstance {
	String patternName();
	String[] participants();

}
