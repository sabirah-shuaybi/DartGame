import java.awt.*;
import objectdraw.*;
import java.util.Random;

/**
 * BullsEye Class contains blueprint for creation of a bulls-eye, dictates the
 * three rings and their sizes, has certain assisting private method like
 * randomNumbers() and displayNumbers() to build construct of a dart game with points and
 * has a contains method and getScore which, when invoked by DartGame class, will keep tally of score.
 *
 * @author Sabirah Shuaybi
 * @version 10/23/16
 */
public class BullsEye
{
    //The three rings of a bulls-eye
    private FilledOval outerRing;
    private FilledOval middleRing;
    private FilledOval innerRing;

    //The randomly generated values (potential points) for each ring
    private int outerNumber;
    private int middleNumber;
    private int innerNumber;

    //Constants for the 3 rings
    private static final int OUTER_RADIUS = 90;
    private static final int MIDDLE_RADIUS = 60;
    private static final int INNER_RADIUS = 30;
    private static final int OUTER_DIAMETER = OUTER_RADIUS * 2;
    private static final int MIDDLE_DIAMETER = MIDDLE_RADIUS * 2;
    private static final int INNER_DIAMETER = INNER_RADIUS * 2;

    //Font size for each text object
    private static final int FONT_SIZE = 17;

    /* Constructor/Template for a BullsEye object.
    Takes a canvas, and two doubles as parameters */
    public BullsEye (DrawingCanvas canvas, double centerX, double centerY) {

        outerRing = new FilledOval(centerX-OUTER_RADIUS, centerY-OUTER_RADIUS, OUTER_DIAMETER, OUTER_DIAMETER, canvas);
        middleRing = new FilledOval(centerX-MIDDLE_RADIUS, centerY-MIDDLE_RADIUS, MIDDLE_DIAMETER, MIDDLE_DIAMETER, canvas);
        innerRing = new FilledOval(centerX-INNER_RADIUS, centerY-INNER_RADIUS, INNER_DIAMETER, INNER_DIAMETER, canvas);

        //Set color of outer ring to orange
        Color orange = new Color(255, 165, 0);
        outerRing.setColor(orange);

        //Set color of middle ring to green
        Color green = new Color(0, 255, 0);
        middleRing.setColor(green);

        //Set color of inner ring to yellow
        Color yellow = new Color(255, 255, 0);
        innerRing.setColor(yellow);

        //Display random values for each ring
        randomNumbers();
        displayNumbers(canvas);
    }

    /* Determines if mouse click is contained within BullsEye */
    public boolean contains(Location mouseClick) {

        //Checking for contains in outer ring suffices for entire BullsEye
        return (outerRing.contains(mouseClick));
    }

    /* Assigns a random int (1-10) to each of the ring value */
    private void randomNumbers() {

        Random r = new Random();

        //Add 1 to range (10) because 10 is exclusive and don't want any zeros
        outerNumber = r.nextInt(10)+1;
        middleNumber = r.nextInt(10)+1;
        innerNumber = r.nextInt(10)+1;
    }

    /* Creates 3 Text objects that diplay these random numbers in proper position
    within their designated ring */
    private void displayNumbers(DrawingCanvas canvas) {

        //Boolean argument for setBold method
        boolean bold = true;

        double outerTextX = outerRing.getX()+10;
        double outerTextY = outerRing.getY()+(outerRing.getHeight()/2)-10;
        Text outerText = new Text("" + outerNumber, outerTextX, outerTextY, canvas);
        //Format text
        outerText.setFontSize(FONT_SIZE);
        outerText.setBold(bold);

        double middleTextX = middleRing.getX()+10;
        double middleTextY = middleRing.getY()+(middleRing.getHeight()/2)-10;
        Text middleText = new Text("" + middleNumber, middleTextX, middleTextY, canvas);
        //Format text
        middleText.setFontSize(FONT_SIZE);
        middleText.setBold(bold);

        double innerTextX = innerRing.getX()+20;
        double innerTextY = innerRing.getY()+(innerRing.getHeight()/2)-10;
        Text innerText = new Text("" + innerNumber, innerTextX, innerTextY, canvas);
        //Format Text
        innerText.setFontSize(FONT_SIZE);
        innerText.setBold(bold);
    }

    /* Returns the corresponding point value of where user clicked within bulls-eye */
    public int getScore(Location mouseClick) {

        System.out.println("Entering getScore");

        //If user clicked inner ring, return the random point value for inner ring
        if (innerRing.contains(mouseClick)) {
            return innerNumber;
        }
        //If user clicked middle ring, return the random point value for middle ring
        if (middleRing.contains(mouseClick)) {
            return middleNumber;
        }
        //Else, return random point value for outer ring
        //(since this method won't be called unless click is contained somewhere within the bullseye)
        else {
            return outerNumber;
        }
    }
}
