// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import static frc.robot.Constants.*;

import com.ctre.phoenix.CTREJNIWrapper;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import com.ctre.phoenix.motorcontrol.can.TalonSRXPIDSetConfiguration;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Shooter extends SubsystemBase {

  private static final Value kPistonRetractedValue = null;
  private static final Value kPistonExtendedValue = null;
  private final TalonSRX RightMotor;
private final TalonSRX LeftMotor;

private final RelativeEncoder m_encoder;

private final TalonSRXPIDSetConfiguration m

private final DoubleSolenoid m_pistons;
  /** Creates a new Shooter. */
  public Shooter() {
m_pistons= new DoubleSolenoid(3, null, 3, 0);

//instantiating the motors
  RightMotor = new TalonSRX(0);
  LeftMotor = new TalonSRX(1);
  motorInit(RightMotor);
  motorInit(LeftMotor);

  RightMotor.follow(LeftMotor);
  m_encoder= ((CANSparkMax) LeftMotor).getEncoder();
  }



private void motorInit(TalonSRX motor) {
  motor.configFactoryDefault(); //Sets motors to defaults
  motor.setNeutralMode(NeutralMode.Coast); // 
}

  private void pistonInit() {
    retractPistons();
  }

  public void retractPistons() {
    m_pistons.set(kPistonRetractedValue);
  }

  public void extendPistons() {
    m_pistons.set(kPistonExtendedValue);
  }

  private void encoderInit() {
// Position starts at 0
m_encoder.setPosition(0);
//Velocity is in RPM
m_encoder.setVelocityConversionFactor(1);
  }

  public double getFlywheelSpeed() {
    return m_encoder.getVelocity();
  }

  








  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
