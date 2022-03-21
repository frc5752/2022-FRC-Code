package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class AutonomousCommand extends SequentialCommandGroup
{

    public AutonomousCommand(/* do the subsystems get passed in here? */)
    {
       addCommands(
        new SpinShooter_timed(2),        //   2 seconds
        new UptakeAndShoot_group(),      //   2 seconds
        new ArcadeDrive_timed(0.75, 3)// 1.5 seconds
        //turn aroun8vvd
        //new ExtendAndSpin_group(),       // 1.5 seconds
        //new SpinSpinner_timed(1),        //   1 second
        //new RetractAndSpin_group(),      // 1.5 seconds
        //new ArcadeDrive_timed(-0.75, 1.5), // 1.5 seconds
        //new SpinShooter_timed(2),        //   2 seconds
        //new UptakeAndShoot_group()       // + 2 seconds
       );                                // ===========
    }                                    //  15 seconds
}
