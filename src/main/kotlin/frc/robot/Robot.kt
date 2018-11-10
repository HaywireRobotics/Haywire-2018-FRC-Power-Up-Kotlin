package frc.team1569

import edu.wpi.first.wpilibj.DriverStation
import edu.wpi.first.wpilibj.TimedRobot
import edu.wpi.first.wpilibj.command.Command
import edu.wpi.first.wpilibj.command.Scheduler
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard

import frc.team1569.commands.*
import frc.team1569.subsystems.*

class Robot: TimedRobot() {
  /**
   * "Static" class members
   */
  companion object {
    val exampleSubsystem: ExampleSubsystem = ExampleSubsystem()
    val driveTrainSubsystem: DriveTrainSubsystem = DriveTrainSubsystem()
    val liftSubsystem: LiftSubsystem = LiftSubsystem()
    val climbSubsystem: ClimbSubsystem = ClimbSubsystem()
    val clawSubsystem: ClawSubsystem = ClawSubsystem()
    var gameData: String? = null
    var oi: OI? = null
  }

  var autonomousCommand: Command? = null
  var autoChooser: SendableChooser<Command> = SendableChooser()

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  override fun robotInit() {
    oi = OI()
    autoChooser.addDefault("Default Auto", ExampleCommand())
    autoChooser.addDefault("Default Auto", AutoDriveAcrossLine())
    autoChooser.addObject("DriveAcrossLine", AutoDriveAcrossLine())
    autoChooser.addObject("DriveSwitchLeft", AutoDriveSwitchLeft())
    autoChooser.addObject("DriveSwitchRight", AutoDriveSwitchRight())
    autoChooser.addObject("DriveSwitchCenter", AutoDriveSwitchCenter())
    autoChooser.addObject("DriveScaleRight", AutoDriveScaleRight())
    autoChooser.addObject("DriveScaleLeft", AutoDriveScaleLeft())
    SmartDashboard.putData("Auto mode", autoChooser)
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
   */
  override fun disabledInit() {}

  override fun disabledPeriodic () = Scheduler.getInstance().run()

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString code to get the auto name from the text box below the Gyro
   *
   * You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  override fun autonomousInit() {
    autonomousCommand = autoChooser.selected
    gameData = DriverStation.getInstance().gameSpecificMessage
    autoChooser.selected?.start()
  }

  /**
   * This function is called periodically during autonomous
   */
  override fun autonomousPeriodic() = Scheduler.getInstance().run()

  override fun teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    //TODO: This line needed to be changed to .cancel() from .start()
    autonomousCommand?.cancel()

    TeleopCommand().start()
  }

  /**
   * This function is called periodically during operator control
   */
  override fun teleopPeriodic() = Scheduler.getInstance().run()

  /**
   * This function is called periodically during test mode
   */
  override fun testPeriodic() {}
}