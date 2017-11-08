package TCGP;

public class Queen extends Piece
{
    public static boolean move (int cx, int cy, int dx, int dy)
    {
        if (cx == dx || cy == dy)
        {
            if (cx < dx)
            {
                for (int i = cx + 1; i < dx; i++)
                {
                    if (board[i][cy] != 0)
                        return false;
                }
            }
            else if (cx > dx)
            {
                for (int i = cx - 1; i > dx; i--)
                {
                    if (board[i][cy] != 0)
                        return false;
                }
            }
            else if (cy < dy)
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
            if (board[dx][dy] != 0 && board[cx][cy] % 2 == board[dx][dy] % 2)
                return false;
            else
            {
                MoveMessage (cx, cy, dx, dy);
                return true;
            }
        }
        else if (dx - cx == dy - cy || dx - cx == cy - dy)
        {
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
                    for (int i = cx - 1, j = cy + 1; i > dx && j < dy; i--, j++)
                    {
                        if (board[i][j] != 0)
                            return false;
                    }
                }
                else
                {
                    for (int i = cx - 1, j = cy - 1; i > dx && j > dy; i--, j--)
                    {
                        if (board[i][j] != 0)
                            return false;
                    }
                }
            }
            if (board[dx][dy] != 0 && board[dx][dy] % 2 == board[cx][cy] % 2)
                return false;
            else
            {
                MoveMessage (cx, cy, dx, dy);
                return true;
            }
        }
        else
            return false;
    }
}