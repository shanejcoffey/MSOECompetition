import java.io.*;
import java.util.*;

public class Q9FindingAntFood {
    public static void main(String[] args) {
        Scanner scan = null;
        File file = new File("9a.txt");
        try {
            scan = new Scanner(file);
        } catch(FileNotFoundException e) {
            System.out.println("file not found");
            return;
        }

        ArrayList<String> input = new ArrayList<>();
        while(scan.hasNextLine()) {
            input.add(scan.nextLine());
        }

        char[][] map = new char[input.size()][input.getFirst().length()];
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++) {
                map[i][j] = input.get(i).charAt(j);
            }
        }

        int[] start = new int[2];
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++) {
                if(map[i][j] == '>') {
                    start = new int[] {i, j};
                    break;
                }
            }
        }

        boolean[][] searched = new boolean[map.length][map[0].length];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int[][] dirs = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
        pq.add(new int[] {0, start[0], start[1]});
        while(!pq.isEmpty()) {
            int[] current = pq.poll();
            int r = current[1];
            int c = current[2];

            if(map[r][c] == 'f') {
                System.out.println(current[0]);
                return;
            }

            for(int[] dir : dirs) {
                if(r + dir[0] < 0 || r + dir[0] >= map.length || c + dir[1] < 0 || c + dir[1] >= map[0].length || searched[r + dir[0]][c + dir[1]]) {
                    continue;
                }
                searched[r + dir[0]][c + dir[1]] = true;
                if(map[r + dir[0]][c + dir[1]] == 's') {
                    pq.add(new int[] {current[0] + 1, r + dir[0], c + dir[1]});
                } else {
                    pq.add(new int[] {current[0], r + dir[0], c + dir[1]});
                }
            }

        }

        System.out.println("-1");
    }
}
