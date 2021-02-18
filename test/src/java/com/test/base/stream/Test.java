package com.test.base.stream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Consumer;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) throws IOException {
        String context = new String(
                Files.readAllBytes(Paths.get("D:\\MyNote\\JavaBaseLearn\\Container.md")), StandardCharsets.UTF_8
        );
        List<String> words = Arrays.asList(context.split("\\PL+"));

        // stream will be invalid when it be closed or operated

        // one thread execute
        long count = words.stream().filter(w -> w.length() > 3).count();
        System.out.println(count);

        // multiple thread execute
        long count1 = words.parallelStream().filter(w -> w.length() > 3).count();
        System.out.println(count1);

        // convert the array to stream
        Stream<String> words2 = Stream.of(context.split("\\PL+"));
        words2.forEach(w -> System.out.print(w + " "));
        System.out.println();
        Stream<String> words3 = Arrays.stream(context.split("\\PL+"), 5, 80);
        System.out.println(words3.filter(w -> w.contains("w")).count());

        // infinity stream
        //Stream<Double> randoms = Stream.generate(Math::random);
        //randoms.forEach(System.out::println);
        // make the second parameter lambda expression takes effect in the first parameter
        // seems using the first parameter as the parameter of second lambda expression
        //Stream<BigInteger> integers = Stream.iterate(BigInteger.ZERO, w -> w.add(BigInteger.TEN));
        //integers.forEach(System.out::println);

/*
        Stream<String> stringStream = Pattern.compile("\\PL+").splitAsStream(context);
        stringStream.forEach(w-> System.out.print(w+" "));
        System.out.println();
        try {
            Stream<String> lines = Files.lines(Paths.get("D:\\MyNote\\JavaBaseLearn\\Container.md"));
            lines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
*/


        Optional<String> largest= words.stream().max(String::compareToIgnoreCase);
        System.out.println("largest:"+largest.orElse(""));

        Test.skipSpaceAtEnd("F:\\source.txt", "F:\\dest.txt");

        List<String> testString = new LinkedList<>();
        testString.addAll(Arrays.asList(new String(
                Files.readAllBytes(Paths.get("D:\\MyNote\\JavaBaseLearn\\Container.md"))
        ).split("\n")));
        Integer reduce = testString.stream().reduce(0, (total, word) -> total + word.length(), Integer::sum);
        System.out.println(reduce);
    }

    public static void skipSpaceAtEnd(String fileSrcPath, String fileDestPath) throws IOException {
        Stream<String> lines = Files.lines(Paths.get(fileSrcPath));
        List<String> dealData = new LinkedList<>();
        Iterator<String> iterator = lines.iterator();
        for (int i = 0; iterator.hasNext(); i++){
            String next = iterator.next();
            if (i%3 == 0){
                next = next
                        .replace("ɔ", "o")
                        .replace("æ", "a")
                        .replace("ə", "e")
                        .replace("ʃ", "f")
                        .replace("ŋ", "n")
                        .replace("ә", "e");
            }
            dealData.add(next);
        }
        PrintWriter writer = new PrintWriter(fileDestPath);
        dealData.forEach(w->writer.write(w+"\n"));
        writer.flush();
        writer.close();
    }
}
