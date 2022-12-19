// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;




import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Index extends SubsystemBase {
  private static final double kLowerspeed = 0;
  private final CANSparkMax m_topIndexMotor;
private final CANSparkMax m_bottomIndexMotor;
private final DigitalInput m_upperBeamBreak;
private final DigitalInput m_lowerBeamBreak;

  /** Creates a new Index. */
  public Index() {
    m_topIndexMotor = new CANSparkMax(1, MotorType.kBrushless);
    m_bottomIndexMotor = new CANSparkMax(2, MotorType.kBrushless);

    m_lowerBeamBreak = new DigitalInput(3);
    m_upperBeamBreak = new DigitalInput(4);
  }

  //runs lower motor at given speed
public void runLowerMotor(double speed) {
  m_bottomIndexMotor.set(speed);
}
//runs upper motor at given speed
public void runUpperMotor(double speed) {
m_topIndexMotor.set(speed);
    }
    //reverses the index motors so that cargo is ejected.
    public void ejectIndex(double kEjectSpeed) {
      m_topIndexMotor.set(kEjectSpeed);
      m_bottomIndexMotor.set(kEjectSpeed);
    }
//stops the uppermotor at a given speed
    public void stopUpperMotor(double kSpeedStop){
      m_topIndexMotor.set(kSpeedStop);
    }
    //stops the lowermotor at a given speed

    public void stopLowerMotor(double kSpeedStop) {
      m_bottomIndexMotor.set(kSpeedStop);
    }
  //detects if upper part of the index has a ball and returns a true or false value
public boolean hasUpperBall() {
  return !m_upperBeamBreak.get(); 
}


//detects if lower part of the index has a ball and returns a true or false value
public boolean haslowerBall() {
  return !m_lowerBeamBreak.get(); 
}



  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
