package frc.team1569.commands

import edu.wpi.first.wpilibj.command.Command

import frc.team1569.Robot
import frc.team1569.RobotMap

/**
 *
 */
class TeleopCommand : Command() {
  init {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.driveTrainSubsystem)
    requires(Robot.liftSubsystem)
    requires(Robot.climbSubsystem)
  }

  // Called just before this Command runs the first time
  override fun initialize() {}

  // Called repeatedly when this Command is scheduled to run
  override fun execute() {
    //Tank drive
    Robot.driveTrainSubsystem.takeJoystickInputs(Robot.oi!!.getLeftJoystick(), Robot.oi!!.getRightJoystick())

    if (!Robot.liftSubsystem.movingToPosition)
      Robot.liftSubsystem.setLift(Robot.oi!!.getManipulator2Joystick().getY())

    //Claw open/close buttons
    if (Robot.oi!!.getManipulator1Joystick().getRawButton(RobotMap.extendPistonPort)) {
      Robot.clawSubsystem.setClawOpen()
    } else if (Robot.oi!!.getManipulator1Joystick().getRawButton(RobotMap.retractPistonPort)) {
      Robot.clawSubsystem.setClawClose()
    }

    //Tape control
    if (Robot.oi!!.getManipulator1Joystick().getRawButton(RobotMap.tapeOut)) {
      Robot.climbSubsystem.setTapeSpeed(0.55)
    } else if (Robot.oi!!.getManipulator1Joystick().getRawButton(RobotMap.tapeIn)) {
      Robot.climbSubsystem.setTapeSpeed(-0.55)
    } else {
      Robot.climbSubsystem.setTapeSpeed(0.0)
    }

    //Winch control
    if (Robot.oi!!.getManipulator1Joystick().getRawButton(RobotMap.winchIn)) {
      Robot.climbSubsystem.setWinchSpeed(1.0)
    } else if (Robot.oi!!.getManipulator1Joystick().getRawButton(RobotMap.winchOut)) {
      Robot.climbSubsystem.setWinchSpeed(-1.0)
    } else {
      Robot.climbSubsystem.setWinchSpeed(0.0)
    }

    //Claw rotation control
    if (!Robot.liftSubsystem.movingToPosition)
      Robot.clawSubsystem.setRotateClaw(Robot.oi!!.getManipulator1Joystick().y)
  }

  // Make this return true when this Command no longer needs to run execute()
  override fun isFinished(): Boolean {
    return false
  }

  // Make this return true when this Command no longer needs to run execute()
  override fun end() {
    Robot.driveTrainSubsystem.stopRobot()
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  override fun interrupted() {}
}