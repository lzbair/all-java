package io.java10;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;


/**
 * ref: https://openjdk.org/projects/amber/guides/lvti-style-guide
 */
public class LocalVariableTypeInference {


    /**
     * The intention of var is to reduce verbosity in Java code and to be familiar to programmers
     * coming to Java from other languages.
     * It does not introduce dynamic typing, and all Java variables continue to have static types
     * at all times—you just don’t need to write them down explicitly in all cases.
     * <p>
     * Type inference in Java is local, and in the case of var, the algorithm examines only
     * the declaration of the local variable. This means it cannot be used for fields, method
     * arguments, or return types. The compiler applies a form of constraint solving to
     * determine whether any type exists that could satisfy all the requirements of the code as written
     */
    void varType() {

        var names = new ArrayList<String>();
        List<String> values = new ArrayList<>();

        print(names);
        print(values);
    }

    void choose_variable_names_that_provide_useful_information() {

        // ORIGINAL
        List<Item> result = executeQuery();

        // Alternative
        var items = executeQuery();
    }

    void minimize_the_scope_of_local_variables() {
        var items = loadItems();
        items.add(new Item("last")); // (Constraint) must be process last

        // many lines of code, big local scope ...

        for (var item : new HashSet<Item>(items)) { // another developer wraps in hashset to remove duplicates
            process(item); // (Constraint) is violated as hashset doesn't preserve order
        }
    }


    void consider_var_when_the_initializer_provides_sufficient_information() throws IOException {
        // ORIGINAL
        BufferedReader reader1 = Files.newBufferedReader(Paths.get(""));

        // Alternative
        var reader2 = Files.newBufferedReader(Paths.get(""));
    }


    void make_sure_right_type_is_inferred_correctly() {

        // NOT OK: infers as PriorityQueue<Object>
        var itemQueue = new PriorityQueue<>();


        // OK
        var queue = new PriorityQueue<Item>();
    }

    void take_care_when_using_var_with_literals() {

        /**
         * ORIGINAL
         *         boolean ready = true;
         *         char ch = '\ufffd';
         *         long sum = 0L;
         *         String label = "wombat";
         */
        // Alternative
        var ready = true;
        var ch = '\ufffd';
        var sum = 0L;
        var label = "wombat";


        /**
         *  // ORIGINAL
         *         byte flags = 0;
         *         short mask = 0x7fff;
         *         long base = 17;
         */
        // DANGEROUS: all infer as int
        var flags = 0;
        var mask = 0x7fff;
        var base = 17;
    }

    void extra_usage() {
        // You can do a sort of "duck typing". It is not allowed without var
        var o = new Object() {
            void quack() {
                System.out.println("Quack!");
            }

            void swim() {
                System.out.println("Swimming!");
            }
        };

        o.quack();
        o.swim();
    }


    private List<Item> loadItems() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("first"));
        items.add(new Item("second"));
        return items;
    }

    private void process(Item item) {
        System.out.println(item.label + ": processed.");
    }

    private List<Item> executeQuery() {
        return List.of(new Item("saved"));
    }

    private void print(List<String> values) {
        values.forEach(System.out::println);
    }

}