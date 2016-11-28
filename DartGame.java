import java.awt.*;
import objectdraw.*;
/**
 * Class DartGame extends WindowController and handles all mouse events.
 * It displays directions for how to play and a score label at begin method.
 * It also constructs two instances of BullsEye object in begin method
 * and keeps tally of aggregate score determined by where user clicks on board
 * (Hides the instructions once the game begins but displays them again on a mouse exit)
 * Finally, the program resets the score back to 0 on onMouseExit
 *
 * @author Sabirah Shuaybi
 * @version 10/23/16
 */
public class DartGame extends WindowController
{
    private Text directions;

    //Buffer space to keep spacing between Text objects neat and prevent overlapping
    private static final double BUFFER_SPACE = 20.0;

    private static final double DIR_LOCX = 10.0;
    private static final double DIR_LOCY = 20.0;

    private Text scoreCount;

    //Initializing score to 0
    private int score = 0;

    //The two bulls-eye objects
    private BullsEye bullsEyeLeft;
    private BullsEye bullsEyeRight;

    public void begin() {

        //Boolean argument for setBold method
        boolean bold = true;

        //Display the directions for how to play and make bold for enhanced visibility and aesthetics
        directions = new Text("Directions for play: click a bulls-eye to get points", DIR_LOCX, DIR_LOCY, canvas);
        directions.setBold(bold);

        //Display the score label underneath the directions
        double LABEL_LOCY = DIR_LOCY + directions.getHeight() + BUFFER_SPACE;
        Text scoreLabel = new Text("Score: ", DIR_LOCX, LABEL_LOCY, canvas);
        scoreLabel.setBold(bold);

        //Display the actual number score beside the score label
        //scoreCount is the actual number of total points besides score label, keeps updating
        double COUNT_LOCX = DIR_LOCX + scoreLabel.getWidth();
        scoreCount = new Text("0", COUNT_LOCX, LABEL_LOCY, canvas);
        scoreCount.setBold(bold);

        //Construct a left and a right bulls eye
        //Pass in a location that serves as the center around which each bullseye is constructed
        bullsEyeLeft = new BullsEye(canvas, 100, 200);
        bullsEyeRight = new BullsEye(canvas, 300, 200);
    }

    public void onMouseClick(Location point) {

        System.out.println("Entering onMouseClick");

        //If the left bulls-eye is clicked, do the following:
        //get corresponding random number and add it to score
        //set scoreCount to the newly updated score
        //make the directions disappear
        if(bullsEyeLeft.contains(point)) {
            score = score + bullsEyeLeft.getScore(point);
            scoreCount.setText(score);
            directions.hide();
        }
        //OR if the right bulls-eye is clicked, do the following:
        //get corresponding random number and add it to score
        //set scoreCount to the newly updated score
        //make the directions disappear
        else if(bullsEyeRight.contains(point)) {
            score = score + bullsEyeRight.getScore(point);
            scoreCount.setText(score);
            directions.hide();
        }
        //Else, if user clicks outside the two bulls-eyes, do the following:
        //subtract 1 from score because user has missed
        //set/display this new deducted score
        else
            score = score - 1;
            scoreCount.setText(score);
        }

    public void onMouseExit(Location point) {

        //If mouse exits canvas, reset score to zero
        score = 0;

        //Display this score of 0
        scoreCount.setText(score);

        //Display the directions again
        directions.show();
    }

}

