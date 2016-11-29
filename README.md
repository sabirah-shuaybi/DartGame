# DartGame

This program contains two classes: __DartGame__ and __BullsEye__.

The __DartGame__ class extends WindowController and handles all mouse events.
It displays directions for how to play and a score label at begin method.
It also constructs two instances of BullsEye object in begin method
and keeps tally of aggregate score determined by where user clicks on board
(Hides the instructions once the game begins but displays them again on a mouse exit)
Finally, the program resets the score back to 0 on onMouseExit

The __BullsEye__ Class contains the blueprint for creation of a bulls-eye, dictates the
three rings and their sizes, has certain assisting private method like
randomNumbers() and displayNumbers() to build construct of a dart game with points and
has a contains method and getScore which, when invoked by DartGame class, will keep tally of score.
 
 __@author Sabirah Shuaybi__
 
 __@version 10/23/16__
