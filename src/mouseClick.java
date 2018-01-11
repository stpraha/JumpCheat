import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.*;

public class mouseClick {
	private static int time = 0;
	
	public static void clickAndHode(int caledTime)
	{
		time = caledTime;
		if(time <100)
		{
			time = 300;
		}
		//BufferedImage screenCut = new BufferedImage();
		try
		{
			Robot robot = new Robot();
			robot.mouseMove(300, 300);
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.delay(time);
			robot.mouseRelease(InputEvent.BUTTON1_MASK);
			robot.delay(1500);
		}
		catch(AWTException e)
		{
			System.out.println(e);
		}
	}

}
