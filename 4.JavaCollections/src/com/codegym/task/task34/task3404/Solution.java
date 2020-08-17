package com.codegym.task.task34.task3404;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.List;

/*
Recursion for mathematical expressions

*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.recurse("tan(2025 ^ 0.5)", 0); // Expected output:
    }

    public void recurse(final String expression, int countOperation) {
        //https://stackoverflow.com/questions/3422673/how-to-evaluate-a-math-expression-given-in-string-form

        int count=countOperation;

        if(count==0)
        for(char a : expression.toCharArray()) {
           // System.out.println(a);
            if (a == '+' || a == '-' || a == '/' || a == '*' || a == '^')
                count++;


        }

        ScriptEngineManager sem = new ScriptEngineManager();
        ScriptEngine se = sem.getEngineByName("Nashorn");
        // Implement
        //System.out.println("Expression: "+expression);
        String first=expression;
        try {
            first = expression.substring(expression.lastIndexOf("(") + 1, expression.indexOf(")",
                    expression.lastIndexOf("(")));
        } catch (StringIndexOutOfBoundsException e){
            first=expression;
        }

        if(first.contains("^")){
            String exp = first.substring(first.indexOf("^")+1);
            List<Character> d = new ArrayList<>();

            for(char c : exp.toCharArray()) {
                if (Character.isDigit(c) || c=='.') {
                    d.add(c);
                } else
                    break;
            }

            if (!d.isEmpty()) {
                String ab = new String();

                for (Character e : d) {
                    ab += e;
                }
                exp = first.substring(first.indexOf("^") - 5, first.indexOf("^"));
                char[] abc = exp.toCharArray();
                List<Character> de = new ArrayList<>();
                for (int f = abc.length - 1; f >= 0; f--) {
                    if (Character.isDigit(abc[f]) || abc[f]=='.')
                        de.add(abc[f]);
                    else
                        break;
                }
                /*System.out.print("expo: ");
                for(int f = de.size()-1; f>=0;f--)
                    System.out.print(de.get(f));

                System.out.println();*/
                StringBuilder sb = new StringBuilder();
                //sb.append("^");
                for(Character ec : d)
                    sb.append(ec);

                StringBuilder sb2 = new StringBuilder();
                for(int f = de.size()-1; f>=0;f--)
                    sb2.append(de.get(f));

                /*int u = Integer.parseInt(sb.toString());
                StringBuilder sb3 = new StringBuilder();
                for(int t = 1; t<u;t++)
                    sb3.append("*").append(sb2.toString());*/

                double bc = Math.pow(Double.parseDouble(sb2.toString()), Double.parseDouble(sb.toString()));

                //exp = first.replace("^"+sb.toString(), sb3.toString());
               // System.out.println("expo: "+exp);
               // first=exp;
                recurse(expression.replace(sb2.toString()+"^"+sb.toString(), String.valueOf(bc)),count);
                return;
            }


        }

       // System.out.println("First: "+first);
        Object resultSE=null;
        try {

            resultSE=se.eval(first);

           // System.out.println("ScriptEngine: " + resultSE.toString());
        } catch (ScriptException e) {
            //e.printStackTrace();
            if(first.contains("sin")){
                resultSE = getSinConTan(first, "sin");
                count++;
            } else if(first.contains("tan")){
                resultSE = getSinConTan(first, "tan");
                count++;
            } else if(first.contains("cos")) {
                resultSE = getSinConTan(first, "cos");
                count++;
            }
        }

        if(resultSE!=null) {
            String vysledok = resultSE.toString();



            if(first.equals(expression)) {
                double m = Math.round(Double.parseDouble(vysledok)*100)/100.0;

                System.out.print(String.valueOf(m).replace(".0", "") +" "+count);
                return;
            }

            if(first.equals(vysledok))
                recurse(expression.replace("(" + first + ")", vysledok), count);
            else
                recurse(expression.replace("(" + first + ")", "("+vysledok+")"), count);
        }
    }

    private Object getSinConTan(String first, String sin) {
        Object resultSE;
        String sinus = first.substring(first.indexOf(sin)+3);

        int dlzka=0;
        for(char c : sinus.toCharArray()){
            if(Character.isDigit(c) || c == '.'){
                dlzka++;
            } else
                break;
        }
        sinus = sinus.substring(0, dlzka);

        String sina = sin+sinus;

        double a=0;

        if(sin.equals("sin")) // sin
         a = Math.sin(Math.toRadians(Double.parseDouble(sinus)));

        if(sin.equals("tan"))//tan
         a = Math.tan(Math.toRadians(Double.parseDouble(sinus)));

        if(sin.equals("cos"))//cos
         a = Math.cos(Math.toRadians(Double.parseDouble(sinus)));

        resultSE = first.replace(sina, String.valueOf(a));
      //  System.out.println("resultSE: "+resultSE);
        return resultSE;
    }

    public Solution() {
        // Don't delete
    }
}