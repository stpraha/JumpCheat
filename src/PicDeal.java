import java.util.*;
import java.awt.Graphics;
import java.io.*;

public class PicDeal 
{
//	public static void main(String args[])
//	{
//		String src = "C:\\Users\\Administrator\\Desktop\\Jump1.bmp";
//		String srcout = "C:\\Users\\Administrator\\Desktop\\Jumpout.bmp";
//		double distance = BmpCalTime(src,srcout);
//	}
//	
	public static double BmpCalTime(String src)
	{
		int[][] r = null;  
		int[][] g = null;  
		int[][] b = null;
		
		int nTopX = 0;
		int nTopY = 0;
		
		int oX = 0;
		int oY = 0;
		
		double distance = 0;
		double ratioDistance = 0;
		double allDistance = 0;
		
		try
		{
			FileInputStream inputPic = new FileInputStream(src);
			BufferedInputStream bmpPic = new BufferedInputStream(inputPic);

			bmpPic.skip(18);
			byte[] b1 = new byte[4];
			bmpPic.read(b1);
			byte[] b2 = new byte[4];
			bmpPic.read(b2);
			
			int bmpWidth = Math.abs(byte2Int(b1));		//图片宽度
			//System.out.printf("%s",b2[2]);
			int bmpHeight = Math.abs(byte2Int(b2));		//图片高度
			//System.out.println(b1 + "  " + b2);		//这两个是内存地址了。
			System.out.println(bmpWidth + "  " + bmpHeight);
			
			allDistance = bmpHeight;
			//

			//System.out.println(skipnum);
			
			r = new int[bmpHeight][bmpWidth];  
			g = new int[bmpHeight][bmpWidth];  
			b = new int[bmpHeight][bmpWidth];
			
			bmpPic.skip(28);
			
			int flag = 1;
			boolean flag2 = false;
			
			for(int i = 0; i < bmpHeight; i++)
			{
				for(int j = 0; j < bmpWidth; j++)
				{
				
					int blue = bmpPic.read();
					int green = bmpPic.read();
					int red = bmpPic.read();
				
//					if(476 > i && i > 474 && j < 183 && j > 181)
//					{
//						System.out.println(red +" " + green +" "+ blue);
//					}
					
					if(i > 300 && j > 10 && j < bmpWidth - 10)
					{
						if( flag == 1 && (Math.abs(red-r[i][j-1]) + Math.abs(green-g[i][j-1]) + Math.abs(blue-b[i][j-1])) > 20 )
						{
							nTopX = j;
							nTopY = i + 1;
							flag = 2;
							System.out.println(nTopX + "  " + nTopY);
						}
						
//						if( flag == 1 && (Math.abs(red-r[i][j-1]) + Math.abs(green-g[i][j-1]) + Math.abs(blue-b[i][j-1])) > 20 )
//						{
//							nTopX = j;
//							nTopY = i + 1;
//							flag = 2;
//							System.out.println(nTopX + "  " + nTopY);
//						}
						
						if( flag2 == false && red > 50 && red < 54 && green > 51 && green < 55 && blue > 58 && blue < 62)
						{
							oX = j;
							oY = i + 88;
							flag2 = true;
							System.out.println(oX + "  " + oY);
						}
					}
					
					r[i][j] = red;
					g[i][j] = green;
					b[i][j] = blue;

					int temp = bmpPic.read();
					//System.out.println(temp);
					
				}
			}
			
			bmpPic.close();
		}
		catch(IOException e)
		{
			System.out.println(e);
		}

		distance = 1.1557 * Math.abs(oX - nTopX);
		ratioDistance = distance/allDistance;
		System.out.println("distance = " + distance);	
		System.out.println("allDistance = " + allDistance);
		System.out.println("ratioDistance = " + ratioDistance);
		return ratioDistance;	
	}

	public static double screenCutDataCalTime(int[][] data)
	{
		
		int screenCutWidth = data.length;
		int screenCutHeight = data[0].length;
		
		int[][] r = null;  
		int[][] g = null;  
		int[][] b = null;
		
		int nTopX = 0;
		int nTopY = 0;
		
		int oX = 0;
		int oY = 0;
		
		double distance = 0;
		double ratioDistance = 0;
		double allDistance = 0;
				
		System.out.println("pic size: " + screenCutWidth + "  " + screenCutHeight);
			
		allDistance = screenCutHeight;
		//

		//System.out.println(skipnum);
			
		r = new int[screenCutHeight][screenCutWidth];  
		g = new int[screenCutHeight][screenCutWidth];  
		b = new int[screenCutHeight][screenCutWidth];
			
		int flag = 1;
		boolean flag2 = false;
			
		for(int i = 0; i < screenCutHeight; i++)
		{
			for(int j = 0; j < screenCutWidth; j++)
			{
				
//				int r = data[539][958] >> 16 & 0xFF;
//				int g = data[539][958] >> 8 & 0xFF;
//				int b = data[539][958] & 0xFF;
//				System.out.println(r + "  " + g + "  " + b);
				
				int red = data[j][i] >> 16 & 0xFF;
				int green = data[j][i] >> 8 & 0xFF;
				int blue = data[j][i] & 0xFF;
				
//				if(476 > i && i > 474 && j < 183 && j > 181)
//				{
//					System.out.println(red +" " + green +" "+ blue);
//				}
					
				if(i > 300 && j > 10 && j < screenCutWidth - 10)
				{
					if( flag == 1 && (Math.abs(red-r[i][j-1]) + Math.abs(green-g[i][j-1]) + Math.abs(blue-b[i][j-1])) > 20 )
					{
						nTopX = j;
						nTopY = i + 1;
						flag = 2;
						System.out.println("new location: " + nTopX + "  " + nTopY);
					}
						
					if( flag2 == false && red > 50 && red < 54 && green > 51 && green < 55 && blue > 58 && blue < 62)
					{
						oX = j;
						oY = i + 88;
						flag2 = true;
						System.out.println("old location: " + oX + "  " + oY);
					}
				}
					
				r[i][j] = red;
				g[i][j] = green;
				b[i][j] = blue;	
			}
		}
			
		distance = 1.1557 * Math.abs(oX - nTopX);
		ratioDistance = distance/allDistance;
		System.out.println("distance = " + distance);	
		System.out.println("allDistance = " + allDistance);
		System.out.println("ratioDistance = " + ratioDistance);
		return ratioDistance;	
	}
	private static int byte2Int(byte[] b)
	{
		int num=(b[3]&0xff)<<24|(b[2]&0xff)<<16|(b[1]&0xff)<<8|(b[0]&0xff);
        return num;
	}
	
}
