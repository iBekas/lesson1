import java.util.Random;
import java.util.Scanner;

public class lesson4 {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();

    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = 'O';
    private static final char DOT_VOID = '.';

    private static int WIDTH_X;
    private static int WIDTH_Y;
    private static char[][] FIELD_SIZE;

    private static int scoreHuman = 0;
    private static int scoreAI = 0;

    public static void main(String[] args) {
        game ();
    }

    private static void fieldSize (){
        System.out.println("Введите размер поля >>>");
        int inputSize = SCANNER.nextInt();
        WIDTH_Y = WIDTH_X = inputSize;
        FIELD_SIZE = new char[WIDTH_X][WIDTH_Y];
        for (int i = 0; i < WIDTH_X; i++) {
            for (int j = 0; j < WIDTH_Y; j++) {
                FIELD_SIZE[i][j] = DOT_VOID;
            }
        }
    }

    private static void fieldPaint (){
        System.out.print(" ");
        for (int i = 0; i < WIDTH_X * 2; i++) {
            System.out.print((i % 2 == 0) ? " " : i / 2 + 1);
        }
        System.out.println("");
        for (int i = 0; i < WIDTH_X; i++) {
            System.out.print(i + 1 + "|");
            for (int j = 0; j < WIDTH_Y; j++) {
                System.out.print(FIELD_SIZE[i][j] + "|");
            }
            System.out.println("");
        }
    }

    private static void humanChoice () {
        int x, y;
        do {
            System.out.print("Введите коррдинаты в формате x и(пробел) y >>>>");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!stupidHuman(x, y) && !voidPlaceField(x, y));
        FIELD_SIZE[x][y] = DOT_HUMAN;
    }

    private static void aiChoice () {
        int x, y;
        do {
            x = RANDOM.nextInt(WIDTH_X);
            y = RANDOM.nextInt(WIDTH_Y);
        } while (!voidPlaceField(x, y));
        FIELD_SIZE[x][y] = DOT_AI;
    }

    private static boolean stupidHuman (int x, int y) {
        if (x < 0 || x > WIDTH_X || y <0 || y > WIDTH_Y) return false; // если пишу сразу return(условие) - игра постоянно просит ввести координаты, не смог понять в чем косяк
        else return true;
    }

    private static boolean voidPlaceField (int x, int y) {
        if (FIELD_SIZE[x][y] == DOT_HUMAN || FIELD_SIZE[x][y] == DOT_AI) return false;
        else return true;
    }

    private static boolean whoWin (char dot) {
        boolean check = false;
        for (int i = 0; i < WIDTH_X; i++) {
            if (FIELD_SIZE[i][i] == dot) check = true;
            else{
                check=false;
                break;
            }
        }
        if (check) return true;

        for (int i = 0; i < WIDTH_X; i++) {
            if (FIELD_SIZE[i][FIELD_SIZE.length - 1 - i] == dot) check = true;
            else{
                check=false;
                break;
            }
        }
        if (check) return true;

        for (int i = 0; i < WIDTH_X; i++) {
            for (int j = 0; j < WIDTH_Y; j++) {
                if (FIELD_SIZE[i][j] == dot) check = true;
                else{
                    check=false;
                    break;
                }
            }
            if (check) return true;
        }

        for (int i = 0; i < WIDTH_Y; i++) {
            for (int j = 0; j < WIDTH_X; j++) {
                if (FIELD_SIZE[j][i] == dot) check = true;
                else{
                    check=false;
                    break;
                }
            }
            if (check) return true;
        }
        return false;
    }

    private static boolean draw () {
        for (int i = 0; i < WIDTH_X; i++) {
            for (int j = 0; j < WIDTH_Y; j++) {
                if (FIELD_SIZE[i][j] == DOT_VOID) return false;
            }
        }
        return  true;
    }

    private static boolean gameCheck (char dot) {
        if (whoWin(dot)) {
            System.out.println(dot == DOT_HUMAN ? "Человек умнее машины!" : "Человек глупее машины!");
            if (dot == DOT_HUMAN) scoreHuman++;
            else scoreAI++;
            return true;
        }
        if (draw()) {
            System.out.println("Ничья!");
            return true;
        }
        return false;
    }

    private static void game () {
        while (true) {
            fieldSize ();
            fieldPaint ();
            while (true){
                humanChoice();
                fieldPaint ();
                if (gameCheck (DOT_HUMAN)) break;

                aiChoice();
                fieldPaint ();
                if (gameCheck (DOT_AI)) break;
            }
            System.out.printf("    CЧЕТ\nЧеловек: %d\nМашина: %d\n",scoreHuman, scoreAI);
            System.out.println("Еще разок? 1- да, 0 - нет.");
            int userChoice = SCANNER.nextInt();
            if (userChoice != 1) break;
        }
    }
}




