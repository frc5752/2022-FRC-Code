package frc.robot;

/**
* The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
* constants.  This class should not be used for any other purpose.  All constants should be
* declared globally (i.e. public static).  Do not put anything functional in this class.
*
* It is advised to statically import this class (or one of its inner classes) wherever the
* constants are needed, to reduce verbosity.
*/

public final class Constants {
    
    public class DrivingTrain{
        public static final int FRONT_RIGHT_ID = 3; // SPARK MAX DONT NOT CHANGE THESE VALUES!!!!
        public static final int FRONT_LEFT_ID = 1; // SPARK MAX
        public static final int BACK_RIGHT_ID = 4; // SPARK MAX
        public static final int BACK_LEFT_ID = 2; // SPARK MAX
    }
    
    
    public class Controls
    {
        public static final int DRIVER_CONTROLLER_MOVE_AXIS = 1; //not sure about these constants: Update they work now dont change these
        public static final int DRIVER_CONTROLLER_ROTATE_AXIS = 2; //2
        public static final int DRIVE_CONTROLS = 0;
    }
    
    
    public static final int kMCIDActuator = 1; //intake actuator motor controller id (TalonSRX)
    public static final int kMCIDSpinner= 2; //intake spinner motor controller id (VictorSPX)
    public static final int kMCIDUptake = 3; //uptake motor controller id (TalonSRX)
	public static final int kMCIDShooter = 5; //shooter motor controller id ( Spark max )
	public static final int kMCIDClimberMotor = 0; // PWM Spark plugged into PWM 0
	public static final int kMCIDDeployHookMotor = 1; // PWM Spark plugged into PWM 1
    
    public static final double kIntakeActuatorExtendSpeed = 0.6; // the speed of the motor that extends and retracts the intake arms (VictorSPX)
    public static final double kIntakeActuatorRetractSpeed = -0.6; // the speed of the motor that spins to bring a ball aboard (VictorSPX)
    public static final double kIntakeSpinnerSpeed = -1;  //the speed of the motor that spins to first grab the ball (VictorSPX)
    public static final double kUptakeSpeed = 0.75;  //0.75 the speed of the motor that spins to push the ball to the shooter motor (TalonSRX)
	public static final double kShooterSpeed = -0.7;  //the speed of the motor that spins to shoot the ball (CAN Spark)
    public static final double kShooterSpeedInAuto = -0.7; //the speed of the motor that spins to shoot the ball (CAN Spark)
	
	public static final double kDeployHookSpeedUp = 0.5;
	public static final double kDeployHookSpeedDown = -0.5;

	public static final double kClimberUpSpeed = 0.9;
	public static final double kClimberDownSpeed = -0.5;
    
    public static final int kIntakeExtendBtn = 6; //5
    public static final int kIntakeRetractBtn = 2; //3
    public static final int kSpinnerBtn = 1; //4
    public static final int kUptakeBtn = 3; //1
    public static final int kShootBtn = 5; //2
	public static final int kReverseUptakeBtn = 7;
	
	public static final int kDeployHookUpBtn = 10;
	public static final int kDeployHookDownBtn = 12;

	public static final int kClimbUpBtn = 9;
	public static final int kClimbDownBtn = 11;

    public static final int kFrontLimitSwitchDIOPort = 1;
    public static final int kBackLimitSwitchDIOPort = 0;
    
    

    // Joystick Buttons
    //      1
    //2  5  *  6
    //    3   4
    // 
    //  7  8
    //  9 10
    // 11 12
}
