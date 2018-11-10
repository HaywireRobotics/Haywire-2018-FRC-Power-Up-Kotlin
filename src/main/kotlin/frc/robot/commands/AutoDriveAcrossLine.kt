package frc.team1569.commands

import edu.wpi.first.wpilibj.command.CommandGroup

class AutoDriveAcrossLine : CommandGroup() {
  init {
    //Add commands here using: AddParallel or AddSequential
    addSequential(DriveForward(7.0, 0.5))
  }
}