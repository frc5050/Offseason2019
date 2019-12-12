/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  //Motors
  public static final int LEFT_DRIVE_1 = 15; // SRX
  public static final int LEFT_DRIVE_2 = 16; // SPX
  public static final int RIGHT_DRIVE_1 = 2; // SRX
  public static final int RIGHT_DRIVE_2 = 3; // SPX
  public static final int CARGO_CENTER = 10; // SRX
  public static final int CARGO_LEFT = 9; // SRX
  public static final int CARGO_RIGHT = 8; // SRX
  public static final int OUDO_TILT = 13; // SRX
  public static final int OUDO_WHEELS = 1; // SRX
  //Sensors
  public static final int CARGO_SENSOR = 0; // dio

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
}
