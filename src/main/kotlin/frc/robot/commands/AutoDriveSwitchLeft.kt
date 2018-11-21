package frc.team1569.commands

import edu.wpi.first.wpilibj.command.CommandGroup
import frc.team1569.Robot

class AutoDriveSwitchLeft : CommandGroup() {
  init {
    //Add commands here using: AddParallel or AddSequential
    if (Robot.gameData != null) {
      if (Robot.gameData!![0] == 'L') {
        addParallel(LiftToSwitchAndHold())
        addSequential(DriveForward(2.3, 0.7))
        addSequential(DriveRightTurn(90.0))
        addSequential(OpenClaw())
        addSequential(DriveForward(-1.5, 0.4))
      } else if (Robot.gameData!![1] == 'L') {
        addSequential(DriveForward(3.2, 0.8))
        addSequential(DriveRightTurn(77.0))
        addSequential(DriveForward(-1.6, 0.5))
      } else {
        addSequential(DriveForward(2.5, 0.8))
        addSequential(DriveRightTurn(74.0))
        addSequential(DriveForward(2.25, 0.8))
        addSequential(DriveLeftTurn(-87.0))
      }
    }
  }
}