/**
 * The robot map
 * All of your speed controllers will be mapped here
 * The values assigned to your speed controllers are the Tuner IDs
 */

package frc.robot;

import java.util.HashMap;

public class RobotMap {
  
  private HashMap<String, Integer> map;
  
  // Constructor
  public RobotMap() {
    map = new HashMap<String, Integer>();
  }
  
  public void addDevice(String name, int id) { map.put(name, id); }
  
  public void get(String key) { map.get(key); }
  
  public void set(String key, int id) { map.replace(key, id); }
  
}
