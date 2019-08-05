/**
 * A push trigger that uses cylinders
 */

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.*;

public class CylinderTrigger extends Subsystem implements PushTrigger {
  
  private Solenoid[] cylinders;
  
  public CylinderTrigger(Solenoid[] triggers) {
    cylinders = triggers;
  }
    
  public void push(boolean act) {
    if (act) {
      for (Solenoid sol : cylinders) {
	      sol.set(true);
      }
    } else {
      retract();
    }
  }
  
  public void retract() {
	  for (Solenoid sol : cylinders) {
		  sol.set(false);
	  }
  }
  
  @Override
  	public void initDefaultCommand() {
		  // Set the default command for a subsystem here.
	  	// setDefaultCommand(new MySpecialCommand());
  	}
  
}
