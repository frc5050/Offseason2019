/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.IntakeWithJoystick;
import edu.wpi.first.wpilibj.DigitalInput;

/**
 * An example subsystem. You can replace me with your own Subsystem.
 */
public class Intake extends Subsystem {
    //Motors
    private final WPI_TalonSRX centerSide;
    private final WPI_TalonSRX rightRear;
    private final WPI_TalonSRX leftRear;
    private final WPI_TalonSRX oudoWheels;
    private final WPI_TalonSRX oudoTilt;
    //Sensors
    private final DigitalInput sensor;

 
  public Intake() {
    //Motors
    centerSide = new WPI_TalonSRX(RobotMap.CARGO_CENTER);
    rightRear = new WPI_TalonSRX(RobotMap.CARGO_LEFT);
    leftRear = new WPI_TalonSRX(RobotMap.CARGO_RIGHT);
    oudoWheels = new WPI_TalonSRX(RobotMap.OUDO_WHEELS);
    oudoTilt = new WPI_TalonSRX(RobotMap.OUDO_TILT);
    //Sensors
    sensor = new DigitalInput(RobotMap.CARGO_SENSOR);

    rightRear.setInverted(true);
    oudoWheels.setInverted(true);
  }

  public boolean isCargoPresent() {
    return !sensor.get();
  }

  public void setIntakePower(double centerPower, double rightRearPower, double leftRearPower, double intakePower, double intakeTiltPower){
      centerSide.set(centerPower);
      rightRear.set(rightRearPower);
      leftRear.set(leftRearPower);
      oudoWheels.set(intakePower);
      oudoTilt.set(intakeTiltPower);
  }

  
  
  @Override
  public void initDefaultCommand() {
    //setDefaultCommand(new IntakeWithJoystick());
  }
}