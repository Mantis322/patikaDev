import java.util.Scanner;

public class MineSweeper {
    String[][] minedMap;
    String[][] game;
    int rowNumber;
    int colNumber;
    int mineNumber;


    MineSweeper(int rowNumber, int colNumber) {
        this.rowNumber = rowNumber;
        this.colNumber = colNumber;
        this.minedMap = new String[rowNumber][colNumber];
        this.game = new String[rowNumber][colNumber];
        this.mineNumber = (rowNumber * colNumber) / 4;

    }

    void showingMap() {
        for (int i = 0; i < rowNumber; i++) {
            for (int j = 0; j < colNumber; j++) {
                System.out.print(this.game[i][j] + " ");
            }
            System.out.println();
        }
    }

    void gameMap() {
        for (int i = 0; i < rowNumber; i++) {
            for (int j = 0; j < colNumber; j++) {
                this.game[i][j] = "-";

            }

        }
    }

    void minedMap() {

        for (int i = 0; i < mineNumber; i++) {
            int tempRow = (int) (Math.random() * rowNumber);
            int tempCol = (int) (Math.random() * colNumber);
            if (this.minedMap[tempRow][tempCol] != "*") {
                this.minedMap[tempRow][tempCol] = "*";
            } else {
                i--;
            }
        }
        for (int i = 0; i < rowNumber; i++) {
            for (int j = 0; j < colNumber; j++) {
                if (this.minedMap[i][j] != "*") {
                    this.minedMap[i][j] = "-";
                }
                System.out.print(this.minedMap[i][j] + " ");
            }
            System.out.println();

        }


    }

    void showingMinedMap() {
        for (int i = 0; i < rowNumber; i++) {
            for (int j = 0; j < colNumber; j++) {
                System.out.print(this.minedMap[i][j] + " ");
            }
            System.out.println();

        }

    }

    void run() {
        int totalMove = (colNumber * rowNumber) - mineNumber;
        Scanner inp = new Scanner(System.in);



        System.out.println("May�n Tarlas� Oyununa Ho�geldiniz...");

        gameMap();
        minedMap();

        while (totalMove > 0) {
            int mineVision = 0;

            System.out.println("===============================");
            showingMap();
            System.out.print("L�tfen bir sat�r numaras� giriniz:");
            int rowInput = inp.nextInt();

            System.out.print("L�tfen bir s�tun numaras� giriniz:");
            int colInput = inp.nextInt();
            if ((rowInput < 0 || rowInput >= rowNumber) || (colInput < 0 || colInput >= colNumber)) {
                System.out.println("Hatal� giri� yapt�n�z. L�tfen S�n�rlar i�inde se�im yap�n�z.");
                continue;
            } else {
                if (this.minedMap[rowInput][colInput] == "*") {
                    System.out.println("May�na Bast�n�z.");
                    showingMinedMap();
                    break;
                } else {
                    int minusRow = (rowInput-1), sumRow= (rowInput+1);
                    int minusCol = (colInput-1), sumCol = (colInput+1);
                    if ((minusRow < 0) || (minusCol < 0)) {
                        minusRow = 0;
                        minusCol = 0;
                    }
                    if ((sumRow >= colNumber) || (sumCol >= colNumber)) {
                        sumRow = rowInput;
                        sumCol = colInput;
                    }
                    for (int i = minusRow; i <= sumRow; i++) {
                        for (int j = minusCol; j <= sumCol; j++) {
                            if (this.minedMap[i][j] == "*") {
                                mineVision++;
                            }
                        }
                    }
                    String convertMineVision = String.valueOf(mineVision);
                    this.game[rowInput][colInput] = convertMineVision;
                    totalMove--;

                }
            }

        }
        if (totalMove == 0) {
            System.out.println("Tebrikler kazand�n�z.");
        }

    }
}
