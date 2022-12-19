// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import static frc.robot.Constants.driveTrainConstants.*;

public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */

  // declare motor variables
  private final WPI_TalonSRX m_leftMotor;
  private final WPI_TalonSRX m_rightMotor;

  private final DifferentialDrive m_drive;

  public Drivetrain() {

    // assign motor values
    m_rightMotor = new WPI_TalonSRX(kRightMotorDeviceNumber);
    m_leftMotor = new WPI_TalonSRX(kLeftMotorDeviceNumber);

    m_drive = new DifferentialDrive(m_leftMotor, m_rightMotor);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  // drives using tank drive
  public void tankDrive(double leftSpeed, double rightSpeed, boolean squareInputs) {
    m_drive.tankDrive(leftSpeed, rightSpeed, squareInputs);

  }

  // stop drive motors
  public void stopDrive() {
    m_drive.tankDrive(0, 0);
  }
}