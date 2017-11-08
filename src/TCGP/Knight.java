package TCGP;

public class Knight extends Piece
{
    public static boolean move (int cx, int cy, int dx, int dy)
    {
        if (((dx - cx == -1 || dx - cx == 1) && (dy - cy == -2 || dy - cy == 2)) || ((dx - cx == -2 || dx - cx == 2) && (dy - cy == -1 || dy - cy == 1)))
        {
            if (board[dx][dy] == 0 || board[dx][dy] % 2 != board[cx][cy] % 2)
            {
                MoveMessage (cx, cy, dx, dy);
                return true;
            }
            else
                return false;
        }
        else
            return false;
    }
}