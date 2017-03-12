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

import org.usfirst.frc841.Waffle.Constants;
import org.usfirst.frc841.Waffle.RobotMap;
import org.usfirst.frc841.Waffle.commands.*;
import org.usfirst.frc841.lib.PID.PIDControlLoop;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * This Defines the driveTrain subsystem.
 */
public class DriveTrain extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final SpeedController leftDriveTrain1 = RobotMap.driveTrainLeftDriveTrain1;
    private final SpeedController leftDriveTrain2 = RobotMap.driveTrainLeftDriveTrain2;
    private final SpeedController rightDriveTrain2 = RobotMap.driveTrainRightDriveTrain2;
    private final SpeedController rightDriveTrain1 = RobotMap.driveTrainRightDriveTrain1;
    private final DoubleSolenoid shifterSolenoid = RobotMap.driveTrainShifterSolenoid;
    private final Solenoid climberSolenoid = RobotMap.driveTrainClimberSolenoid;
    private final SpeedController leftLight = RobotMap.driveTrainLeftLight;
    private final SpeedController rightLight = RobotMap.driveTrainRightLight;
    private final Compressor compressor1 = RobotMap.driveTrainCompressor1;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	boolean isHighGear = false;
	private double oldWheel = 0.0;
	private double quickStopAccumulator = 0;
	private boolean isQuickTurn = false;    
	
	NetworkTable table;
	double isElevatorPresent = 0;
	double pegPosition = 0;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
	/**
	 * This method takes in the driver controller and allows for tank style
	 * drive of the robot. A smoothness function is done to allow for a smoother
	 * control.
	 * 
	 * @param stick
	 */
    public void tankDrive(Joystick stick) {
		//double axisNonLinearity;
		// Get Y axis and make a deadBand
		double leftY = handleDeadband(getYAxisLeftSide(stick), 0.02);
		double rightY = handleDeadband(getYAxisRightSide(stick), 0.02);
/*
		if (isHighGear) {
			axisNonLinearity = 0.5;
			// Smooth the controls on Left side
			leftY = Math.sin(Math.PI / 2.0 * axisNonLinearity * leftY) / Math.sin(Math.PI / 2.0 * axisNonLinearity);
			leftY = Math.sin(Math.PI / 2.0 * axisNonLinearity * leftY) / Math.sin(Math.PI / 2.0 * axisNonLinearity);

			// Smooth the controls on Right side
			rightY = Math.sin(Math.PI / 2.0 * axisNonLinearity * rightY) / Math.sin(Math.PI / 2.0 * axisNonLinearity);
			rightY = Math.sin(Math.PI / 2.0 * axisNonLinearity * rightY) / Math.sin(Math.PI / 2.0 * axisNonLinearity);
		} else {
			axisNonLinearity = 0.5;
			// Smooth the controls on Left side
			leftY = Math.sin(Math.PI / 2.0 * axisNonLinearity * leftY) / Math.sin(Math.PI / 2.0 * axisNonLinearity);
			leftY = Math.sin(Math.PI / 2.0 * axisNonLinearity * leftY) / Math.sin(Math.PI / 2.0 * axisNonLinearity);

			// Smooth the controls on Right side
			rightY = Math.sin(Math.PI / 2.0 * axisNonLinearity * rightY) / Math.sin(Math.PI / 2.0 * axisNonLinearity);
			rightY = Math.sin(Math.PI / 2.0 * axisNonLinearity * rightY) / Math.sin(Math.PI / 2.0 * axisNonLinearity);
		}
*/
		// set the motors
		SetLeftRight(leftY, rightY);
    
    } 
    
    /**
	 * Enable quick turn AKA classical Arcade drive
	 */
	public void setQuickTurn() {
		isQuickTurn = true;
	}

	/**
	 * Disable quick turn
	 */
	public void resetQuickTurn() {
		isQuickTurn = false;
	}
	/**
	 * Initialize the compressor for self regulation of the pneumatics.
	 */
	public void InitCompressor() {
		this.compressor1.enabled();
	}
    
	/**
	 * This method does the Halo drive and is the slim down version of the
	 * cheesy poofs drive style. It has the capability to auto shift if
	 * uncommented.
	 * 
	 * @param stick
	 */
    public void cheesyDrive(Joystick stick) {

		// Note quickturn and shift is taken care of with buttons in OI.

		double wheelNonLinearity;
		double wheel = handleDeadband(getWheel(stick), Constants.wheelDeadband); // double
																		// wheel
																		// =
																		// handleDeadband(controlBoard.rightStick.getX(),
																		// wheelDeadband);
		double throttle = -handleDeadband(getThrottle(stick), Constants.throttleDeadband);
		double negInertia = wheel - oldWheel;
		/*
		 * if(getAverageSpeed()> 2000){ SetHighGear(); } else if
		 * (getAverageSpeed() < 1500){ SetLowGear(); }
		 */

		oldWheel = wheel;
		if (isHighGear) {
			wheelNonLinearity = 0.6;
			// Apply a sin function that's scaled to make it feel better.
			wheel = Math.sin(Math.PI / 2.0 * wheelNonLinearity * wheel) / Math.sin(Math.PI / 2.0 * wheelNonLinearity);
			wheel = Math.sin(Math.PI / 2.0 * wheelNonLinearity * wheel) / Math.sin(Math.PI / 2.0 * wheelNonLinearity);
		} else {
			wheelNonLinearity = 0.5;
			// Apply a sin function that's scaled to make it feel better.
			wheel = Math.sin(Math.PI / 2.0 * wheelNonLinearity * wheel) / Math.sin(Math.PI / 2.0 * wheelNonLinearity);
			wheel = Math.sin(Math.PI / 2.0 * wheelNonLinearity * wheel) / Math.sin(Math.PI / 2.0 * wheelNonLinearity);
			wheel = Math.sin(Math.PI / 2.0 * wheelNonLinearity * wheel) / Math.sin(Math.PI / 2.0 * wheelNonLinearity);
		}

		double leftPwm, rightPwm, overPower;
		double sensitivity = 1.7;
		double angularPower;
		double linearPower;
		// Negative inertia!
		double negInertiaAccumulator = 0.0;
		double negInertiaScalar;

		if (isHighGear) {
			negInertiaScalar = 5.0;
			sensitivity = Constants.sensitivityHigh; // sensitivity =
											// Constants.sensitivityHigh.getDouble();
		} else {
			if (wheel * negInertia > 0) {
				negInertiaScalar = 2.5;
			} else {
				if (Math.abs(wheel) > 0.65) {
					negInertiaScalar = 5.0;
				} else {
					negInertiaScalar = 3.0;
				}
			}
			sensitivity = Constants.sensitivityLow; // sensitivity =
											// Constants.sensitivityLow.getDouble();
			if (Math.abs(throttle) > 0.1) {
				// sensitivity = 1.0 - (1.0 - sensitivity) / Math.abs(throttle);
			}
		}

		double negInertiaPower = negInertia * negInertiaScalar;
		negInertiaAccumulator += negInertiaPower;
		wheel = wheel + negInertiaAccumulator;
		if (negInertiaAccumulator > 1) {
			negInertiaAccumulator -= 1;
		} else if (negInertiaAccumulator < -1) {
			negInertiaAccumulator += 1;
		} else {
			negInertiaAccumulator = 0;
		}
		linearPower = throttle;
		// Quickturn!
		if (isQuickTurn) {
			if (Math.abs(linearPower) < 0.2) {
				double alpha = 0.1;
				quickStopAccumulator = (1 - alpha) * quickStopAccumulator + alpha * limit(wheel, 1.0) * 5;
			}
			overPower = 1.0;
			if (isHighGear) {
				sensitivity = 1.0;
			} else {
				sensitivity = 0.10;

			}
			angularPower = wheel;
		} else {
			overPower = 0.0;
			angularPower = Math.abs(throttle) * wheel * sensitivity - quickStopAccumulator;
			if (quickStopAccumulator > 1) {
				quickStopAccumulator -= 1;
			} else if (quickStopAccumulator < -1) {
				quickStopAccumulator += 1;
			} else {
				quickStopAccumulator = 0.0;
			}
		}
		rightPwm = leftPwm = linearPower;
		leftPwm += angularPower;
		rightPwm -= angularPower;
		if (leftPwm > 1.0) {
			rightPwm -= overPower * (leftPwm - 1.0);
			leftPwm = 1.0;
		} else if (rightPwm > 1.0) {
			leftPwm -= overPower * (rightPwm - 1.0);
			rightPwm = 1.0;
		} else if (leftPwm < -1.0) {
			rightPwm += overPower * (-1.0 - leftPwm);
			leftPwm = -1.0;
		} else if (rightPwm < -1.0) {
			leftPwm += overPower * (-1.0 - rightPwm);
			rightPwm = -1.0;
		}
		SetLeftRight(leftPwm, -rightPwm);

	}

    public void SetLeftRight(double LPower, double RPower){
    	leftDriveTrain1.set(LPower);
    	leftDriveTrain2.set(LPower);
    	rightDriveTrain1.set(RPower);
    	rightDriveTrain2.set(RPower);
    }
    
	/**
	 * This method takes in the object joystick and returns the y axis value to
	 * the left most side of the gamepad.
	 * 
	 * @param stick
	 * @return yAxis
	 */
    public double getYAxisLeftSide(Joystick stick) {
		return stick.getY();
	}
    
	/**
	 * This method takes inthe ojbect joystick and returns the y axis value to
	 * the right most siide of the gamepad.
	 * 
	 * @param stick
	 * @return
	 */
    public double getYAxisRightSide(Joystick stick) {
		return stick.getThrottle();
	}
    
	/**
	 * If the value is too small make it zero
	 * 
	 * @param val
	 * @param deadband
	 * @return value with deadband
	 */
	public double handleDeadband(double val, double deadband) {
		return (Math.abs(val) > Math.abs(deadband)) ? val : 0.0;
	}
	

	
	/**
	 * Shift drive to high gear and update memory
	 */
	public void SetHighGear() {
		shifterSolenoid.set(DoubleSolenoid.Value.kForward);
		climberSolenoid.set(false);
		isHighGear = true;
	}
	
	/**
	 * Shift drive train to low gear and update memory
	 */
	public void SetLowGear() {
		shifterSolenoid.set(DoubleSolenoid.Value.kReverse);
		climberSolenoid.set(false);
		isHighGear = false;
	}
	
	public void Drive(Joystick stick) {
			cheesyDrive(stick);
			updateTurnSignal();
		// if (!this.EnablePID){
		//this.postData();
		//tankDrive(stick);
		// }
		
	}
	
	/**
	 * If the value is too large limit it.
	 * 
	 * @param v
	 * @param limit
	 * @return value with a max limit
	 */
	public static double limit(double v, double limit) {
		return (Math.abs(v) < limit) ? v : limit * (v < 0 ? -1 : 1);
	}
	
	/**
	 * This method takes in object joystick and returns the yaxis value of the
	 * left most side of the gamepad.
	 * 
	 * @param stick
	 * @return yAxis
	 */
	public double getThrottle(Joystick stick) {
		return stick.getY();
	}
	
	/**
	 * This method takes in the object joystick and returns the x axis value to
	 * the right most side of the gamepad.
	 * 
	 * @param stick
	 * @return xAxis
	 */
	public double getWheel(Joystick stick) {
		return stick.getZ();
	}

	public boolean isElevatorPresent(){
		isElevatorPresent =  table.getNumber("BLOB_COUNT", 0.0);
		if(isElevatorPresent > 1){
			return true;
		}
		else{
			return false;
		}
	}
	
	
	public double getPegPosition(){
		pegPosition = (table.getNumber("X1", 0.0) + table.getNumber("X2", 0.0))/2;
		return pegPosition;
	}
	
	public void updateTurnSignal(){
		if( isElevatorPresent() ){
			double current =  getPegPosition();
			// If its centered turn on both lights
			if( (current < (Constants.centervalue + Constants.tolerance)) &
					(current > (Constants.centervalue - Constants.tolerance)) ){
				leftLight.set(1);
				rightLight.set(1);
			}
			// If its to the right turn on the left indicator and turn off the right indicator
			else if (current > (Constants.centervalue + Constants.tolerance)){
				leftLight.set(1);
				rightLight.set(0);
			}
			// If its to the left turn on the right indicator and turn off the left indicator
			else if (current < (Constants.centervalue + Constants.tolerance)){
				leftLight.set(0);
				rightLight.set(1);
			}
			
		}
		else{
			leftLight.set(0);
			rightLight.set(0);
		}
	}
	
	public class CLoop extends PIDControlLoop {
		DriveTrain subsystem;
		public CLoop(DriveTrain subsystem, double[] X, double[] Y, long sampleTime){
			super(X, Y, sampleTime);
			this.subsystem = subsystem;
		}
		@Override
		public double getSensorReading(){
			boolean reading = subsystem.isElevatorPresent();
			return subsystem.getPegPosition();
		}
		@Override
		public void update() {
			//SmartDashboard.putString("DB/String 0", "elevator " + subsystem.isElevatorPresent());
			SmartDashboard.putString("DB/String 1", "elevator " + subsystem.getPegPosition());
		}
	}
	
	public DriveTrain.CLoop cloop;
	
	double x[] = {1, 2, 3 };
	double y[] = {0, 0, 0 };
	
	//Notifier controlLoopTimer;
	
	private double period = .2; // Seconds
	public DriveTrain(){
		table = NetworkTable.getTable("SmartDashboard");
		cloop = new DriveTrain.CLoop(this, x, y, (long) Math.abs(period * 100));
	}
	
	
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new Drive());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
    	
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
}

