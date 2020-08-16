package com.codegym.task.task34.task3404;

/* 
Recursion for mathematical expressions

*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.recurse("sin(2*(-5+1.5*4)+28)", 0); // Expected output:
    }

    public void recurse(final String expression, int countOperation) {
        //https://stackoverflow.com/questions/3422673/how-to-evaluate-a-math-expression-given-in-string-form

        // Implement
        String first = expression.substring(expression.lastIndexOf("(")+1, expression.indexOf(")",
                expression.lastIndexOf("(")));

        System.out.println(first);

        String vysledok = "5";

        recurse(expression.replace("("+first+")", vysledok),0);
    }

    public Solution() {
        // Don't delete
    }
}