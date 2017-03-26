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
import org.usfirst.frc841.Waffle.commands.*;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;



/**
 * @author Team841-P01
 *
 */
public class GearManipulator extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final SpeedController elbow = RobotMap.gearManipulatorElbow;
    private final SpeedController roller = RobotMap.gearManipulatorRoller;
    private final DigitalInput gearSensor = RobotMap.gearManipulatorGearSensor;
    private final DigitalInput upperLimit = RobotMap.gearManipulatorUpperLimit;
    private final DigitalInput lowerLimit = RobotMap.gearManipulatorLowerLimit;
    private final DigitalInput pegSensor = RobotMap.gearManipulatorPegSensor;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    private boolean last = false;
    private boolean current = false;
    private boolean autopickup = false;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    /* (non-Javadoc)
     * @see edu.wpi.first.wpilibj.command.Subsystem#initDefaultCommand()
     */
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
    	
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    	
    }

	public void setRampOut() {
		//ramp.set(true);
	}

	public void setRampIn() {
		//ramp.set(false);
	}
	public void setReleaseHold() {
		//release.set(DoubleSolenoid.Value.kReverse);
	}
	public void setReleaseOut() {
		//release.set(DoubleSolenoid.Value.kForward);
	}
	
	/**
	 * Turns on the roller to suck the gear in
	 */
	public void setRollerIntakeGear(){
		roller.set(0.5);
	}
	
	/**
	 * Turns the roller off
	 */
	public void setRollerStop(){
		roller.set(0);
	}
	/**
	 * Turns on the roller to spit the gear out
	 */
	public void setRollerExpelGear(){
		roller.set(-0.5);
	}
	/**
	 * Turns on the elbow motor to raise the intake
	 */
	public void setElbowUp (){
		elbow.set(0.5);
	}
	/**
	 * Turns on the elbow motor to lower the intake
	 */
	public void setElbowDown(){
		elbow.set(-0.25);
	}
	/**
	 * Turns off the elbow motor
	 */
	public void setElbowStop(){
		elbow.set(0);
	}
	/**
	 * @return the state of the up limit for the elbow to move
	 */
	public boolean getUpperLimit(){
		return upperLimit.get();
	}
	/**
	 * @return the state of the lower limit for the elbow to move
	 */
	public boolean getLowerLimit(){
		return lowerLimit.get();
	}
	/**
	 * @return intake gear state for gear handler
	 */
	public boolean isGearPresent(){
		return gearSensor.get();  //sensor must be true when gear is present to make this work.
	}

	/**
	 * 
	 * @return peg status
	 */
	public boolean isPegPresent(){
		return !pegSensor.get();
	}
	/**
	 * store current sensor reading
	 * @param currentreading
	 */
	public void setCurrent(boolean currentreading){
		this.current = currentreading;
	}
	/**
	 * updates current and present memory
	 */
	public void update(){
		this.last = this.current;
	}
	/**
	 * @return current gearSensor State
	 */
	public boolean getCurrent(){
		return this.current;
	}
	/**
	 * @return last gearSensor State
	 */
	public boolean getlast(){
		return this.last;
	}
	/**
	 * @return true if in auto pickup mode
	 */
	public boolean isAutoPickup(){
		return this.autopickup;
	}
	/**
	 * set in Auto Pickup mode
	 */
	public void setAutoPickup(){
		this.autopickup = true;
	}
	/**
	 * clear Auto mode
	 */
	public void resetAutoPickup(){
		this.autopickup = false;
	}

}

