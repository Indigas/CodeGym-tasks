package com.codegym.task.task21.task2105;

import java.util.HashSet;
import java.util.Set;

/* 
Fix the bug. Comparing objects

*/

public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Solution)) return false;

        Solution solution = (Solution) o;

        if (first != null ? !first.equals(solution.first) : solution.first != null) return false;
        if (last != null ? !last.equals(solution.last) : solution.last != null) return false;

        return true;
    }


    @Override
    public int hashCode() {
        return (first+last).hashCode();
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }
}
