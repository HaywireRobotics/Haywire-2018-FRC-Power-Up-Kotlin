package frc.team1569.commands

import edu.wpi.first.wpilibj.command.Command

import frc.team1569.Robot

/**
 *
 */
class OpenClaw : Command() {
  init {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.clawSubsystem)
  }

  // Called just before this Command runs the first time
  override fun initialize() {}

  // Called repeatedly when this Command is scheduled to run
  override fun execute() {
    Robot.clawSubsystem.setClawOpen()
  }

  // Make this return true when this Command no longer needs to run execute()
  override fun isFinished(): Boolean {
    return true
  }

  // Make this return true when this Command no longer needs to run execute()
  override fun end() {}
}