package frc.robot.subsystems;

public interface RotatingBase {

  // activate the rotating base
  public void spin(boolean act);
  
  // invert the direction of rotation
  public void invert();

}
