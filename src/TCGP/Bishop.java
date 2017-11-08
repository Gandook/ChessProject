package TCGP;

public class Bishop extends Piece
{
    public static boolean move (int cx, int cy, int dx, int dy)
    {
        if (dx - cx != dy - cy && dx - cx != cy - dy)
            return false;
        if (cx < dx)
        {
            if (cy < dy)
            {
                for (int i = cx + 1, j = cy + 1; i < dx && j < dy; i++, j++)
                {
                    if (board[i][j] != 0)
                        return false;
                }
            }
            else
            {
                for (int i = cx + 1, j = cy - 1; i < dx && j > dy; i++, j--)
                {
                    if (board[i][j] != 0)
                        return false;
                }
            }
        }
        else
        {
            if (cy < dy)
            {
                for (int i = dx - 1, j = dy + 1; i > dx && j < dy; i--, j++)
                {
                    if (board[i][j] != 0)
                        return false;
                }
            }
            else
            {
                for (int i = dx - 1, j = dy - 1; i > dx && j > dy; i--, j--)
                {
                    if (board[i][j] != 0)
                        return false;
                }
            }
        }
        if (board[dx][dy] != 0 && board[dx][dy] % 2 == board[cx][cy] % 2)
            return false;
        MoveMessage (cx, cy, dx, dy);
        return true;
    }
}