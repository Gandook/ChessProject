package TCGP;

public class Rook extends Piece
{
    public static boolean move (int cx, int cy, int dx, int dy)
    {
        if (cx == dx)
        {
            if (cy == dy)
                return false;
            else
            {
                if (cy < dy)
                {
                    for (int i = cy + 1; i < dy; i++)
                    {
                        if (board[cx][i] != 0)
                            return false;
                    }
                }
                else
                {
                    for (int i = cy - 1; i > dy; i--)
                    {
                        if (board[cx][i] != 0)
                            return false;
                    }
                }
            }
        }
        else
        {
            if (cy == dy)
            {
                if (cx < dx)
                {
                    for (int i = cx + 1; i < dx; i++)
                    {
                        if (board[i][cy] != 0)
                            return false;
                    }
                }
                else
                {
                    for (int i = cx - 1; i > dx; i--)
                    {
                        if (board[i][cy] != 0)
                            return false;
                    }
                }
            }
            else
                return false;
        }
        if (board[dx][dy] == 0)
        {
            MoveMessage(cx, cy, dx, dy);
            return true;
        }
        else
        {
            if (board[dx][dy] % 2 == board[cx][cy] % 2)
                return false;
            else
            {
                MoveMessage(cx, cy, dx, dy);
                return true;
            }
        }
    }
}