package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends AbstractPiece {
    public Pawn(PlayerColour colour) {
        super(Piece.PieceType.PAWN, colour);
    }
    private List<Move> getAllowedMovesForBlack(Coordinates from, Board board) {

        List<Move> result = new ArrayList<>();
        // Black moves down +1
        Coordinates to = from.plus(1,0);
        if (to.getRow()>=0 && to.getRow()<=7) {
            Piece pieceInFront = board.get(to);  // get piece in to
            if (pieceInFront == null) { // there is no piece in front
                Move ft2 = new Move(from, to);
                result.add(ft2);
            }
        }
        //
        if(from.getRow()==1) {
            to = from.plus(2, 0);// first move of pawn can move 2 squares
            Move ft3 = new Move(from, to);
            result.add(ft3);
        }

        // blackPawnsCanCaptureDiagonally
        to = from.plus(1,1);
        if (to.getRow() <= 7 && to.getCol()<=7) {
            Piece enemy = board.get(to);
            if (enemy != null && enemy.getColour() == PlayerColour.WHITE) {
                Move move = new Move(from, to);
                result.add(move);
            }
        }

        to = from.plus(1, -1);
        //to.column is -1, which is not allowed. need to put a check before next line
        // We have attempted to add +1 row and -1 column. So, row could go over 7 and column less than 0. The check below ensures this doesn't happen.
        if (to.getRow()<=7 && to.getCol()>=0) {
            Piece enemy = board.get(to);
            if (enemy != null && enemy.getColour() == PlayerColour.WHITE) {
                Move move = new Move(from, to);
                result.add(move);
            }
        }
        return result;
    }

    private List<Move> getAllowedMovesForWhite(Coordinates from, Board board) {
        List<Move> result = new ArrayList<>();
        Coordinates to = from.plus(-1, 0);
        if (to.getRow()>=0 && to.getRow()<=7) {
            Piece pieceInFront = board.get(to);
            if (pieceInFront == null) {
                Move ft = new Move(from, to);
                result.add(ft);
            }
        }

        if(from.getRow()==6) {
            to = from.plus(-2, 0);
            Move ft4 = new Move(from, to);
            result.add(ft4);
        }

        to = from.plus(-1, 1);
        if(to.getRow()>=0 && to.getCol()<=7) {
            Piece enemy = board.get(to);
            if (enemy != null && enemy.getColour() == PlayerColour.BLACK) {
                Move move = new Move(from, to);
                result.add(move);
            }
        }
        to = from.plus(-1,-1);
        if(to.getRow()>=0 && to.getCol()>=0) {
            Piece enemy = board.get(to);
            if (enemy != null && enemy.getColour() == PlayerColour.BLACK) {
                Move move = new Move(from, to);
                result.add(move);
            }
        }
        return result;
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        List<Move> result = new ArrayList<>();
        Piece pieceInFront;


        if (colour==PlayerColour.BLACK) {
            List<Move> blackMovements = getAllowedMovesForBlack(from, board);
            result.addAll(blackMovements);
        }

        if(colour==PlayerColour.WHITE){
            List<Move> whiteMovements = getAllowedMovesForWhite(from, board);
            result.addAll(whiteMovements);
        }

        return result;
      }
}

