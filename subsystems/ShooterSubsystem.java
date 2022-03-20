package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class ShooterSubsystem extends SubsystemBase
{
    public static ShooterSubsystem instance = null;

    // The subsystem's hardware is defined here... 
    public static CANSparkMax mShooterMotor;
    public static WPI_TalonSRX mUptakeMotor;
   
    public ShooterSubsystem() // mkpellegrino 2022 03 14
    {
        mUptakeMotor = new WPI_TalonSRX(Constants.kMCIDUptake);
        mShooterMotor = new CANSparkMax(Constants.kMCIDShooter, MotorType.kBrushless);
    }
    
    
    // Subsystem methods - actions the robot can take - should be placed here.
    public void setUptakeMotor(double speed)
    {
        mUptakeMotor.set(ControlMode.PercentOutput, speed);
    }
    
    
    public void setShooterMotor(double speed)
    {
        mShooterMotor.set(speed);
    }
    
    public static ShooterSubsystem getInstance()
    {
        if( instance == null )
        {
            instance = new ShooterSubsystem();
        }
        return instance;
    }

    
    /** This method will be called once per scheduler run. */
    @Override
    public void periodic() 
    {
        
    }
    
    /** This method will be called once per scheduler run during simulation. */
    @Override
    public void simulationPeriodic() 
    {
        
    }
}