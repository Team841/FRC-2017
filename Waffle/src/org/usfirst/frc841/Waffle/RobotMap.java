// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc841.Waffle;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static SpeedController driveTrainLeftDriveTrain1;
    public static SpeedController driveTrainLeftDriveTrain2;
    public static SpeedController driveTrainRightDriveTrain1;
    public static SpeedController driveTrainRightDriveTrain2;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrainLeftDriveTrain1 = new VictorSP(0);
        LiveWindow.addActuator("DriveTrain", "LeftDriveTrain1", (VictorSP) driveTrainLeftDriveTrain1);
        
        driveTrainLeftDriveTrain2 = new VictorSP(1);
        LiveWindow.addActuator("DriveTrain", "LeftDriveTrain2", (VictorSP) driveTrainLeftDriveTrain2);
        
        driveTrainRightDriveTrain1 = new VictorSP(2);
        LiveWindow.addActuator("DriveTrain", "RightDriveTrain1", (VictorSP) driveTrainRightDriveTrain1);
        
        driveTrainRightDriveTrain2 = new VictorSP(3);
        LiveWindow.addActuator("DriveTrain", "RightDriveTrain2", (VictorSP) driveTrainRightDriveTrain2);
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}
