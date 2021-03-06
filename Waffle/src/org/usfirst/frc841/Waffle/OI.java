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

import org.usfirst.frc841.Waffle.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public JoystickButton quickturn;
    public JoystickButton stopquickturn;
    public JoystickButton setLowGear;
    public JoystickButton setHighGear;
    public Joystick driver;
    public JoystickButton gearSuck;
    public JoystickButton stopGearSuck;
    public JoystickButton gearSpit;
    public JoystickButton upElbows;
    public JoystickButton downElbows;
    public JoystickButton climbOnward;
    public JoystickButton stopClimb;
    public Joystick coDriver;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        coDriver = new Joystick(1);
        
        stopClimb = new JoystickButton(coDriver, 2);
        stopClimb.whenReleased(new ClimbDis());
        climbOnward = new JoystickButton(coDriver, 2);
        climbOnward.whenPressed(new ClimbEn());
        downElbows = new JoystickButton(coDriver, 6);
        downElbows.whenPressed(new BringElbowDown());
        upElbows = new JoystickButton(coDriver, 5);
        upElbows.whenPressed(new BringElbowUp());
        gearSpit = new JoystickButton(coDriver, 1);
        gearSpit.whenPressed(new SpitGear());
        stopGearSuck = new JoystickButton(coDriver, 3);
        stopGearSuck.whenReleased(new StopSuckingGear());
        gearSuck = new JoystickButton(coDriver, 3);
        gearSuck.whenPressed(new SuckGear());
        driver = new Joystick(0);
        
        setHighGear = new JoystickButton(driver, 4);
        setHighGear.whenPressed(new HighGear());
        setLowGear = new JoystickButton(driver, 2);
        setLowGear.whenPressed(new LowGear());
        stopquickturn = new JoystickButton(driver, 6);
        stopquickturn.whenReleased(new StopQuickTurn());
        quickturn = new JoystickButton(driver, 6);
        quickturn.whenPressed(new QuickTurn());


        // SmartDashboard Buttons
        SmartDashboard.putData("releaseClimb", new releaseClimb());
        SmartDashboard.putData("AutonomousGearLeft", new AutonomousGearLeft());
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("Drive", new Drive());
        SmartDashboard.putData("QuickTurn", new QuickTurn());
        SmartDashboard.putData("StopQuickTurn", new StopQuickTurn());
        SmartDashboard.putData("GearIn", new GearIn());
        SmartDashboard.putData("GearHold", new GearHold());
        SmartDashboard.putData("GearRelease", new GearRelease());
        SmartDashboard.putData("HighGear", new HighGear());
        SmartDashboard.putData("LowGear", new LowGear());
        SmartDashboard.putData("AutonomousGearStraight", new AutonomousGearStraight());
        SmartDashboard.putData("DriveTowardsPeg", new DriveTowardsPeg());
        SmartDashboard.putData("CheckPegAndRelease", new CheckPegAndRelease());
        SmartDashboard.putData("AutonomousGearRight", new AutonomousGearRight());
        SmartDashboard.putData("AutonomousGoHome", new AutonomousGoHome());
        SmartDashboard.putData("Climber", new Climber());
        SmartDashboard.putData("SuckGear", new SuckGear());
        SmartDashboard.putData("SpitGear", new SpitGear());
        SmartDashboard.putData("StopSuckingGear", new StopSuckingGear());
        SmartDashboard.putData("BringElbowDown", new BringElbowDown());
        SmartDashboard.putData("BringElbowUp", new BringElbowUp());
        SmartDashboard.putData("ClimbUp", new ClimbUp());
        SmartDashboard.putData("AutoPickGearUp", new AutoPickGearUp());
        SmartDashboard.putData("ClimbEn", new ClimbEn());
        SmartDashboard.putData("ClimbDis", new ClimbDis());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getDriver() {
        return driver;
    }

    public Joystick getCoDriver() {
        return coDriver;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

