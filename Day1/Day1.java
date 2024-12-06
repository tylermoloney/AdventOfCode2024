import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Day1 {

    public int run() {

        Scanner scanner;
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        try {
            scanner = new Scanner(new File("Day1/input.txt"));
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split("   ");
                Integer leftValue = Integer.parseInt(line[0]);
                Integer rightValue = Integer.parseInt(line[1]);
                leftList.add(leftValue);
                rightList.add(rightValue);
                if(!map.containsKey(rightValue)){
                    map.put(rightValue, 1);
                    System.out.println("added: " + rightValue);
                } else {
                    map.put(rightValue, map.get(rightValue) + 1);
                    System.out.println("incremented: " + rightValue);
                }
                
            }
            scanner.close();

            // Difference Section:

            // Collections.sort(leftList);
            // Collections.sort(rightList);
            // int difference = 0;

            // for (int i = 0; i < leftList.size(); i++) {
            //     difference += Math.abs(leftList.get(i) - rightList.get(i));
            // }
            // return difference;

            // Similiarity Score Section:
            int similarity = 0;

            for (Integer i = 0; i < leftList.size(); i++) {
                // System.out.println("current list entry: " + leftList.get(i));
                boolean contains = map.containsKey(leftList.get(i));
                // System.out.println("contains: " + contains);
                if(contains){
                    System.out.println("similarity: " + leftList.get(i) + " * " + map.get(leftList.get(i)));
                    similarity += leftList.get(i) * map.get(leftList.get(i));
                }
            }
            return similarity;


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
