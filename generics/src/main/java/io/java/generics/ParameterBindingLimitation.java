package io.java.generics;

import java.util.List;

public class ParameterBindingLimitation {
    // <? super T> and <? extends T>, are parameter bounds.

    public static void main(String... args) {
        new ParameterBindingLimitation().parameterized_type_dont_have_hierarchy_relation();
        new ParameterBindingLimitation().parameterized_type_cannot_be_primitive_types();
    }


    void parameterized_type_dont_have_hierarchy_relation() {
        List<Number> numbers = List.of(1, 2);
        print(numbers);

        // Code below wont compile, even if Integer extends Number
        /**
         * List<Integer> numbers = List.of(1, 2);
         * print(numbers);
         */

        // Now it works using <T extends Number> bound
        List<Integer> integers = List.of(5, 6);
        generic_print(integers);

    }

    void print(List<Number> elements) {
        elements.stream().forEach(System.out::println);
    }

    <T extends Number> void generic_print(List<T> elements) {
        elements.stream().forEach(System.out::println);

        // cannot add elements. See PECS_GUIDE.java
        // elements.add(Integer.valueOf(10));
    }

    private void parameterized_type_cannot_be_primitive_types() {
        // Not allowed
        //List<int> integers = List.of(5, 6);
    }

}
