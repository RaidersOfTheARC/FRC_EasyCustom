package frc.robot.subsystems;

import edu.wpi.first.wpilibj.*;

public abstract class AngledShooter implements AngledDevice, Shooter {
  
  public Servo[] angleManips;
  public SpeedController[] shooters;

  public AngledShooter(Servo[] anglers, SpeedController[] shooters) {
    angleManips = anglers;
    this.shooters = shooters;
  }
  
}
