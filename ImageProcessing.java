import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import acm.graphics.*;
import acm.program.*;
public class ImageProcessing extends GraphicsProgram {
	GImage MilkMaid = new GImage("The MilkMaid.jpg");
	public void run()
	{
		addMouseListeners();
		try {
			createGImage();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	private GImage flipHorizontal(GImage image) {
		int[][] array = image.getPixelArray();
		int width = array[0].length;
		int height = array.length;
		for (int row = 0; row < height; row++) {
			for (int p1 = 0; p1 < width / 2; p1++) {
				int p2 = width - p1 - 1;
				int temp = array[row][p1];
				array[row][p1] = array[row][p2];
				array[row][p2] = temp;
			}
		}
		return new GImage(array);
	}
	private void createGImage() throws FileNotFoundException{
		add(MilkMaid);
		System.out.println("Click to flip the MilkMaid horizontally");
	}
	public void mouseClicked(MouseEvent click) {
		add(flipHorizontal(MilkMaid));
	}
}