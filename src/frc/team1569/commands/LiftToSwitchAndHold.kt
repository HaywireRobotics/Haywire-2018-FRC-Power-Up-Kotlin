package frc.team1569.commands

import edu.wpi.first.wpilibj.command.CommandGroup

class LiftToSwitchAndHold : CommandGroup() {
  init {
    addSequential(LiftToSwitch())
    addSequential(HoldLift())
  }
}