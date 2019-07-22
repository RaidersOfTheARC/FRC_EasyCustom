/**
 * A simple elevator that uses two motors
 */

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.qpi.first.wpilibj.*;

public class TwoMotorElevator implements Elevator extends Subsystem {
	
    private SpeedController leftMotor, rightMotor;
    private double power;
  
  	public TwoMotorElevator(SpeedController motorLeft, SpeedController motorRight, double speed) {
      leftMotor = motorLeft;
      rightMotor = motorRight;
      power = speed;
  	}
  
  	public void elevatorUp() {
	  	motorLeft.set(power);
      motorRight.set(-power);
  	}
	
    public void elevatorDown() {
      motorLeft.set(-power);
      motorRight.set(power);
    }

	  public void elevatorStop() {
      motorLeft.set(0);
      motorRight.set(0);
    }
  
  	@Override
  	public void initDefaultCommand() {
		  // Set the default command for a subsystem here.
	  	// setDefaultCommand(new MySpecialCommand());
  	}
  
}
