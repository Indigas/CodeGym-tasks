package com.codegym.task.task23.task2305;

/* 
Inner

*/

public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution[] solutions = new Solution[]{new Solution(), new Solution()};
        for(Solution sol : solutions) {
            sol.innerClasses[0] = sol.new InnerClass();
            sol.innerClasses[1] = sol.new InnerClass();
        }

        return solutions;
    }

    public static void main(String[] args) {

    }
}
