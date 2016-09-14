import java.util.List;
import java.util.ArrayList;

public class Rectangle {
  private int mLength;
  private int mWidth;
  private static List<Rectangle> instances = new ArrayList<Rectangle>();

  public Rectangle(int length, int width) {
    mLength = length;
    mWidth = width;
    instances.add(this);
  }

  public int getLength() {
    return mLength;
  }

  public int getWidth() {
    return mWidth;
  }

  public boolean isSquare() {
    return mLength == mWidth;
  }

  public static List<Rectangle> allRectangles() {
    return instances;
  }

  public int area(){
    return mLength * mWidth;
  }
}
