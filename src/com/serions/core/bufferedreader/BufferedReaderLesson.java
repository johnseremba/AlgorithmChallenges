package com.serions.core.bufferedreader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.stream.Collectors;

public class BufferedReaderLesson {
    public static void main(String[] args) {
        // Buffered reader simplifies reading text from a character input stream.
        // Buffers the characters in order ot enable efficient reading of text data
        // Minimizes the number of I/O operations by reading chucks of characters & storing them in an internal buffer

        String bigString = "photo.jpg, Warsaw, 2013-09-05 14:08:15\n" +
                "john.png, London, 2015-06-20 15:13:22\n" +
                "myFriends.png, Warsaw, 2013-09-05 14:07:13\n" +
                "Eiffel.jpg, Paris, 2015-07-23 08:03:02\n" +
                "pisatower.jpg, Paris, 2015-07-22 23:59:59\n" +
                "BOB.jpg, London, 2015-08-05 00:02:03\n" +
                "notredame.png, Paris, 2015-09-01 12:00:00\n" +
                "me.jpg, Warsaw, 2013-09-06 15:40:22\n" +
                "a.png, Warsaw, 2016-02-13 13:33:50\n" +
                "b.jpg, Warsaw, 2016-01-02 15:12:22\n" +
                "c.jpg, Warsaw, 2016-01-02 14:34:30\n" +
                "d.jpg, Warsaw, 2016-01-02 15:15:01\n" +
                "e.png, Warsaw, 2016-01-02 09:49:09\n" +
                "f.png, Warsaw, 2016-01-02 10:55:32\n" +
                "g.jpg, Warsaw, 2016-02-29 22:13:11";
        bufferedReading(bigString);
        try {
            bufferedReading2(bigString);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        readAsSkipping();
    }

    private static void bufferedReading(String str) {
        BufferedReader reader = new BufferedReader(new StringReader(str));
        // reading line by line
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        try {
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(i).append(", ").append(line);
                stringBuilder.append(System.lineSeparator());
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(stringBuilder.toString());
    }

    // automatically closing the stream
    private static void bufferedReading2(String str) throws IOException {
        try (BufferedReader reader = new BufferedReader(new StringReader(str))) {
            String result = reader.lines().collect(Collectors.joining(System.lineSeparator()));
            System.out.println(result);
        }
    }

    // skipping characters
    private static void readAsSkipping() {
        try {
            String result = readReadCharacters("1__2__3__4__5");
            System.out.println(result);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private static String readReadCharacters(String str) throws IOException {
        StringBuilder result = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new StringReader(str))) {
            int value;
            while((value = reader.read()) != -1) {
                result.append((char) value);
                reader.skip(2L);
            }
        }
        return result.toString();
    }
}
