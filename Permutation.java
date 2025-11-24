/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;

public class Permutation {
    public static void main(String[] args) {

        RandomizedQueue<String> m = new RandomizedQueue<String>();
        if (args.length != 1)
            throw new IllegalArgumentException("the argument must be 1");
        int n = Integer.parseInt(args[0]);
        // int t = Integer.parseInt(args[1]);

        int count = 0;
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            // System.out.println("s: " + s);
            count++;
            m.enqueue(s);
            // System.out.println("array: " + Arrays.toString(m.array));
        }

        if (n > count)
            throw new IllegalArgumentException("the number must be smaller than n");

        for (int i = 0; i < n; i++) {
            System.out.println(m.dequeue());

        }

    }
}
