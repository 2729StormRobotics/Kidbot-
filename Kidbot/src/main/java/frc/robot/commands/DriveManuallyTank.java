// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class DriveManuallyTank extends CommandBase {

  /** Creates a new DriveManuallyTank. */
  private final Drivetrain m_drivetrain;

  private final double m_leftSpeed; // in prior years they used doubleSupplier but unclear why
  private final double m_rightSpeed;

  public DriveManuallyTank(Drivetrain subsystem, double leftSpeed, double rightSpeed) {
    // Use addRequirements() here to declare subsystem dependencies.

    m_drivetrain = subsystem;

    m_leftSpeed = leftSpeed;
    m_rightSpeed = rightSpeed;

    addRequirements(m_drivetrain);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_drivetrain.stopDrive();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drivetrain.tankDrive(m_leftSpeed, m_rightSpeed, true);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drivetrain.stopDrive();

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
