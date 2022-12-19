// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {

  private static final double kintakeMotorSpeed = 0;
  private static final double kintakeMotorStop = 0;
  private static final Value kPistonExtendedValue = null;
  private static final Value kPistonRetractedValue = null;
  private final CANSparkMax m_intakeMotor;
  private final DoubleSolenoid m_intakePiston;
  /** Creates a new Intake. */
  public Intake() {
    m_intakeMotor = new CANSparkMax(6, MotorType.kBrushless);

    m_intakePiston = new DoubleSolenoid(1, null, 2, 3); //need to edit values
  }
// runs/starts the intake motor at given speed
public void runIntake(){
  m_intakeMotor.set(kintakeMotorSpeed);
}
// reverses the intake motor at given speed
public void ejectIntake() {
  m_intakeMotor.set(-kintakeMotorSpeed);
}
//stops the intake motor at given speed
public void stopIntake() { 
  m_intakeMotor.set(kintakeMotorStop);
}
//extends piston by certain value
public void extendPistons(){ 
  m_intakePiston.set(kPistonExtendedValue); 
}
//retracts piston by certain value
public void retractPistons() { 
  m_intakePiston.set(kPistonRetractedValue);
}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
