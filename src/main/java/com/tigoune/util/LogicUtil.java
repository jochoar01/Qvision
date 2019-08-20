package com.tigoune.util;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;





import javax.imageio.ImageIO;

public class LogicUtil {



	static Robot robot;

	public static int Expensive(int prices[]) {
		int expensive = 0;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] > expensive) {
				expensive = prices[i];
			}
		}

		return expensive;
	}

	public static void screenshot(String name) throws Exception {

		BufferedImage screenshot = new Robot()
				.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
//		Thread.sleep(2000);
		String path = name + ".jpg";
		File file = new File(path);
		ImageIO.write(screenshot, "jpg", file);

	}

	
    
	  

	
	
}
