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
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
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
    public static CANTalon driveTrainright1;
    public static CANTalon driveTrainright2;
    public static CANTalon driveTrainleft3;
    public static CANTalon driveTrainleft4;
    public static DoubleSolenoid driveTrainShifterSolenoid;
    public static Solenoid driveTrainClimberSolenoid;
    public static SpeedController driveTrainLeftLight;
    public static SpeedController driveTrainRightLight;
    public static Compressor driveTrainCompressor1;
    public static DigitalInput driveTrainAutonomousSwitch1;
    public static Encoder driveTrainleftQuad;
    public static Encoder driveTrainrightQuad;
    public static DigitalInput driveTrainAutonomousSwitch2;
    public static SpeedController gearManipulatorElbow;
    public static SpeedController gearManipulatorRoller;
    public static DigitalInput gearManipulatorGearSensor;
    public static DigitalInput gearManipulatorUpperLimit;
    public static DigitalInput gearManipulatorLowerLimit;
    public static DigitalInput gearManipulatorPegSensor;
    public static SpeedController liftclimbermotor1;
    public static SpeedController liftclimbermotor2;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
     
    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrainright1 = new CANTalon(1);
        LiveWindow.addActuator("DriveTrain", "right1", driveTrainright1);
        
        driveTrainright2 = new CANTalon(2);
        LiveWindow.addActuator("DriveTrain", "right2", driveTrainright2);
        
        driveTrainleft3 = new CANTalon(3);
        LiveWindow.addActuator("DriveTrain", "left3", driveTrainleft3);
        
        driveTrainleft4 = new CANTalon(4);
        LiveWindow.addActuator("DriveTrain", "left4", driveTrainleft4);
        
        driveTrainShifterSolenoid = new DoubleSolenoid(0, 0, 1);
        LiveWindow.addActuator("DriveTrain", "ShifterSolenoid", driveTrainShifterSolenoid);
        
        driveTrainClimberSolenoid = new Solenoid(0, 5);
        LiveWindow.addActuator("DriveTrain", "ClimberSolenoid", driveTrainClimberSolenoid);
        
        driveTrainLeftLight = new VictorSP(6);
        LiveWindow.addActuator("DriveTrain", "LeftLight", (VictorSP) driveTrainLeftLight);
        
        driveTrainRightLight = new VictorSP(4);
        LiveWindow.addActuator("DriveTrain", "RightLight", (VictorSP) driveTrainRightLight);
        
        driveTrainCompressor1 = new Compressor(0);
        
        
        driveTrainAutonomousSwitch1 = new DigitalInput(1);
        LiveWindow.addSensor("DriveTrain", "AutonomousSwitch1", driveTrainAutonomousSwitch1);
        
        driveTrainleftQuad = new Encoder(3, 4, false, EncodingType.k4X);
        LiveWindow.addSensor("DriveTrain", "leftQuad", driveTrainleftQuad);
        driveTrainleftQuad.setDistancePerPulse(1.0);
        driveTrainleftQuad.setPIDSourceType(PIDSourceType.kRate);
        driveTrainrightQuad = new Encoder(5, 6, false, EncodingType.k4X);
        LiveWindow.addSensor("DriveTrain", "rightQuad", driveTrainrightQuad);
        driveTrainrightQuad.setDistancePerPulse(1.0);
        driveTrainrightQuad.setPIDSourceType(PIDSourceType.kRate);
        driveTrainAutonomousSwitch2 = new DigitalInput(2);
        LiveWindow.addSensor("DriveTrain", "AutonomousSwitch2", driveTrainAutonomousSwitch2);
        
        gearManipulatorElbow = new VictorSP(0);
        LiveWindow.addActuator("GearManipulator", "Elbow", (VictorSP) gearManipulatorElbow);
        
        gearManipulatorRoller = new VictorSP(1);
        LiveWindow.addActuator("GearManipulator", "Roller", (VictorSP) gearManipulatorRoller);
        
        gearManipulatorGearSensor = new DigitalInput(7);
        LiveWindow.addSensor("GearManipulator", "GearSensor", gearManipulatorGearSensor);
        
        gearManipulatorUpperLimit = new DigitalInput(8);
        LiveWindow.addSensor("GearManipulator", "UpperLimit", gearManipulatorUpperLimit);
        
        gearManipulatorLowerLimit = new DigitalInput(0);
        LiveWindow.addSensor("GearManipulator", "LowerLimit", gearManipulatorLowerLimit);
        
        gearManipulatorPegSensor = new DigitalInput(9);
        LiveWindow.addSensor("GearManipulator", "PegSensor", gearManipulatorPegSensor);
        
        liftclimbermotor1 = new VictorSP(2);
        LiveWindow.addActuator("lift", "climbermotor1", (VictorSP) liftclimbermotor1);
        
        liftclimbermotor2 = new VictorSP(5);
        LiveWindow.addActuator("lift", "climbermotor2", (VictorSP) liftclimbermotor2);
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}
