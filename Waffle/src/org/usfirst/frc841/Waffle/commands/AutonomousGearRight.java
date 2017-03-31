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
public class AutonomousGearRight extends CommandGroup {


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PARAMETERS
    public AutonomousGearRight() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PARAMETERS

    	//Get high gear
		addSequential (new HighGear());
    	
		//Drive straight
		addSequential (new TimedDriveStraight(C.autoDrivingDistance, C.autoMotorLowSpeed, true));
		
    	//Turn to the right
    	addSequential (new TimedTurn(false,0.5,C.autoTurningDistance));
    	//skiped, must be placed in 45 degrees to the left.
    	
		//Go straight
		addSequential (new TimedDriveStraight(C.autoDrivingDistance*2, 0.3, true));
//    	addSequential (new TimedDriveStraight(C.autoDrivingDistance*3.5, C.autoMotorSpeed, true));
    	
    	//Turn to the left
    	addSequential (new TimedTurn(true,0.5,0.35));

		//Go straight
		addSequential (new TimedDriveStraight(C.autoDrivingDistance, 0.3, true));

    	//Turn to the left
    	addSequential (new TimedTurn(true,0.45,0.7));
    	
		//Center and go straight to the Peg
		addSequential (new DriveTowardsPeg());
		
		//ReleaseGear
		//addSequential (new SpitGear());
		
		//Delay of 3 seconds
		addSequential (new TimedDriveStraight(3, 0, true));
		
		//Go back 
    	addSequential (new TimedDriveStraight(0.7, C.autoDrivingDistance, false));
    	
    	//Turn to the right
    	addSequential (new TimedTurn(false,0.5,C.autoTurningDistance));
    	
    	//Drive over line
    	addSequential (new TimedDriveStraight(C.autoDrivingDistance * 3, C.autoMotorSpeed, true));
    	
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=COMMAND_DECLARATIONS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=COMMAND_DECLARATIONS
 
    } 
}
