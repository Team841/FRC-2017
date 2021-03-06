// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc841.Waffle.subsystems;

import org.usfirst.frc841.Waffle.RobotMap;
import org.usfirst.frc841.Waffle.commands.ClimbUp;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author Team841-P01
 *
 */
public class lift extends Subsystem {

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final SpeedController climbermotor1 = RobotMap.liftclimbermotor1;
    private final SpeedController climbermotor2 = RobotMap.liftclimbermotor2;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	/**
	 * method to allow joystick axis to control power of motors to climb up the rope
	 * @param axisvalue
	 */
	public void climb(Joystick stick) {
		setLeftRight(stick.getThrottle()); // If you move the axis up or
											// down, it will climb up
	}
	
	/**
	 * Set the power of the left and right motor of the climber
	 * @param power
	 */
	public void setLeftRight(double power) {
		climbermotor1.set(power);
		climbermotor2.set(-power);
	}

}
