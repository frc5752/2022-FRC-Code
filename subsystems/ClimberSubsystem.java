package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.Spark;

/* this subsystem is for the 2 motors that control the intake of a ball */
/* there's a motor that spins to get the ball - called the 'spinner' */
/* there's a motor that controls the extending and retracting of the arms */
/* it's called the actuator */
public class ClimberSubsystem extends SubsystemBase 
{
  public static ClimberSubsystem instance;
  public static Spark mClimberMotor;
  public static CANSparkMax mDeployHookMotor;
  // constructor
  public ClimberSubsystem()
  {
	//motor
	mClimberMotor = new Spark( Constants.kMCIDClimberMotor);
	mDeployHookMotor = new CANSparkMax(Constants.kMCIDDeployHookMotor, MotorType.kBrushless);
	}
  
  // Subsystem methods - actions the robot can take - should be placed here.
  public void setClimberMotor(double speed)
  {
  	mClimberMotor.set( speed );
  }

  public void setDeployHookMotor(double speed)
  {
	  mDeployHookMotor.set( speed );
  }

  public static ClimberSubsystem getInstance()
  {
	  if( instance == null )
	  {
		  instance = new ClimberSubsystem();
	  }
	  return instance;
  }

  @Override
  public void periodic() 
  {
	// This method will be called once per scheduler run
  }
  
  @Override
  public void simulationPeriodic() 
  {
	// This method will be called once per scheduler run during simulation
  }
}