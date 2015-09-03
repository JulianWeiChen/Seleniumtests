package au.com.vclass.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class DrawUtil {
	public static void draw(WebDriver driver, int x1, int y1, int x2, int y2) {
		Actions moveCell = new Actions(driver);

		moveCell.build();
		// moveCell.moveByOffset(20, 20);//move mouse to upper left corner of
		// graph
		moveCell.moveByOffset(x1, y1);// move mouse to cell we want to move
		moveCell.clickAndHold();// select cell and hold it
		moveCell.moveByOffset(x2, y2);// drag cell
		moveCell.release();// drop it
		moveCell.perform();// run this set of actions
	}
}
