package io.java.generics;

import java.util.ArrayList;
import java.util.List;

public class ArrayLimitation {

    public static void main(String... args) {
        new ArrayLimitation().array_of_generic_type_is_not_allowed();
        new ArrayLimitation().compiles_but_fails_in_runtime();
    }

    void compiles_but_fails_in_runtime() {
        unsafe_fill(new String[10], 3);
        // Compiler looks for the most specific type shared by "new String[10]" and 3 is Object
    }

    void safe_version_of_fill() {
        // Issue detected on compile time
        /**
         * new SafeFill<>(new String[10]).do_fill(3);
         */
    }

    <T> void unsafe_fill(T[] arr, T value) {
        for (int i = 0; i < arr.length; i++)
            arr[i] = value;
    }

    void array_of_generic_type_is_not_allowed() {
        List<Integer>[] arrOfIntLists = null;

        // Illegal:
        /**
         * arrOfIntLists = new ArrayList<Integer>[10];
         */

        // if it was legal, it leads to unsafe code, see below:
        Object[] arrOfObj = arrOfIntLists;

        List<String> listOfStrings = new ArrayList<>();
        listOfStrings.add("hello");
        arrOfObj[0] = listOfStrings;

        List<Integer> list = arrOfIntLists[0];
        Integer num = list.get(0); // cast exception in runtime
    }

    class SafeFill<T> {
        T[] arr;

        SafeFill(T[] arr) {
            this.arr = arr;
        }

        void do_fill(T value) {
            for (int i = 0; i < arr.length; i++)
                arr[i] = value;
        }
    }
}