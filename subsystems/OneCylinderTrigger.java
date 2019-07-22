/**
 * A push trigger that uses one cylinder
 */

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.*;

public class OneCylinderTrigger implements PushTrigger extends Subsystem {
  
  private Solenoid trigger
  
  public OneMotorConveyor(Solenoid trigger) {
    this.trigger = trigger;
  }
    
  public void push(boolean act) {
    if (act) {
      trigger.set(true);
    } else {
      retract();
    }
  }
  
  public void stopConveyor() { trigger.set(false); }
  
  @Override
  	public void initDefaultCommand() {
		  // Set the default command for a subsystem here.
	  	// setDefaultCommand(new MySpecialCommand());
  	}
  
}
