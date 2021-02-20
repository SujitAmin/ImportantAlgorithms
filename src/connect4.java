import java.io.*;
import java.util.StringTokenizer;

public class connect4 {
    static class SystemOut {
        static BufferedWriter bufferedWriter;
        SystemOut() {
            bufferedWriter =new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public static void print(String a) throws IOException {
            bufferedWriter.write(a);
        }
        public static void printSp(String a) throws IOException {
            bufferedWriter.write(a+" ");
        }
        public static void println(String a) throws IOException {
            bufferedWriter.write(a+"\n");
        }
        public static void close() throws IOException {
            bufferedWriter.flush();
            bufferedWriter.close();
        }
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) throws IOException {
        FastReader fastReader = new FastReader();
        SystemOut systemOut = new SystemOut();
        char[][] board = new char[6][7];
        for (int row = 0; row < board.length; row++){
            for (int col = 0; col < board[0].length; col++){
                board[row][col] = ' ';
            }
        }

        int turn = 0;
        char player = 'R';
        boolean isWinner = false;

        while (!isWinner && turn <= 42){
            boolean validPlay;
            int play;
            do {
                play = fastReader.nextInt();
                validPlay = check(play, board);
            }while (!validPlay);

            for (int row = board.length-1; row >= 0; row--){
                if(board[row][play] == ' '){
                    board[row][play] = player;
                    break;
                }
            }
            isWinner = isWinner(player, board);

            if (player == 'R'){
                player = 'B';
            }else{
                player = 'R';
            }
            turn++;
        }

        if (isWinner){
            if (player=='R'){
                systemOut.println("YELLOW "+ turn);
            }else{
                systemOut.println("RED " + turn);
            }
        }else{
            systemOut.println("DRAW");
        }
        systemOut.close();
    }


    public static boolean check(int column, char[][] grid){
        if (column < 0 || column > grid[0].length){
            return false;
        }
        if (grid[0][column] != ' '){
            return false;
        }
        return true;
    }

    public static boolean isWinner(char currentPlayer, char[][] board){
        for(int currentRow = 0; currentRow < board.length; currentRow++){
            for (int currentCol = 0; currentCol < board[0].length - 3; currentCol++){
                if (board[currentRow][currentCol] == currentPlayer &&
                        board[currentRow][currentCol +1] == currentPlayer &&
                        board[currentRow][currentCol +2] == currentPlayer &&
                        board[currentRow][currentCol +3] == currentPlayer){
                    return true;
                }
            }
        }
        for(int currentRow = 0; currentRow < board.length - 3; currentRow++){
            for(int currentCol = 0; currentCol < board[0].length; currentCol++){
                if (board[currentRow][currentCol] == currentPlayer &&
                        board[currentRow +1][currentCol] == currentPlayer &&
                        board[currentRow +2][currentCol] == currentPlayer &&
                        board[currentRow +3][currentCol] == currentPlayer){
                    return true;
                }
            }
        }
        for(int currentRow = 3; currentRow < board.length; currentRow++){
            for(int currentCol = 0; currentCol < board[0].length - 3; currentCol++){
                if (board[currentRow][currentCol] == currentPlayer &&
                        board[currentRow -1][currentCol +1] == currentPlayer &&
                        board[currentRow -2][currentCol +2] == currentPlayer &&
                        board[currentRow -3][currentCol +3] == currentPlayer){
                    return true;
                }
            }
        }
        for(int currentRow = 0; currentRow < board.length - 3; currentRow++){
            for(int currentCol = 0; currentCol < board[0].length - 3; currentCol++){
                if (board[currentRow][currentCol] == currentPlayer &&
                        board[currentRow +1][currentCol +1] == currentPlayer &&
                        board[currentRow +2][currentCol +2] == currentPlayer &&
                        board[currentRow +3][currentCol +3] == currentPlayer){
                    return true;
                }
            }
        }
        return false;
    }
}
