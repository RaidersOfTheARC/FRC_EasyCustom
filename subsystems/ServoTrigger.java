/**
 * A push trigger that uses servos
 */

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.*;

public class ServoTrigger implements PushTrigger extends Subsystem {
  
  private Servo[] servos;
  private double[] positions;
  private double[] defaults;
  
  // positions and defaults are values in [0, 1]
  // default = default servo position
  public ServoTrigger(Servo[] triggers, double[] defaults, double[] positions) {
    servos = triggers;
    this.positions = positions;
    this.defaults = defaults;
  }
    
  public void push(boolean act) {
    if (act) {
      for (Servo x : servos) {
	  for (double pos : positions) {
          	x.set(pos);
          }
      }
    } else {
      retract();
    }
  }
  
  public void retract() {
	for (Servo x : servos) {
      		for (double def : defaults) {
        		x.set(def);
      		}
    	}
  }
  
  @Override
  	public void initDefaultCommand() {
		  // Set the default command for a subsystem here.
	  	// setDefaultCommand(new MySpecialCommand());
  	}
  
}
