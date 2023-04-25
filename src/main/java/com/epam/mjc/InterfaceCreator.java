package com.epam.mjc;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return s -> {
            for (String str : s) {
                if (str.matches("[-+]?\\d+")){
                    return false;
                }
                if (str.startsWith(str.substring(0,1).toUpperCase())){
                    return true;
                }
            }
            return false;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            List<Integer> array = new ArrayList<>();
            for (int i = 0; i<x.size(); i++){
                if (x.get(i) % 2 == 0){
                    array.add(x.get(i));
                }
            }
            x.addAll(array);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> array = new ArrayList<>();
            for (String value : values) {
                if (value.startsWith(value.substring(0, 1).toUpperCase())
                        && value.endsWith(".")
                        && Arrays.stream((value.split(" "))).count() > 3) {
                    array.add(value);
                }
            }
            return array;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return list -> {
            Map<String,Integer> result = new HashMap<>();
            for (String s : list){
                result.put(s,s.length());
            }
            return result;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (x, y) -> {
            List<Integer> list = new ArrayList<>(x);
            list.addAll(y);
            return list;
        };
    }
}
