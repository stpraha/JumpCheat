
public class JumpCheat {
	
	public static void main(String[] args)
	{

		//String src = "C:\\Users\\Administrator\\Desktop\\Jump1.bmp";
		for(int lop = 0; lop < 100; lop ++)
		{
			PicDeal picDeal = new PicDeal();
			mouseClick mClick = new mouseClick();
			ScreenCut sCut = new ScreenCut();
			int[][] data = sCut.ScreenCut();
		

			//double caledTime = picDeal.BmpCalTime(src);
			double caledTime = picDeal.screenCutDataCalTime(data);
			
			int holdTime = (int) (caledTime * 2675);
			mClick.clickAndHode(holdTime);
		}
	}
}