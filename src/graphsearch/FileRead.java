package graphsearch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FileRead {
    int num;
    int count = 0;
    public ArrayList<Integer[][]> capacity = new ArrayList<>();

    public FileRead(String s) {
        try {
            File file = new File(s);
            Scanner scanner = new Scanner(file);
            while(scanner.hasNext()) {
                num = scanner.nextInt();
                capacity.add(new Integer[num][num]);
                Integer[][] matrix = capacity.get(count);
                for (int i = 0; i < num; i++) {
                    for (int j = 0; j < num; j++) {
                        if(i==j)
                            matrix[i][j] = 0;
                        else
                            matrix[i][j] = Integer.MAX_VALUE;
                    }
                }
                for (int i = 0; i < num; i++) {
                    int step = scanner.nextInt();
                    try {
                        String line = scanner.nextLine().trim();
                        Scanner lineScanner = new Scanner(line);
                        while(lineScanner.hasNext()) {
                            int pivot = lineScanner.nextInt();
                            for (int j = 0; j < num; j++) {
                                if(j+1 == pivot) {
                                    if(s.equals("files/input1.txt"))
                                        matrix[i][j] = 1;
                                    else if(s.equals("files/input2.txt"))
                                        matrix[i][j] = lineScanner.nextInt();
                                }
                            }
                        }
                    } catch(NoSuchElementException e) {
                        break;
                    }
                }
                count++;
            }
        } catch(FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다.");
        }

        for (int i = 0; i < capacity.size(); i++) {
            Integer[][] m = capacity.get(i);
            for (int j = 0; j < m.length; j++) {
                for (int k = 0; k < m.length; k++) {
                    if(m[j][k] == Integer.MAX_VALUE)
                        System.out.print("INF ");
                    else
                        System.out.format("%3d ",m[j][k]);
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}

