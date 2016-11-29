# DartGame

This program contains two classes: __DartGame__ and __BullsEye__.

Class DartGame extends WindowController and handles all mouse events.
It displays directions for how to play and a score label at begin method.
It also constructs two instances of BullsEye object in begin method
and keeps tally of aggregate score determined by where user clicks on board
(Hides the instructions once the game begins but displays them again on a mouse exit)
Finally, the program resets the score back to 0 on onMouseExit
 
 __@author Sabirah Shuaybi__
 
 __@version 10/23/16__
