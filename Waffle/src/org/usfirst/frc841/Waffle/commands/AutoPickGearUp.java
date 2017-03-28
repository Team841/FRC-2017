// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc841.Waffle.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc841.Waffle.Robot;

/**
 * This command allows for auto pickup of gear.
 */
public class AutoPickGearUp extends Command {


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public AutoPickGearUp() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.gearManipulator);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	// Get current state and store it.
    	Robot.gearManipulator.setCurrent( Robot.gearManipulator.isGearPresent());
    	
    	// Check if gear goes into hopper. If it came in then set auto pick up. otherwise finish and update memory.
    	if(Robot.gearManipulator.getCurrent() == true && Robot.gearManipulator.getlast() == false){ // if gear comes into hopper
    		Robot.gearManipulator.setAutoPickup(); //pick up automatically mode enabled
    		Robot.gearManipulator.setRollerStop(); //Since gear is in so stop in-take roller and hold gear
    		Robot.gearManipulator.setElbowUp(); // bring up elbow.
    		setTimeout(2); // set a timeout in case sensor stops working
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//If this is auto pick up mode then wait until elbow is all the way up
    	if(Robot.gearManipulator.isAutoPickup()){
    		
    		// If Upper limit, this means elbow is all the way up and stop all motors and turn off auto pickup
    		if(Robot.gearManipulator.getUpperLimit()){
    			Robot.gearManipulator.setElbowStop(); //Stop since it is in right condition
    			Robot.gearManipulator.resetAutoPickup(); // reset to get ready for next time
    			return true; // end
    		}
    		// If it takes too long stop it just in case. Most likely sensor is broken.
    		else if(isTimedOut()){
    			Robot.gearManipulator.setElbowStop(); // Stop since it took too long
    			Robot.gearManipulator.resetAutoPickup(); // reset autoPickup for next time
    			return true; //end
    		}
    		// Otherwise still pending and keep on doing what you are doing.
    		else{
    			Robot.gearManipulator.update(); //update Memory
    			return false; //repeat execute and check again.
    		}
    	}
    	else{ // If not in pick up mode then finish and update memory
 
    		return true; // We are not in auto-mode and we should update memory 
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.gearManipulator.update();// update memory
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.gearManipulator.setElbowStop(); // Since we interrupted we should stop elbow
    	Robot.gearManipulator.resetAutoPickup(); // We should clear pickup mode for next time.
    }
}
