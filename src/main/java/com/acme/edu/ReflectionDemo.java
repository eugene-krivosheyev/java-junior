package com.acme.edu;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collector;

public class ReflectionDemo {
    public static void main(String[] args) {
        //region sort
        List<String> list = new LinkedList<>();
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });
        //endregion

        /*
        Properties map = System.getProperties();
        for(String key : map.stringPropertyNames()) {
            System.out.println(
                    key + ": " + map.getProperty(key)
            );
        }

        Set<DTO> set = new HashSet<>();
        DTO obj = new DTO("A");
        set.add(obj);
        set.add(new DTO("B"));
        System.out.println(set.size());

        obj.setS("C");
        set.add(new DTO("C"));


        System.out.println("============");
        for (DTO element : set) {
            System.out.println(element);
        }

        for (Iterator<DTO> i = set.iterator(); i.hasNext();) {
            System.out.println(i.next().getS());
        }

        List<DTO> dtoList = new ArrayList<>();
        */


        Set<DTO> dtoSet = new TreeSet<>((o1, o2) -> {
            return o1.getS().compareTo(o2.getS());
        });

//        Collections.unmodifiableSet(dtoSet).add(null);
//        Collections.synchronizedCollection(null);
//        Collections.emptyList().add(null);


        Arrays.asList(10,20,3).parallelStream()
            .map(Object::toString)
            .sorted((x, y) -> x.compareTo(y))
            .filter((x) -> x.length() > 1)
            .forEach(System.out::println);
//            .reduce();
    }
}

class DTO  {
    private String s;
    private int exceptionsCount;
    private Collection exceptions;


    public void addException(){

    }

    public DTO(String s) {
        this.s = s;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DTO)) return false;

        DTO dto = (DTO) o;

        return !(s != null ? !s.equals(dto.s) : dto.s != null);

    }

    @Override
    public int hashCode() {
        return s != null ? s.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "DTO{" +
                "s='" + s + '\'' +
                '}';
    }

    public Collection getExceptions() {
        return exceptions;
    }
}

