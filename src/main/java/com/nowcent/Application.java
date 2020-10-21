package com.nowcent;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author orangeboy
 * @version 1.0
 * @date 2020/10/21 13:27
 */
public class Application {
    public static void main(String[] args) {
        T20_16("I have have a a a I.");
        T20_17();
        T20_18(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'));
        T20_20("azbdabeiasie");
    }

    public static void T20_16(String sentence){
        System.out.println("\n[20.16]");
        Map<String, Integer> map = new HashMap<>();
        String[] s1 = sentence.replaceAll("\\.", "").replaceAll(",", "").split(" ");
        Arrays.stream(s1).forEach(s -> map.put(s, map.get(s) == null ? 1 : map.get(s) + 1));
        long count = map.entrySet().stream().filter(c -> c.getValue() >= 2).count();
        System.out.println(count);
    }

    public static void T20_17(){
        System.out.println("\n[20.17]");
        List<Integer> list = new ArrayList<>(25);
        for (int i = 0; i < 25; i++) {
            list.add(new Random(System.currentTimeMillis()).nextInt(100));
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("整理前 => " + list);

        List<Integer> collect = list.stream().sorted().collect(Collectors.toList());
        System.out.println("整理后=>" + collect);

        IntSummaryStatistics intSummaryStatistics = collect.parallelStream().mapToInt(Integer::intValue).summaryStatistics();

        System.out.println("和：" + intSummaryStatistics.getSum());
        System.out.println("平均值：" + intSummaryStatistics.getAverage());
    }

    public static void T20_18(List<Character> chars){
        System.out.println("\n[20.18]");
        System.out.println("整理前 => " + chars);
        Collections.reverse(chars);
        System.out.println("整理后 => " + chars);
    }

    public static void T20_20(String str){
        System.out.println("\n[20.20]");
        System.out.println("整理前 => " + str);

        String splitChar = String.valueOf(str.charAt(new Random().nextInt(str.length())));
        System.out.println("以" + splitChar + "分割");
        TreeSet<String> set = new TreeSet<>(Arrays.asList(str.split(splitChar)));
        System.out.println("整理后 => " + set);
    }
}
