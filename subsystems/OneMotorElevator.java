/**
 * A simple elevator that uses one motor
 */

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.qpi.first.wpilibj.*;
import frc.robot.devices.Motor;

public class OneMotorElevator implements Elevator extends Subsystem {
  
  private String motorLoc;
  
  // specify whether the motor is facing left or right on the robot
  // with regards to its natural orientation
  public OneMotorElevator(Motor mymotor, String motorOrientation) {
    motorLoc = motorOrientation;
  }
  
  public void elevatorUp() {
    
  }
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
  }
  
}
