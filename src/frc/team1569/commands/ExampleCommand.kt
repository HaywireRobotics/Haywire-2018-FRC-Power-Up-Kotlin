package frc.team1569.commands

import edu.wpi.first.wpilibj.command.Command

import frc.team1569.Robot

/**
 *
 */
class ExampleCommand: Command() {
  init {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.exampleSubsystem)
  }

  // Called just before this Command runs the first time
  override fun initialize () {
    TODO("Not Implemented")
  }

  // Called repeatedly when this Command is scheduled to run
  override fun execute () {
    TODO("Not Implemented")
  }

  // Make this return true when this Command no longer needs to run execute()
  override fun isFinished (): Boolean {
    return false
  }

  // Make this return true when this Command no longer needs to run execute()
  override fun end () {
    TODO("Not Implemented")
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  override fun interrupted () {
    TODO("Not Implemented")
  }
}