package DynamicProgramming;

import BinarySearchTree.BinarySearchTree;

public class OptimalBinarySearchTree {
    public static int[][][] optimalBinarySearchTree(int[][] information) {
        if (information.length == 0 || information[0].length != information[1].length) return new int[][][] {{{}}};
        int N = information[0].length + 1;
        /* Each i in dp will hold starting node + 1, while each j will hold end node inclusive */
        int[][] dp = new int[N][N];
        int[][] roots = new int[N][N];

        for (int i = 0; i < roots.length; i++) {
            for (int j = 0; j < roots.length; j++) {
                roots[i][j] = -1;
            }
        }

        /* Fill table with known values, dp[i][i] = 0 (done implicitly) and dp[i][i + 1] with node i + 1 */
        for (int i = 0; i < N - 1; i++) {
            dp[i][i + 1] = information[1][i];
            roots[i][i + 1] = i;
        }

        /* Store weight[i] + weight[0..i] to avoid recomputing each time */
        int[] weight = new int[N - 1];
        weight[0] = information[1][0];
        for (int i = 1; i < weight.length; i++)
            weight[i] = weight[i - 1] + information[1][i];

        /*
        depth:  how far from the smallest sub-problem (1 node) we are.
        begin:  node we begin at
        end:    node we are finding the optimal cost of

        In the code below, try different roots from root = begin to root = end - 1 while simultaneously calculating
            from previous subtrees the best subtree for any root. Choose the tree with the optimal cost and store it in
            min.
        */

        for (int depth = 1; depth < N; depth++) {
            for (int begin = 0; begin < N; begin++) {
                int end = depth + begin + 1;
                if (end >= N) break;
                int[] min = computeMin(begin, end, dp, information);
                dp[begin][end] = min[0] + (weight[end - 1] - (begin > 0 ? weight[begin - 1] : 0));
                roots[begin][end] = min[1];
            }
        }

        return new int[][][] {dp, roots};
    }

    public static int[] computeMin(int begin, int end, int[][] dp, int[][] information) {
        int min = Integer.MAX_VALUE;
        int optimal_root = -1;

        for (int root = begin; root < end; root++) {
            int cost = (root > begin ? dp[begin][root] : 0) + (root < end - 1 ? dp[root + 1][end] : 0);
            if (cost < min) {
                min = cost;
                optimal_root = root;
            }
        }

        return new int[] {min, optimal_root};
    }
    public static BinarySearchTree getTree(int[][] root_table, int[][] information) {
        BinarySearchTree tree = new BinarySearchTree();
        getTree(root_table, 0, root_table.length - 1, tree, information);
        return tree;
    }
    /* After adding the root, we know that the left subtree will contain nodes 0->root-1 and the right will
    contain root+1->last node, so we construct the tree recursively */
    private static void getTree(int[][] root_table, int begin, int end, BinarySearchTree tree, int[][] information) {
        if (begin == end) return;
        tree.add(information[1][root_table[begin][end]]);
        getTree(root_table, begin, root_table[begin][end], tree, information);
        getTree(root_table, root_table[begin][end] + 1, end, tree, information);
    }
    public static void main(String[] args) {
        int[][] a = new int[][] {
                {8, 10, 498, 3934, 299294},
                {84, 922, 94, 21, 4}
        };
        int[][][] x = optimalBinarySearchTree(a);
        System.out.println("The optimal cost for such a tree is " + x[0][0][x[0].length - 1]);
        BinarySearchTree tree = getTree(x[1], a);
        tree.printDecreasing();
    }
}
