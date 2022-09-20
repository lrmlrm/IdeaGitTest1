import java.util.Scanner;

public class drow {
    public static void main(String[] args) {
        String t1 = "RCRFCRFFCCRRC";
        String t2 = "FFFCCRRCCCRR";
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] chars = str.toCharArray();
        int down = 0,up = 0,index = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]=='R') {
                index++;
                up = index>up?index:up;
            }
            if (chars[i]=='F') {
                index--;
                down = index<down?index:down;
            }
        }
        int h = up-down+1;
        int w = chars.length;
        int iX = up;
        char[][] board = new char[h][w];
        for (int y = 0; y < w; y++) {
            if(chars[y]=='C') {
                board[iX][y] = '_';
            }
            if(chars[y]=='R') {
                board[iX][y] = '/';
                iX--;

            }
            if(chars[y]=='F') {
                iX++;
                board[iX][y] = '\\';

            }
        }

        for (int x = 0; x < h; x++) {
            for (int y = 0; y < w; y++) {
                if (!(board[x][y]=='\\'||board[x][y]=='/'||board[x][y]=='_')) System.out.print(" ");
                else System.out.print(board[x][y]);
            }
            System.out.println();
        }
    }
}
