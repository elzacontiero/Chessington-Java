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
        Coordinates to = from.plus(-1, 0);
        Move ft = new Move(from,to);
        result.add(ft);

        to = from.plus(1,0);
        Move ft2 = new Move(from,to);
        result.add(ft2);


        return result;
    }

}
