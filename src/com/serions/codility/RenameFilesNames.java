package com.serions.codility;

import java.io.*;
import java.util.*;

public class RenameFilesNames {
    public static void main(String[] args) {
        System.out.println(solution(
                "photo.jpg, Warsaw, 2013-09-05 14:08:15\n" +
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
                "g.jpg, Warsaw, 2016-02-29 22:13:11"));
        System.out.println("--------------------------------------------------");
        System.out.println(solution2(
                "photo.jpg, Warsaw, 2013-09-05 14:08:15\n" +
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
                        "g.jpg, Warsaw, 2016-02-29 22:13:11"));
    }

    private static String solution2(String S) {
        BufferedReader reader = new BufferedReader(new StringReader(S));
        String line;
        Map<String, List<String>> cityWithPhotos = new HashMap<>();
        int N = 0;
        try {
            while ((line = reader.readLine()) != null) {
                String[] photo = line.split(",");
                String photoName = N + "." + photo[0].split("\\.")[1];
                if (cityWithPhotos.containsKey(photo[1])) {
                    cityWithPhotos.get(photo[1]).add(photoName);
                } else {
                    cityWithPhotos.put(photo[1], new ArrayList<>() {{ add(photoName); }});
                }
                N++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Rename photos
        String[] result = new String[N];
        for(Map.Entry<String, List<String>> entry : cityWithPhotos.entrySet()) {
            int padding = String.valueOf(entry.getValue().size()).length();
            for (int i = 0; i < entry.getValue().size(); i++) {
                String name = entry.getValue().get(i);
                String[] nameList = name.split("\\.");
                String nameBuilder = entry.getKey() +
                        String.format("%0" + padding + "d", i + 1) +
                        "." + nameList[1] +
                        System.lineSeparator();
                result[Integer.parseInt(nameList[0])] = nameBuilder;
            }
        }
        return String.join("", result);
    }

    private static String solution(String S) {
        /**
         * group by city
         * then by time
         * then consecutive natural numbers starting from 1
         * new name #City#PhotoNumber (same length of largest no in group),leading 0s #ext
         * Return a string with names of new photos, maintain order
         * Output;
         * Warsaw02.jpg
         */
        String newString = S.replaceAll(",", "");
        String[] stringList = newString.split("\\n");
        HashMap<String, List<String>> photosByCity = new HashMap<>();
        for (int i=0; i<stringList.length; i++) {
            String str = stringList[i];
            String[] rawData = str.split(" ");
            String cityWithIndex = String.valueOf(i).concat("->");
            String extension = "." + rawData[0].split("\\.")[1];
            if (photosByCity.containsKey(rawData[1])) {
                int counter = photosByCity.get(rawData[1]).size() + 1;
                photosByCity.get(rawData[1]).add(cityWithIndex.concat(String.valueOf(counter)).concat(extension));
            } else {
                photosByCity.put(rawData[1], new ArrayList<>() {{ add(cityWithIndex.concat(String.valueOf(1)).concat(extension)); }});
            }
        }

        // Rename files
        String[] result = new String[stringList.length];
        for(Map.Entry<String, List<String>> entry : photosByCity.entrySet()) {
            List<String> picsList = entry.getValue();
            int padding = String.valueOf(picsList.size()).length();
            for (String pic: picsList) {
                String[] indexAndCounter = pic.split("->");
                String paddedName = padString(padding, indexAndCounter[1]);
                result[Integer.parseInt(indexAndCounter[0])] = ((String) entry.getKey()).concat(paddedName);
            }
        }

        StringBuilder builder = new StringBuilder();
        for(String str : result) {
            builder.append(str).append("\n");
        }
        return builder.toString();
    }

    private static String padString(int padding, String str) {
        String result = String.format("%" + (padding + 4) + "s", str).replace(' ', '0');
        return result;
    }
}
