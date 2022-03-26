package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;


public class UptakeAndShoot_group extends ParallelCommandGroup {
  public UptakeAndShoot_group() 
  {

    addCommands(
      new Uptake_timed(1),
      new SpinShooter_timed(2)
    );
  }
}
