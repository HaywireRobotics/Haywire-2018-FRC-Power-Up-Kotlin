package frc.team1569.commands

import edu.wpi.first.wpilibj.Timer
import edu.wpi.first.wpilibj.command.Command

import frc.team1569.Robot

/**
 *
 */
class DriveForward(seconds: Double, speed: Double): Command() {

  private val time: Timer = Timer()
  private var seconds: Double = seconds
  private var speed: Double = speed
  private var negative: Boolean = false

  init {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.exampleSubsystem)
    this.negative = (seconds < 0)
  }

  // Called just before this Command runs the first time
  override fun initialize() {
    this.time.reset()
    this.time.start()
    Robot.driveTrainSubsystem.drivingBackward = false
  }

  // Called repeatedly when this Command is scheduled to run
  override fun execute() {
    if(this.negative)
      Robot.driveTrainSubsystem.driveForward(speed)
    else
      Robot.driveTrainSubsystem.driveForward(-speed)
  }

  // Make this return true when this Command no longer needs to run execute()
  override fun isFinished(): Boolean {
    if (this.negative) {
      Robot.driveTrainSubsystem.drivingBackward = true
      return this.time.hasPeriodPassed(-seconds)
    } else {
      Robot.driveTrainSubsystem.drivingBackward = false
      return this.time.hasPeriodPassed(seconds)
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  override fun end() {
    if (negative)
      Robot.driveTrainSubsystem.drivingBackward = true
    Robot.driveTrainSubsystem.stopRobot()
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  override fun interrupted() {
    TODO("Not Implemented")
  }
}