/**
 * A simple elevator that uses one motor
 */

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.qpi.first.wpilibj.*;

public class OneMotorElevator extends Subsystem implements Elevator {
	
	private String motorLoc;
	private SpeedController motor;
	private double power;
  
  	// specify whether the motor is facing left or right on the robot
  	// with regards to its natural orientation
  	public OneMotorElevator(SpeedController motor, String motorOrientation, double speed) {
	  	motorLoc = motorOrientation;
		this.motor = motor;
		power = speed;
  	}
	
	public void setPower(double speed) {
		power = speed;
	}
  
  	public void elevatorUp(boolean act) {
		if (act) {
			if (motorLoc.toLowerCase().equals("left")) {
				motor.set(power);
			} else if (motorLoc.toLowerCase().equals("right")) {
				motor.set(-power);
			} else {
				elevatorStop();
			}
		} else {
			elevatorStop();
		}
  	}
	
	public void elevatorDown(boolean act) {
		if (act) {
			if (motorLoc.toLowerCase().equals("left")) {
				motor.set(-power);
			} else if (motorLoc.toLowerCase().equals("right")) {
				motor.set(power);
			} else {
				elevatorStop();
			}
		} else {
			elevatorStop();
		}
	}
	
	public void elevatorStop() { motor.set(0); }
  
  	@Override
  	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
	  	// setDefaultCommand(new MySpecialCommand());
  	}
  
}
