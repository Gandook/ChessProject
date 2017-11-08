package TCGP;

public class King extends Piece
{
    public static boolean move (int cx, int cy, int dx, int dy)
    {
        if (cx == dx && cy == dy)
            return false;
        if (cx - dx < -1 || cx - dx > 1 || cy - dy < -1 || cy - dy > 1)
            return false;
        if (board[dx][dy] != 0 && board[dx][dy] % 2 == board[cx][cy] % 2)
            return false;
        MoveMessage (cx, cy, dx, dy);
        return true;
    }
}