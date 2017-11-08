package TCGP;

public class Pawn extends Piece
{
    public static boolean move (int cx, int cy, int dx, int dy)
    {
        if (board[cx][cy] % 2 == 0)
        {
            if (dx <= cx || (cx == 1 && dx - cx > 2) || (cx > 1 && dx - cx > 1))
                return false;
            if (dx - cx == 2 && dy != cy)
                return false;
            if (dx - cx == 1 && (dy - cy < -1 || dy - cy > 1))
                return false;
            if (dx - cx == 2)
            {
                if (board[cx + 1][cy] != 0 || board[cx + 2][cy] != 0)
                    return false;
                else
                {
                    MoveMessage (cx, cy, dx, dy);
                    return true;
                }
            }
            else
            {
                if (dy == cy)
                {
                    if (board[cx + 1][cy] != 0)
                        return false;
                    else
                    {
                        MoveMessage (cx, cy, dx, dy);
                        return true;
                    }
                }
                else
                {
                    if (board[dx][dy] == 0 || board[dx][dy] % 2 == 0)
                        return false;
                    else
                    {
                        MoveMessage (cx, cy, dx, dy);
                        return true;
                    }
                }
            }
        }
        else
        {
            if (dx >= cx || (cx == 6 && dx - cx < -2) || (cx < 6 && dx - cx < -1))
                return false;
            if (dx - cx == -2 && dy != cy)
                return false;
            if (dx - cx == -1 && (dy - cy < -1 || dy - cy > 1))
                return false;
            if (dx - cx == -2)
            {
                if (board[cx - 1][cy] != 0 || board[cx - 2][cy] != 0)
                    return false;
                else
                {
                    MoveMessage (cx, cy, dx, dy);
                    return true;
                }
            }
            else
            {
                if (dy == cy)
                {
                    if (board[cx - 1][cy] != 0)
                        return false;
                    else
                    {
                        MoveMessage (cx, cy, dx, dy);
                        return true;
                    }
                }
                else
                {
                    if (board[dx][dy] == 0 || board[dx][dy] % 2 == 1)
                        return false;
                    else
                    {
                        MoveMessage (cx, cy, dx, dy);
                        return true;
                    }
                }
            }
        }
    }
}
