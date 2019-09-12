package io.java.generics;

import java.util.List;

public class TypeErasure {

    // Generic parameters are completely removed on runtime.
    // Formal type parameters are replaced by their bound, if any, (or Object).
    // e.g. no difference in the byte code between List<Integer>, List<String> ...


    public static void main(String... args) {
        new TypeErasure().cannot_instantiate_formal_type();
        new TypeErasure().cannot_check_runtime_information();
        new TypeErasure().generic_type_cannot_extend_throwables();
    }

    void cannot_instantiate_formal_type() {
        class MyLocalClass<T> {
            //Illegal
            /**
             * T obj = new T();
             */
        }
    }

    void cannot_check_runtime_information() {
        List<Integer> integers = List.of(5, 6);
        //Illegal
        /**
         * if (integers instanceof List<Integer>){ ....}
         */
    }

    private void generic_type_cannot_extend_throwables() {
        // Doesn't compile ... because throw/catch exception is a runtime activity
        /**
         * class GenericException<T> extends RuntimeException {
         * public GenericException(T message) {
         * //
         * }
         }*/

        // This problematic, because in runtime the type is removed, so
        // no way to distinguish / catch GenericException<String>, GenericException<Byte> ...

    }


}
