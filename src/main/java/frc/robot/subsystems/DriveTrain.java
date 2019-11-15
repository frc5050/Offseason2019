/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import com.revrobotics.frc.CANSparkMax;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class DriveTrain extends Subsystem {
  private CANSparkMax leftMotor1 = new CANSparkMax(RobotMap.LEFT_DRIVE_1);
  private CANSparkMax leftMotor2 = new CANSparkMax(RobotMap.LEFT_DRIVE_2);
  private CANSparkMax rightMotor1 = new CANSparkMax(RobotMap.RIGHT_DRIVE_1);
  private CANSparkMax rightMotor2 = new CANSparkMax(RobotMap.RIGHT_DRIVE_2);

  public DriveTrain() {
    rightMotor1.setInverted(true);
    rightMotor2.setInverted(true);
  }

  @Override
  public void initDefaultCommand() {
    
  }

  public void setMotors(double leftSpeed, double rightSpeed) {
    leftMotor1.setReference(leftSpeed, ControlType.kDutyCycle);
    leftMotor2.setReference(leftSpeed, ControlType.kDutyCycle);
    rightMotor1.setReference(rightSpeed, ControlType.kDutyCycle);
    rightMotor2.setReference(rightSpeed, ControlType.kDutyCycle);
  }
}
