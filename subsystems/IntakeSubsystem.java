  package frc.robot.subsystems;

  import edu.wpi.first.wpilibj2.command.SubsystemBase;
  import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.DigitalInput;

  /* this subsystem is for the 2 motors that control the intake of a ball */
  /* there's a motor that spins to get the ball - called the 'spinner' */
  /* there's a motor that controls the extending and retracting of the arms */
  /* it's called the actuator */
  public class IntakeSubsystem extends SubsystemBase 
  {
    public static IntakeSubsystem instance;
    public static WPI_VictorSPX mSpinnerMotor;
    public static WPI_TalonSRX mActuatorMotor;
    
    //limit switches
    public static DigitalInput mFrontLimitSwitch;
    public static DigitalInput mBackLimitSwitch;

    // constructor
    public IntakeSubsystem()
    {
      //motors
      mSpinnerMotor = new WPI_VictorSPX( Constants.kMCIDSpinner );
      mActuatorMotor = new WPI_TalonSRX( Constants.kMCIDActuator );
      
      //limit switches 
      //!!CHECK THE PORTS ON THE LIMIT SWITCHES TO MAKE SURE THEY ARE RIGHT!!
      //we can set the port values as Constants later if we want to
      mFrontLimitSwitch = new DigitalInput(Constants.kFrontLimitSwitchDIOPort); //set port value here
      mBackLimitSwitch = new DigitalInput(Constants.kBackLimitSwitchDIOPort); //set port value here
    }
    
    // Subsystem methods - actions the robot can take - should be placed here.
    public void setActuatorMotor(double speed)
    {
    //was initially just this
    mActuatorMotor.set(ControlMode.PercentOutput, speed);
    } 
	public boolean frontLimitSwitch()
	{
		return mFrontLimitSwitch.get();
	}

	public boolean backLimitSwitch()
	{
		return mBackLimitSwitch.get();
	}

  public void setSpinnerMotor(double speed)
    {
      mSpinnerMotor.set(ControlMode.PercentOutput, speed);
    }
    
    public static IntakeSubsystem getInstance()
    {
        if( instance == null )
        {
            instance = new IntakeSubsystem();
        }
        return instance;
    }

    @Override
    public void periodic() 
    {
    }
    
    @Override
    public void simulationPeriodic() 
    {
    }
  }