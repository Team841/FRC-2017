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
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.GearTooth;
import edu.wpi.first.wpilibj.Solenoid;
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
    public static SpeedController driveTrainRightDriveTrain2;
    public static SpeedController driveTrainRightDriveTrain1;
    public static DoubleSolenoid driveTrainShifterSolenoid;
    public static Solenoid driveTrainClimberSolenoid;
    public static SpeedController driveTrainLeftLight;
    public static SpeedController driveTrainRightLight;
    public static Compressor driveTrainCompressor1;
    public static Solenoid gearManipulatorRamp;
    public static DigitalInput gearManipulatorPegSensor;
    public static DoubleSolenoid gearManipulatorRelease;
    public static GearTooth highShooterWheelSpeedSensor;
    public static SpeedController highShooterHighShooter;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
     
    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrainLeftDriveTrain1 = new VictorSP(0);
        LiveWindow.addActuator("DriveTrain", "LeftDriveTrain1", (VictorSP) driveTrainLeftDriveTrain1);
        
        driveTrainLeftDriveTrain2 = new VictorSP(1);
        LiveWindow.addActuator("DriveTrain", "LeftDriveTrain2", (VictorSP) driveTrainLeftDriveTrain2);
        
        driveTrainRightDriveTrain2 = new VictorSP(3);
        LiveWindow.addActuator("DriveTrain", "RightDriveTrain2", (VictorSP) driveTrainRightDriveTrain2);
        
        driveTrainRightDriveTrain1 = new VictorSP(2);
        LiveWindow.addActuator("DriveTrain", "RightDriveTrain1", (VictorSP) driveTrainRightDriveTrain1);
        
        driveTrainShifterSolenoid = new DoubleSolenoid(0, 0, 1);
        LiveWindow.addActuator("DriveTrain", "ShifterSolenoid", driveTrainShifterSolenoid);
        
        driveTrainClimberSolenoid = new Solenoid(0, 5);
        LiveWindow.addActuator("DriveTrain", "ClimberSolenoid", driveTrainClimberSolenoid);
        
        driveTrainLeftLight = new VictorSP(7);
        LiveWindow.addActuator("DriveTrain", "LeftLight", (VictorSP) driveTrainLeftLight);
        
        driveTrainRightLight = new VictorSP(4);
        LiveWindow.addActuator("DriveTrain", "RightLight", (VictorSP) driveTrainRightLight);
        
        driveTrainCompressor1 = new Compressor(0);
        
        
        gearManipulatorRamp = new Solenoid(0, 3);
        LiveWindow.addActuator("GearManipulator", "Ramp", gearManipulatorRamp);
        
        gearManipulatorPegSensor = new DigitalInput(9);
        LiveWindow.addSensor("GearManipulator", "PegSensor", gearManipulatorPegSensor);
        
        gearManipulatorRelease = new DoubleSolenoid(0, 2, 7);
        LiveWindow.addActuator("GearManipulator", "Release ", gearManipulatorRelease);
        
        highShooterWheelSpeedSensor = new GearTooth(0, false);
        LiveWindow.addSensor("HighShooter", "WheelSpeedSensor", highShooterWheelSpeedSensor);
        
        highShooterHighShooter = new VictorSP(10);
        LiveWindow.addActuator("HighShooter", "HighShooter", (VictorSP) highShooterHighShooter);
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}
