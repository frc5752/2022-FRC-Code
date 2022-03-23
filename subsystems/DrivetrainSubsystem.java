
package frc.robot.subsystems;

import frc.robot.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

public class DrivetrainSubsystem extends SubsystemBase
{
  public static DrivetrainSubsystem instance = null;
  
  private CANSparkMax frontRightMotor;
  private CANSparkMax frontLeftMotor;
  private CANSparkMax backRightMotor;
  private CANSparkMax backLeftMotor;

  DifferentialDrive differentialDrive;
  
  
  public DrivetrainSubsystem()
  {
    
    //settings motors
    frontRightMotor = new CANSparkMax(Constants.DrivingTrain.FRONT_RIGHT_ID, MotorType.kBrushless);
    frontLeftMotor = new CANSparkMax(Constants.DrivingTrain.FRONT_LEFT_ID, MotorType.kBrushless);
    backRightMotor = new CANSparkMax(Constants.DrivingTrain.BACK_RIGHT_ID, MotorType.kBrushless);
    backLeftMotor = new CANSparkMax(Constants.DrivingTrain.BACK_LEFT_ID, MotorType.kBrushless);
    
    MotorControllerGroup rightMotors = new MotorControllerGroup(frontRightMotor, backRightMotor);
    MotorControllerGroup leftMotors = new MotorControllerGroup(frontLeftMotor, backLeftMotor);
    
	differentialDrive = new DifferentialDrive(rightMotors, leftMotors);
	
  }
  
  public void arcadeDrive(double moveSpeed, double rotateSpeed)
  {
    differentialDrive.arcadeDrive(moveSpeed, rotateSpeed);
  }
  
  public static DrivetrainSubsystem getInstance()
  {
    if( instance == null )
    {
      instance = new DrivetrainSubsystem();
    }
    return instance;
  }
  
  @Override
  public void periodic() 
  {
	// This method will be called once per scheduler run
  }
}
