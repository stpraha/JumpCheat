import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.image.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

import java.awt.*;

public class ScreenCut {
	private static int startX = 0;
	private static int startY = 0;
	private static int width = 0;
	private static int height = 0;
	
	private static String path = "";
	
	private static int[][] data = null;
	
	public static void main(String[] args)
	{
		ScreenCut();
	}
	
	public static int[][] ScreenCut()
	{
		startX = 7;
		startY = 45;
		width = 540;
		height = 960;
		
		
		path = "C:\\Users\\Administrator\\Desktop\\Jump1.bmp";
		data = getScreenCutData(startX, startY, width, height);
		
		storeAsBmp(path,data);
		
		return data;
	}
	
	public static int[][] getScreenCutData(int startX, int startY, int width, int height)
	{
		//time = caledTime;

		//BufferedImage screenCut = new BufferedImage();
		int[][] data = new int[width][height];
		try
		{
			Robot robot = new Robot();

			Rectangle screenRect = new Rectangle(startX,startY,width,height);
			BufferedImage screenCut = robot.createScreenCapture(screenRect);	
			
			//System.out.println(screenCut);
			
			for(int i = 0; i < width; i++)
			{
				for(int j = 0; j < height; j++)
				{
					data[i][j] = screenCut.getRGB(i, j);
				}
			}
			
			//screenCut.getRGB(0, 0, 540, 960, data, 0, 0);
		}
		catch(AWTException e)
		{
			System.out.println(e);
		}

		/*
		for(int i = 0; i < width; i++)
		{
			for(int j = 0; j < height; j++)
			{				
				System.out.println("i = " + i + "j = " + j + data[i][j]);
			}
		}
		*/
		return data;
		
//		int r = data[539][958] >> 16 & 0xFF;
//		int g = data[539][958] >> 8 & 0xFF;
//		int b = data[539][958] & 0xFF;
//		System.out.println(r + "  " + g + "  " + b);
	}
	
	
	/**//**
	* Title: BMP文件的头结构
	*
	* Description: BMP文件的头结构固定是14个字节，其定义如下：
	* 
	* byte[2] bfType; 指定文件类型，必须是0x424D，即字符串“BM”，也就是说所有.bmp文件的头两个字节都是“BM“
	* byte[4] bfSize; 指定文件大小，包括这14个字节
	* byte[2] bfReserved1; 保留字
	* byte[2] bfReserved2; 保留字
	* byte[4] bfOffBits; 为从文件头到实际的位图数据的偏移字节数
	*/
	public static void storeAsBmp(String path, int[][] data)
	{
		//byte[2] bfType;//
	}
}















