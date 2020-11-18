package com.codegym.task.task37.task3701;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

/* 
Circular iterator

*/

public class Solution<T> extends ArrayList<T> {

    @Override
    public Iterator<T> iterator() {
        return new CircularIterator(this);
    }

    public static void main(String[] args) {
        Solution<Integer> list = new Solution<>();
        list.add(1);
        list.add(2);
        list.add(3);

        int count = 0;
        for (Integer i : list) {
            //1 2 3 1 2 3 1 2 3 1
            System.out.print(i + " ");
            count++;
            if (count == 10) {
                break;
            }
        }
    }

    public class CircularIterator implements Iterator<T> {

        private ArrayList<T> node;
        private Iterator<T> it;

        public CircularIterator(ArrayList<T> nd){
            node = nd;
            it = Solution.super.iterator();
        }

        @Override
        public boolean hasNext() {
            if(Solution.super.size()==0)
                return false;

            if(!it.hasNext())
                it = node.iterator();

            return true;
        }

        @Override
        public T next() {
            return it.next();
        }

        @Override
        public void remove() {
            it.remove();
        }

        @Override
        public void forEachRemaining(Consumer<? super T> action) {
            it.forEachRemaining(action);
        }
    }
}
