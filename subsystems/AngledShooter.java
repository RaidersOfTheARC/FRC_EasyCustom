package frc.robot.subsystems;

import edu.wpi.first.wpilibj.*;

public abstract class AngledShooter implements AngledDevice, Shooter {
  
  public Servo[] angleManips;
  public SpeedController[] shooters;

  public AngledShooter(Servo[] anglers, SpeedController[] shooters) {
    angleManips = anglers;
    this.shooters = shooters;
  }
  
  public Servo getAngleServo(int index) {
    return angleManips[index];
  }
  
  public SpeedController getShooterMotor(int index) {
    return shooters[index];
  }
  
  public Servo[] getServos() {
    return angleManips;
  }
  
  public SpeedController[] getShooters() {
    return shooters;
  }
  
}
