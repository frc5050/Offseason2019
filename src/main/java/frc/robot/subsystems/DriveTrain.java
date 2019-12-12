/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.ArcadeDriveWithJoystick;

/**
 * An example subsystem. You can replace me with your own Subsystem.
 */
public class DriveTrain extends Subsystem {
  private CANSparkMax leftMotor1 = new CANSparkMax(RobotMap.LEFT_DRIVE_1, MotorType.kBrushless);
  private CANSparkMax leftMotor2 = new CANSparkMax(RobotMap.LEFT_DRIVE_2, MotorType.kBrushless);
  private CANSparkMax rightMotor1 = new CANSparkMax(RobotMap.RIGHT_DRIVE_1, MotorType.kBrushless);
  private CANSparkMax rightMotor2 = new CANSparkMax(RobotMap.RIGHT_DRIVE_2, MotorType.kBrushless);

  public DriveTrain() {
    rightMotor1.setInverted(true);
    rightMotor2.setInverted(true);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new ArcadeDriveWithJoystick());
  }

  public void drive() {
    double speed = Robot.oi.getRobotSpeed();
    double rotation = Robot.oi.getRobotRotation();

    if (Math.abs(speed) < 0.02) {
      speed = 0.0;
    }
    if (Math.abs(rotation) < 0.02) {
      rotation = 0.0;
    }

    double maxInput = Math.copySign(Math.max(Math.abs(speed), Math.abs(rotation)), speed);
    double leftMotorPower;
    double rightMotorPower;

    if (speed >= 0.0) {
      if (rotation >= 0.0) {
        leftMotorPower = maxInput;
        rightMotorPower = speed - rotation;
      } else {
        leftMotorPower = speed + rotation;
        rightMotorPower = maxInput;
      }
    } else {
      if (rotation >= 0.0) {
        leftMotorPower = speed + rotation;
        rightMotorPower = maxInput;
      } else {
        leftMotorPower = maxInput;
        rightMotorPower = speed - rotation;
      }
    }
    setMotors(leftMotorPower, rightMotorPower);
  }

  public void setMotors(double leftSpeed, double rightSpeed) {
    leftMotor1.set(leftSpeed);
    leftMotor2.set(leftSpeed);
    rightMotor1.set(rightSpeed);
    rightMotor2.set(rightSpeed);
  }
}
