package src.Chess;

import org.junit.Assert;
import org.junit.Test;

/*******************************************************************************************************************
 * This class tests  the various components of the class ChessModel, as well as the different pieces to ensure that
 * the ChessModel class will be able to run as a working game of Chess.
 * @author Tristan Kingsley, Trevor Spitzley, Kyle Kukla
 * @version Spring 2019
 ******************************************************************************************************************/
public class ChessModelTest {

    @Test
    public void testWhitePawn() {
        ChessModel game = new ChessModel();
        // create move for black pawn
        Move m = new Move(6,2,5,2);
        // check if move is valid
        Assert.assertTrue(game.isValidMove(m));
        // move piece
        game.move(m);
        Assert.assertEquals("Pawn",game.pieceAt(5,2).type());
    }

    @Test
    public void testWhiteKnight() {
        ChessModel game = new ChessModel();
        // create move for white knight
        Move m = new Move(7,1,5,2);
        // check if move is valid
        Assert.assertTrue(game.isValidMove(m));
        // move piece
        game.move(m);
        Assert.assertEquals("Knight", game.pieceAt(5,2).type());
    }

    @Test
    public void testWhiteRook() {
        ChessModel game = new ChessModel();
        // move pawn out of the way of rook
        game.move(new Move(6,0,4,0));
        // create move for white rook
        Move m2 = new Move(7,0,5,0);
        // check if move is valid
        Assert.assertTrue(game.isValidMove(m2));
        // move piece
        game.move(m2);
        Assert.assertEquals("Rook", game.pieceAt(5,0).type());
    }

    @Test
    public void testWhiteBishop() {
        ChessModel game = new ChessModel();
        // move pawn out of the way of bishop
        game.move(new Move(6,3,5,3));
        // create move for white bishop
        Move m2 = new Move(7,2,3,6);
        // check if move is valid
        Assert.assertTrue(game.isValidMove(m2));
        // move piece
        game.move(m2);
        Assert.assertEquals("Bishop", game.pieceAt(3,6).type());
    }

    @Test
    public void testWhiteQueen() {
        ChessModel game = new ChessModel();
        // move pawn out of the way of queen
        game.move(new Move(6,2,5,2));
        // create move for white queen
        Move m2 = new Move(7,3,4,0);
        // check if move is valid
        Assert.assertTrue(game.isValidMove(m2));
        // move piece
        game.move(m2);
        Assert.assertEquals("Queen", game.pieceAt(4,0).type());
    }

    @Test
    public void testWhiteKing() {
        ChessModel game = new ChessModel();
        // move pawn out of the way of king
        game.move(new Move(6,3,5,3));
        // create move for king
        Move m2 = new Move(7,4,6,3);
        // checks if move is valid
        Assert.assertTrue(game.isValidMove(m2));
        // move piece
        game.move(m2);
        Assert.assertEquals("King", game.pieceAt(6,3).type());
    }

    @Test
    public void testCastlingRight() {
        ChessModel game = new ChessModel();
        // move pawn out of way of bishop
        game.move(new Move(6,4,4,4));
        // move knight
        game.move(new Move(7,6,5,7));
        // move bishop
        game.move(new Move(7,5,5,3));
        // check if castling to the right is possible
        Assert.assertTrue(game.canCastleRight(Player.WHITE));
        // preform castling
        game.castleRight(Player.WHITE);
    }

    @Test
    public void testCastlingLeft(){
        ChessModel game = new ChessModel();
        // move pawn forward
        game.move(new Move(6, 3, 4, 3));
        // move bishop out
        game.move(new Move(7, 2, 5, 4));
        // move queen forward
        game.move(new Move(7, 3, 5, 3));
        // move bishop out ahead of pawns
        game.move(new Move(7, 1, 5, 2));
        // check if castling to the left is possible
        Assert.assertTrue(game.canCastleLeft(Player.WHITE));
        // preform castling
        game.castleLeft(Player.WHITE);
    }

    @Test
    public void testBlackPawn() {
        // create game with ChessPanel to be able to use buttons
        ChessPanel game = new ChessPanel();
        // set mode to two players
        game.twoPlayer.setSelected(true);
        // move white pawn
        game.model.move(new Move(6,4,5,4));
        game.model.setNextPlayer();
        // create move for black pawn
        Move m = new Move(1,4,2,4);
        // check if move is valid
        Assert.assertTrue(game.model.isValidMove(m));
        // move piece
        game.model.move(m);
        Assert.assertEquals("Pawn", game.model.pieceAt(2,4).type());
    }

    @Test
    public void testBlackKnight() {
        // create game with ChessPanel to be able to use buttons
        ChessPanel game = new ChessPanel();
        // set mode to two players
        game.twoPlayer.setSelected(true);
        // move white pawn
        game.model.move(new Move(6,0,4,0));
        game.model.setNextPlayer();
        // create move for black knight
        Move m = new Move(0,1,2,0);
        // check is move is valid
        Assert.assertTrue(game.model.isValidMove(m));
        // move piece
        game.model.move(m);
        Assert.assertEquals("Knight", game.model.pieceAt(2,0).type());
    }

    @Test
    public void testBlackBishop() {
        // create game with ChessPanel to be able to use buttons
        ChessPanel game = new ChessPanel();
        // set mode to two players
        game.twoPlayer.setSelected(true);

        //white pawn move
        game.model.move(new Move(6,0,4,0));
        game.model.setNextPlayer();

        // black pawn move
        game.model.move(new Move(1,3,3,3));
        game.model.setNextPlayer();

        // white pawn move
        game.model.move(new Move (4,0,3,0));
        game.model.setNextPlayer();

        // black bishop move
        Move m = new Move(0,2,3,5);
        Assert.assertTrue(game.model.isValidMove(m));
        // move piece
        game.model.move(m);
        Assert.assertEquals("Bishop", game.model.pieceAt(3,5).type());
    }

    @Test
    public void testBlackRook() {
        // create game with ChessPanel to be able to use buttons
        ChessPanel game = new ChessPanel();
        // set mode to two players
        game.twoPlayer.setSelected(true);
        // move white pawn
        game.model.move(new Move(6,0,4,0));
        game.model.setNextPlayer();

        // move black pawn out of way of rook
        game.model.move(new Move(1,0,3,0));
        game.model.setNextPlayer();

        // move white pawn
        game.model.move(new Move(4,0,3,0));
        game.model.setNextPlayer();

        // create move for black rook
        Move m = new Move(0,0,2,0);
        // check if move is valid
        Assert.assertTrue(game.model.isValidMove(m));
        // move piece
        game.model.move(m);
        Assert.assertEquals("Rook", game.model.pieceAt(2,0).type());
    }

    @Test
    public void testBlackQueen() {
        // create game with ChessPanel to be able to use buttons
        ChessPanel game = new ChessPanel();
        game.twoPlayer.setSelected(true);
        // white moves pawn forward
        game.model.move(new Move(6,0,4,0));
        game.model.setNextPlayer();

        // black moves pawn forward
        game.model.move(new Move(1,2,2,2));
        game.model.setNextPlayer();

        // white moves pawn forward
        game.model.move(new Move(4,0,3,0));
        game.model.setNextPlayer();

        // creates move for black queen
        Move m = new Move(0,3,3,0);
        // checks if move is valid
        Assert.assertTrue(game.model.isValidMove(m));
        // move piece
        game.model.move(m);
        Assert.assertEquals("Queen", game.model.pieceAt(3,0).type());
    }

    @Test
    public void testBlackKing() {
        // create game with ChessPanel to be able to use buttons
        ChessPanel game = new ChessPanel();

        // white moves pawn forward
        game.model.move(new Move(6,0,4,0));
        game.model.setNextPlayer();

        // black moves pawn out of kings way
        game.model.move(new Move(1,3,2,3));
        game.model.setNextPlayer();

        // white moves pawn forward
        game.model.move(new Move(4,0,3,0));
        game.model.setNextPlayer();

        // create move for black king
        Move m = new Move(0,4,1,3);
        // checks if move is valid
        Assert.assertTrue(game.model.isValidMove(m));
        // move piece
        game.model.move(m);
        Assert.assertEquals("King", game.model.pieceAt(1,3).type());
    }

    @Test
    public void testNotYourTurn(){
        ChessModel game = new ChessModel();
        //black move when it is white's turn
        Move m = new Move(1, 0, 2, 0);
        game.move(m);
        Assert.assertFalse(game.isValidMove(m));
    }

    @Test
    public void isCompleteFail(){
        ChessModel game = new ChessModel();
        //Can't be in checkmate on first move
        Assert.assertFalse(game.isComplete());
    }

    @Test
    public void undoCastlingTest(){
        ChessModel game = new ChessModel();
        // move pieces in order for castling to be possible
        game.move(new Move(6,4,3,4));
        game.move(new Move(7,6,5,7));
        game.move(new Move(7,5,5,3));
        game.castleRight(Player.WHITE);
        game.undoMove();
        Assert.assertEquals("Rook", game.pieceAt(7, 7).type());
    }

    @Test
    public void testEnPassant() {
        ChessPanel game = new ChessPanel();

        game.twoPlayer.setSelected(true);

        // move white pawn out
        game.model.move(new Move(6,6,4,6));
        game.model.setNextPlayer();

        //move black piece
        game.model.move(new Move(1,0,2,0));
        game.model.setNextPlayer();

        game.model.move(new Move(4,6,3,6));
        game.model.setNextPlayer();

        //move black pawn to enable en passant
        game.model.move(new Move(1,5,3,5));
        game.model.setNextPlayer();

        game.model.move(new Move(3,6,2,5));
        Assert.assertEquals("Pawn",game.model.pieceAt(2,5).type());

    }
}
