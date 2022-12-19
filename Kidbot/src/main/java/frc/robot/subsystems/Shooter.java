// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

<<<<<<< Updated upstream
import static frc.robot.Constants.*;

import com.ctre.phoenix.CTREJNIWrapper;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import com.ctre.phoenix.motorcontrol.can.TalonSRXPIDSetConfiguration;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController; 

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

public class Shooter extends SubsystemBase {

  private static final Value kPistonRetractedValue = null;
  private static final Value kPistonExtendedValue = null;
  private static final String ShooterConstants = null;
  private final TalonSRX m_RightMotor;
private final TalonSRX m_LeftMotor;

private final RelativeEncoder m_encoder;

private final SparkMaxPIDController m_PidController;

private final DoubleSolenoid m_pistons;

private double kP, kI, kD, kIz, kFF, kMaxOutput, kMinOutput;
  /** Creates a new Shooter. */
  public Shooter() {
m_pistons= new DoubleSolenoid(3, null, 3, 0);

//instantiating the motors
  m_RightMotor = new TalonSRX(0);
  m_LeftMotor = new TalonSRX(1);
  
  motorInit(m_RightMotor);
  motorInit(m_LeftMotor);

  m_RightMotor.follow(m_LeftMotor);
  //m_encoder= ((CANSparkMax) LeftMotor).getEncoder();
  m_LeftMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 20);
  m_LeftMotor.setSelectedSensorPosition(0);
  m_LeftMotor.selectProfileSlot(0, 0);
  kP = ShooterConstants.kP;
  kI = ShooterConstants.kI;
  kD = ShooterConstants.kD;
  kIz = ShooterConstants.kIz;
  kFF = ShooterConstants.kFF;

  kMaxOutput = 1;
  kMinOutput = -1;


  FeedbackDevice.setP(kP);
  m_PidController.setI(kI);
  m_PidController.setD(kD);
  m_PidController.setIZone(kIz);
  m_PidController.setFF(kFF);
  m_PidController.setOutputRange(kMinOutput, kMaxOutput);

}



private void motorInit(TalonSRX motor) {
  motor.configFactoryDefault(); //Sets motors to defaults
  motor.setNeutralMode(NeutralMode.Coast); // 
}

  private void pistonInit() {
    retractPistons(); //initializes pistons
  }

  public void retractPistons() {
    m_pistons.set(kPistonRetractedValue); //retracts pistons
  }

  public void extendPistons() {
    m_pistons.set(kPistonExtendedValue); //extends the pistons
  }

  private void encoderInit() {
// Position starts at 0
m_encoder.setPosition(0);
//Velocity is in RPM
m_encoder.setVelocityConversionFactor(1);
  }


  public double getFlywheelSpeed() {
    return m_encoder.getVelocity(); //records velocity values from encoders
  }

  

 




=======
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
  /** Creates a new Shooter. */
  public Shooter() {}

  private final 
>>>>>>> Stashed changes


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
