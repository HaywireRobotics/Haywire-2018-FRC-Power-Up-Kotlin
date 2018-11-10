package frc.team1569

import edu.wpi.cscore.UsbCamera
import edu.wpi.first.wpilibj.CameraServer
import edu.wpi.first.wpilibj.Joystick
import edu.wpi.first.wpilibj.buttons.Button
import edu.wpi.first.wpilibj.buttons.JoystickButton

import frc.team1569.commands.ExampleCommand

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
class OI {
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // val stick: Joystick = Joystick(port)
  // val button: Button = JoystickButton(stick, buttonNumber)

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(ExampleCommand())

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(ExampleCommand())

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(ExampleCommand())
  private var stickLeft: Joystick
  private var stickRight: Joystick
  private var stickManipulate1: Joystick
  private var stickManipulate2: Joystick
  private var camera: UsbCamera
  private var camera1: UsbCamera

  init {
    this.stickLeft = Joystick(RobotMap.joystickLeftPort)
    this.stickRight = Joystick(RobotMap.joystickRightPort)
    this.stickManipulate1 = Joystick(RobotMap.joystickManipulator0Port)
    this.stickManipulate2 = Joystick(RobotMap.joystickManipulator1Port)

    this.camera = CameraServer.getInstance().startAutomaticCapture()
    this.camera.setResolution(640, 480)
    this.camera.setFPS(15)
    this.camera.setExposureAuto()

    this.camera1 = CameraServer.getInstance().startAutomaticCapture()
    this.camera1.setResolution(640, 480)
    this.camera1.setFPS(15)
    this.camera1.setExposureAuto()
  }

  fun getLeftJoystick(): Joystick = this.stickLeft

  fun getRightJoystick(): Joystick = this.stickRight

  fun getManipulator1Joystick(): Joystick = this.stickManipulate1

  fun getManipulator2Joystick(): Joystick = this.stickManipulate2

}