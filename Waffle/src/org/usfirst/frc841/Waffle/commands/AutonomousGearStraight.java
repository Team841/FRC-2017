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

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc841.Waffle.C;
import org.usfirst.frc841.Waffle.subsystems.*;

/**
 *
 */
public class AutonomousGearStraight extends CommandGroup {


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PARAMETERS
    public AutonomousGearStraight() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PARAMETERS
	    	//Get high gear
    		addSequential (new HighGear());
    		
    		//Go straight for 0.5s, Power 0.3
    		addSequential (new TimedDriveStraight(C.autoDrivingDistance*2, C.autoMotorLowSpeed, true)); //0.5 multiplied by 3 = 1.5s
	    	
    		//CAMERA OPERATED AUTONOMOUS: BEGIN //DISABLED BECAUSE OF THE FALSE POSITIVE DETECTIONS
    		
    		//Center and go straight to the Pig
    		addSequential (new DriveTowardsPeg());
    		
    		//CAMERA OPERATED AUTONOMOUS: END
    		
    		//Delay of 5 seconds
    		addSequential (new TimedDriveStraight(5, 0, true));

    		//GO BACK AND GO TO THE GOAL: BEGIN
    		
    		//Go back 
	    	addSequential (new TimedDriveStraight(0.7, C.autoMotorSpeed, false)); //was 0.7
	    	
	    	//Turn to the left
	    	addSequential (new TimedTurn(true,0.5,C.autoTurningDistance)); 
	    	
	    	//Drive over line
	    	addSequential (new TimedDriveStraight(C.autoDrivingDistance * 3.5, C.autoMotorSpeed, true)); //was 1.5
			
    		//GO BACK AND GO TO THE GOAL: END

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=COMMAND_DECLARATIONS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=COMMAND_DECLARATIONS
 
    } 
}
