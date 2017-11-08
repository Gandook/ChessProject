package TCGP;

public class Chess
{
    static boolean turn = false;
    static int curx, cury, desx, desy;
    static int[][] board = new int[8][8];
    static String ccell, dcell;
    static String[] kind = new String[13];

    public static void init ()
    {
        kind[0] = "Empty cell";
        kind[1] = "pawn";
        kind[2] = "pawn";
        kind[3] = "rook";
        kind[4] = "rook";
        kind[5] = "knight";
        kind[6] = "knight";
        kind[7] = "bishop";
        kind[8] = "bishop";
        kind[9] = "king";
        kind[10] = "king";
        kind[11] = "queen";
        kind[12] = "queen";
        for (int i = 2; i < 6; i++)
        {
            for (int j = 0; j < 8; j++)
                board[i][j] = 0;
        }
        for (int i = 0; i < 8; i++)
        {
            board[6][i] = 1;
            board[1][i] = 2;
        }
        board[7][0] = 3;
        board[7][7] = 3;
        board[0][0] = 4;
        board[0][7] = 4;
        board[7][1] = 5;
        board[7][6] = 5;
        board[0][1] = 6;
        board[0][6] = 6;
        board[7][2] = 7;
        board[7][5] = 7;
        board[0][2] = 8;
        board[0][5] = 8;
        board[7][3] = 11;
        board[0][3] = 12;
        board[7][4] = 9;
        board[0][4] = 10;
    }

    public static int charToInt (char c)
    {
        if ('a' <= c && c <= 'h')
            return c - 'a';
        else
            return 8 - c + '0';
    }

    public static boolean movePiece (int cx, int cy, int dx, int dy)
    {
        if (cx < 0 || cx > 7 || dx < 0 || dx > 7 || cy < 0 || cy > 7 || dy < 0 || dy > 7)
            return false;
        if (board[cx][cy] == 0)
            return false;
        if ((!turn && board[cx][cy] % 2 == 0) || (turn && board[cx][cy] % 2 == 1))
            return false;
        if (board[cx][cy] == 1 || board[cx][cy] == 2)
            return Pawn.move (cx, cy, dx, dy);
        else if (board[cx][cy] == 3 || board[cx][cy] == 4)
            return Rook.move (cx, cy, dx, dy);
        else if (board[cx][cy] == 5 || board[cx][cy] == 6)
            return Knight.move (cx, cy, dx, dy);
        else if (board[cx][cy] == 7 || board[cx][cy] == 8)
            return Bishop.move (cx, cy, dx, dy);
        else if (board[cx][cy] == 11 || board[cx][cy] == 12)
            return Queen.move (cx, cy, dx, dy);
        else
            return King.move (cx, cy, dx, dy);
    }

    public static void main (String[] args)
    {
        init ();
        System.out.println ("Hi! For performing a move, please write the coordinates of a desired piece of your pieces and then the coordinates of destination cell.");
        java.util.Scanner s = new java.util.Scanner (System.in);
        while (true)
        {
            if (turn)
                System.out.print ("Black move: ");
            else
                System.out.print ("White move: ");
            ccell = s.next();
            curx = charToInt (ccell.charAt(1));
            cury = charToInt (ccell.charAt(0));
            dcell = s.next();
            desx = charToInt (dcell.charAt(1));
            desy = charToInt (dcell.charAt(0));
            System.out.println ();
            if (!movePiece (curx, cury, desx, desy))
                System.out.println ("Invalid move!");
            else
            {
                board[desx][desy] = board[curx][cury];
                board[curx][cury] = 0;
                turn = !turn;
            }
        }
    }
}