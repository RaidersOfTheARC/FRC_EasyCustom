/**
 * A mechanical turret
 */
 
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.*;

public class Turret extends AngledShooter {

  private double[] defaults;
  private float power;

  // your servo states are specified using 0 and 1
  // 0 = servo rotates counterclockwise, 1 = servo rotates clockwise
  public Turret(Servo[] anglers, SpeedController[] shooters,
                double[] defaults, float power, int[] servoStates) {
    super(anglers, shooters, servoStates);
    this.defaults = defaults;
    this.power = power;
  }

  // if you have shooters on the right,
  // their speed controllers will have to be inverted
  public void shoot(boolean act) {
    if (act) {
      for (SpeedController shooter : super.shooters) {
        shooter.set(power);
      }
    } else {
      stopShooter();
    }
  }
  
  public void stopShooter() {
    for (SpeedController shooter : super.shooters) {
      shooter.set(0);
    }
  }
  
  public void changeAngle(double degrees) {
    Servo[] temp = super.angleManips;
    for (int i = 0; i < temp.length; i++) {
      switch (readServoState(i)) {
        case 0:
          temp[i].setAngle(getPosition[i] - degrees);
          break;
        case 1:
          temp[i].setAngle(getPosition[i] + degrees);
          break;
        default:
          reset();
      }
    }
  }
  
  public int readServoState(int servo) {
    int[] temp = super.servoStates;
    return temp[servo];
  }
  
  public void reset() {
    for (Servo x : super.angleManips) {
      for (double def : defaults) {
        x.setAngle(def);
      }
    }
  }
  
  public double getPosition(int servo) {
    int[] temp = super.angleManips;
    return temp[servo].getAngle();
  }

}
