/**
 * 
 */
package org.usfirst.frc841.Waffle;

/**
 * In this class we are storing all the constants and tunings used in all the commands and subsystems
 * @author Team841-P01
 *
 */
public class Constants {

	private Constants(){
		// Prevents instantiation
	}

	// STRUCTURE OF THE CONSTANTS CONTAINED IN THIS DOCUMENT
	//public static final double test = 10.001;	
	
	// CONSTANTS FOR THE DRIVETRAIN
	public static final double throttleDeadband = 0.02; 
	public static final double wheelDeadband = 0.02;	
	public static final double sensitivityHigh = 0.85;	
	public static final double sensitivityLow = 0.75;
	public static final double centervalue = 80;
	public static final double tolerance = 10;
	//public static final double autoOffSet = 5; 
	public static final double autoDrivingDistance = 4.2; // In time, is seconds driving from the starting point (SQRT of 2 two times and multiplied by the side of the driving straight)
	public static final double autoTurningDistance = .8; // In time, is seconds turning to point to the peg of the sides	
	//public static int nAutonomousMode = 0;
	
}
