package TCGP;

public class Piece extends Chess
{
    public static String WhichColorCapital (int x)
    {
        if (x % 2 == 0)
            return "Black";
        else
            return "White";
    }

    public static String WhichColorNonCapital (int x)
    {
        if (x % 2 == 0)
            return "black";
        else
            return "white";
    }

    public static void MoveMessage (int cx, int cy, int dx, int dy)
    {
        System.out.print (WhichColorCapital (board[cx][cy]) + " " + kind[board[cx][cy]] + " moved from cell " + ccell + " to cell " + dcell);
        if (board[dx][dy] == 0)
            System.out.println (".");
        else
            System.out.println (" and " + WhichColorNonCapital (board[dx][dy]) + " " + kind[board[dx][dy]] + " was captured.");
    }
}