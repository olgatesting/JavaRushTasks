package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Set;

/* 
Equals and HashCode
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Solution)) return false;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Solution solution = (Solution) o;

        if (first != null ? !first.equals(solution.first) : solution.first != null) return false;
        return last != null ? last.equals(solution.last) : solution.last == null;
    }

    @Override
    public int hashCode() {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (last != null ? last.hashCode() : 0);
        return result;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        Solution sol = new Solution("Donald", "Duck");
        Solution sol2 = new Solution("erffrei", "Duck");

        System.out.println(sol.hashCode());
        System.out.println(sol2.hashCode());

        System.out.println(sol.equals(sol));
        System.out.println(sol2.equals(sol));

        s.add(sol);
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}
