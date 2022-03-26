package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.IntakeSubsystem;

public class ExtendIntake extends CommandBase
{
    private static IntakeSubsystem mIntakeSubsystem;
    private Joystick mDriverController;

    public ExtendIntake(Joystick m_driver_controller)
    {
        mIntakeSubsystem = RobotContainer.m_intake;
        mDriverController = m_driver_controller;
        addRequirements(RobotContainer.m_intake);
    }
    
    @Override
    public void initialize()
    {
        /* check to see if the front limit switch returns
        true.  if it does, then DON'T set the motor, or
        set the motor to 0 */
        if( mIntakeSubsystem.frontLimitSwitch() ) return;

        mIntakeSubsystem.setActuatorMotor(Constants.kIntakeActuatorExtendSpeed);
    }
    
    @Override
    public void execute()
    {
    }
    
    @Override
    public boolean isFinished()
    {
		return (!mDriverController.getRawButton( Constants.kIntakeExtendBtn ) || mIntakeSubsystem.frontLimitSwitch() );
    }
    
    @Override
    public void end(boolean interrupted)
    {
        mIntakeSubsystem.setActuatorMotor(0);
    }
}
