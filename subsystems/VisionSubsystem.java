package frc.robot.subsystems;

import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.CvSink;
import edu.wpi.first.cscore.CvSource;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class VisionSubsystem extends SubsystemBase
{
    public static Thread m_visionThread;
    public static VisionSubsystem instance = null;
    public static String my_string;
    public VisionSubsystem()
    {
        m_visionThread = new Thread( () ->
        {
            UsbCamera camera = CameraServer.startAutomaticCapture();
            camera.setResolution(640, 480);
            CvSink cvSink = CameraServer.getVideo();
            CvSource outputStream = CameraServer.putVideo("Processed Stream",640,480);
            Mat mat=new Mat();
            while (!Thread.interrupted())
            {
                if( cvSink.grabFrame(mat) == 0)
                {
                    outputStream.notifyError(cvSink.getError());
                    continue;
                }
                //Imgproc.rectangle(mat, new Point(0,0), new Point(1280,75), new Scalar(0,0,0),-1);
                //Imgproc.putText( mat, my_string, new Point(30,40), Imgproc.FONT_HERSHEY_COMPLEX_SMALL, 2, new Scalar( 255, 255, 255 ));
                outputStream.putFrame(mat);
            }
        });
        m_visionThread.setDaemon(true);
        m_visionThread.start();
    }

    public void setString( String s )
    {
        my_string = s;
    }

    public static VisionSubsystem getInstance()
    {
        if( instance == null )
        {
            instance = new VisionSubsystem();
        }
        return instance;
    }

    @Override
    public void periodic() 
    {
        // This method will be called once per scheduler run
    }
    
    @Override
    public void simulationPeriodic() 
    {
        // This method will be called once per scheduler run during simulation
    }
}
