// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class Drivetrain extends SubsystemBase {
  private DifferentialDrive diffDrive;

  private WPI_TalonSRX frontLeftMotor = new WPI_TalonSRX(DriveConstants.FRONT_LEFT);
  private WPI_TalonSRX frontRightMotor = new WPI_TalonSRX(DriveConstants.FRONT_RIGHT);
  private WPI_TalonSRX backLeftMotor = new WPI_TalonSRX(DriveConstants.BACK_LEFT);
  private WPI_TalonSRX backRightMotor = new WPI_TalonSRX(DriveConstants.BACK_RIGHT);

  /** Creates a new Drivetrain. */
  public Drivetrain() {
    frontLeftMotor.setInverted(true);
    backLeftMotor.setInverted(true);

    backLeftMotor.follow(frontLeftMotor);
    backRightMotor.follow(frontRightMotor);

    frontLeftMotor.setSafetyEnabled(false);
    frontRightMotor.setSafetyEnabled(false);
    backLeftMotor.setSafetyEnabled(false);
    backRightMotor.setSafetyEnabled(false);

    diffDrive = new DifferentialDrive(frontLeftMotor, frontRightMotor);
  }

  /**
   * Drives the robot using arcade controls.
   *
   * @param fwd the commanded forward movement
   * @param rot the commanded rotation
   */
  public void arcadeDrive(double fwd, double rot) {
    diffDrive.arcadeDrive(fwd, rot, true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
