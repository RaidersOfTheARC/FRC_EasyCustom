/**
 * A conveyor that runs on one motor
 */

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.*;
import frc.robot.*;

public class OneMotorConveyor implements Conveyor {
  
  private SpeedController left, right;
  private double power;
  
  // please input the motor used, its orientation, and the requested power output
  public OneMotorConveyor(SpeedController left, SpeedController right, double speed) {
    this.left = left;
    this.right = right;
    power = speed;
  }
  
  public void setPower(double speed) { power = speed; }
  
  public void runConveyor(boolean act) {
    if (act) {
      left.set(power);
      right.set(-power);
    } else {
      stopConveyor();
    }
  }
  
  public void stopConveyor() {
    left.set(0);
    right.set(0);
  }
  
  public void invertConveyor() {
    if (!left.getInverted() && !right.getInverted()) {
      left.setInverted(true);
      right.setInverted(true);
    }
    else {
      left.setInverted(false);
      right.setInverted(false);
    }
  }
  
}
