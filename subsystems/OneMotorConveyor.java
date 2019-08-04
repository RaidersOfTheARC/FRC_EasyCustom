/**
 * A conveyor that runs on one motor
 */

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.*;

public class OneMotorConveyor extends Subsystem implements Conveyor {
  
  private SpeedController motor;
  private String motorLoc;
  private double power;
  
  // please input the motor used, its orientation, and the requested power output
  public OneMotorConveyor(SpeedController motor, String orientation, double speed) {
    this.motor = motor;
    motorLoc = orientation.toLowerCase();
    power = speed;
  }
  
  public void setPower(double speed) { power = speed; }
  
  public void runConveyor(boolean act) {
    if (act) {
      if (motorLoc.equals("left")) {
        motor.set(power);
      } else if (motorLoc.equals("right")) {
        motor.set(-power);
      } else {
        stopConveyor();
      }
    } else {
      stopConveyor();
    }
  }
  
  public void stopConveyor() { motor.set(0); }
  
  public void invertConveyor() {
    if (!motor.getInverted()) motor.setInverted(true);
    else motor.setInverted(false);
  }
  
  @Override
  	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
	  	// setDefaultCommand(new MySpecialCommand());
  	}
  
}
