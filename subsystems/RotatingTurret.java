/**
 * A set-angled turret that rotates on a platform
 */

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.*;

public class RotatingTurret extends Subsystem implements Shooter, RotatingBase {

  private SpeedController baseMotor;
  private SpeedController[] shooters;
  private double basePower, shooterPower;

  public RotatingTurret(SpeedController spinner, SpeedController[] shooters,
                        double baseSpeed, double shooterSpeed) {
    baseMotor = spinner;
    this.shooters = shooters;
    basePower = baseSpeed;
    shooterPower = shooterSpeed;
  }

  // if you have shooters on the right,
  // their speed controllers will have to be inverted
  public void shoot(boolean act) {
    if (act) {
      for (SpeedController shooter : shooters) {
        shooter.set(shooterPower);
      }
    } else {
      stopShooter();
    }
  }
  
  public void stopShooter() {
    for (SpeedController shooter : shooters) {
        shooter.set(0);
    }
  }
  
  public void spin(boolean act) {
    baseMotor.set(basePower);
  }
  
  public void invert() {
    if (!baseMotor.isInverted()) baseMotor.setInverted(true);
    else baseMotor.setInverted(false);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

}
