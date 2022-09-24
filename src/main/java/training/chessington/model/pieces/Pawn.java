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

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        List<Move> result = new ArrayList<>();
        Piece pieceInFront;
        // White moves up
        Coordinates to = from.plus(-1, 0);
        if (to.getRow()>=0 && to.getRow()<=7) {
            pieceInFront = board.get(to);
            if (colour == PlayerColour.WHITE && pieceInFront == null) {
                Move ft = new Move(from, to);
                result.add(ft);
            }
        }

        // Black moves down +1
        to = from.plus(1,0);
        if (to.getRow()>=0 && to.getRow()<=7) {
            pieceInFront = board.get(to);
            if (colour == PlayerColour.BLACK && pieceInFront == null) {
                Move ft2 = new Move(from, to);
                result.add(ft2);
            }
        }


        if(colour == PlayerColour.BLACK && from.getRow()==1) {
            to = from.plus(2, 0);
            Move ft3 = new Move(from, to);
            result.add(ft3);
        }

        if(colour==PlayerColour.WHITE && from.getRow()==6) {
            to = from.plus(-2, 0);
            Move ft4 = new Move(from, to);
            result.add(ft4);
        }

        return result;
    }
}
