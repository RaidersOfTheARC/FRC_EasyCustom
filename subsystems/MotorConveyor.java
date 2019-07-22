/**
 * A simple motor conveyor
 * examples could be a wheel outtake/intake or a tread elevator
 */
 
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.*;
 
public interface MotorConveyor extends Subsystem {

  // activate the conveyor
  public void runConveyor(boolean act);
  
  // stop the conveyor
  public void stopConveyor();
  
  // reverse the direction of the conveyor
  public void invertConveyor();

}
