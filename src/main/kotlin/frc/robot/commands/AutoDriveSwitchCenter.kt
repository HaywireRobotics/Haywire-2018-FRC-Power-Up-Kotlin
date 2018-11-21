package frc.team1569.commands

import edu.wpi.first.wpilibj.command.CommandGroup
import frc.team1569.Robot


class AutoDriveSwitchCenter : CommandGroup() {
  init {
    if (Robot.gameData != null) {
    if (Robot.gameData!![0] == 'L') {
      addSequential(DriveForward(1.0, 0.5))
      addSequential(DriveLeftTurn(-32.5))

      addParallel(LiftToSwitchAndHold())
      addSequential(DriveForward(3.5, 0.5))
      addSequential(DriveRightTurn(32.5))

      addSequential(DriveForward(0.5, 0.5))
      addSequential(OpenClaw())
      addSequential(DriveForward(-1.0, 0.5))
    } else if (Robot.gameData!![0] == 'R') {
      addSequential(DriveForward(0.8, 0.5))
      addSequential(DriveRightTurn(40.0))

      addParallel(LiftToSwitchAndHold())
      addSequential(DriveForward(2.0, 0.5))
      addSequential(DriveLeftTurn(-31.5))

      addSequential(DriveForward(2.0, 0.5))
      addSequential(OpenClaw())
      addSequential(DriveForward(-1.0, 0.5))
    }
  }
}
}