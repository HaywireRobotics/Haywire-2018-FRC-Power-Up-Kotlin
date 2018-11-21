package frc.team1569.commands

import edu.wpi.first.wpilibj.command.CommandGroup
import frc.team1569.Robot


class AutoDriveScaleRight : CommandGroup() {
  init {
    if (Robot.gameData != null) {
    if (Robot.gameData!![1] == 'R') {
      addSequential(DriveForward(3.1, 0.8))
      addSequential(DriveLeftTurn(-77.0))
      addSequential(DriveForward(-2.3, 0.5))
    } else if (Robot.gameData!![0] == 'R') {
      addParallel(LiftToSwitchAndHold())
      addSequential(DriveForward(2.3, 0.7))
      addSequential(DriveLeftTurn(-75.0))
      addSequential(DriveForward(0.3, 0.5))
      addSequential(OpenClaw())
      addSequential(DriveForward(-1.5, 0.4))
    } else {
      addSequential(DriveForward(2.0, 0.8))
    }
  }
}
}