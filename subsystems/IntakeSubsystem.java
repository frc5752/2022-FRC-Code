  package frc.robot.subsystems;

  import edu.wpi.first.wpilibj2.command.SubsystemBase;
  import frc.robot.Constants;

  import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
//import edu.wpi.first.wpilibj.DigitalInput;

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
    //public static DigitalInput mFrontLimitSwitch;
    //public static DigitalInput mBackLimitSwitch;

    // constructor
    public IntakeSubsystem()
    {
      //motors
      mSpinnerMotor = new WPI_VictorSPX( Constants.kMCIDSpinner );
      mActuatorMotor = new WPI_TalonSRX( Constants.kMCIDActuator );
      
      //limit switches 
      //!!CHECK THE PORTS ON THE LIMIT SWITCHES TO MAKE SURE THEY ARE RIGHT!!
      //we can set the port values as Constants later if we want to
      //mFrontLimitSwitch = new DigitalInput(1); //set port value here
      //mBackLimitSwitch = new DigitalInput(0); //set port value here
    }
    
    // Subsystem methods - actions the robot can take - should be placed here.
    public void setActuatorMotor(double speed)
    {
    //was initially just this
    mActuatorMotor.set(ControlMode.PercentOutput, speed);


    //new stuff starts here
    //if (speed < 0) {  //checks if acutator is retracting (speed is negative)
    //  if (mBackLimitSwitch.get()) { //checks if back limit switch is hit
    //    mActuatorMotor.set(ControlMode.PercentOutput, 0); //sets motor to 0% speed if limit switch is tripped
    //    } else {  //if the limit switch was not hit, acutator retracts
    //    mActuatorMotor.set(ControlMode.PercentOutput, speed); //sets the motor to retract speed
    //  }

    //} else {  //if the actuator is extending (speed is positive)
    //  if (mFrontLimitSwitch.get()) { //checks if front limit switch is hit
    //    mActuatorMotor.set(ControlMode.PercentOutput, 0); //sets motor to 0% speed if limit switch is tripped
    //    } else {  //if the l  imit switch was not hit, acutator extends
    //    mActuatorMotor.set(ControlMode.PercentOutput, speed); //sets the motor to extend speed
    //  }
    //}
    //new stuff ends here
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
      // This method will be called once per scheduler run
    }
    
    @Override
    public void simulationPeriodic() 
    {
      // This method will be called once per scheduler run during simulation
    }
  }