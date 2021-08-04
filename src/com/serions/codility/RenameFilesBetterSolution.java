package com.serions.codility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.*;
import java.util.stream.Collectors;

public class RenameFilesBetterSolution {
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
    }

    private static String solution(String S) {
        BufferedReader reader = new BufferedReader(new StringReader(S));
        String line;
        List<Photo> photoList = new ArrayList<>();
        try {
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Photo photo = new Photo(data[0], data[1], data[2]);
                photoList.add(photo);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        Map<String, List<Photo>> groupedByCity = photoList.stream().collect(Collectors.groupingBy(Photo::getCity));

        for (List<Photo> photos : groupedByCity.values()) {
            Collections.sort(photos);
            int sizeLength = String.valueOf(photos.size()).length();
            for (int i = 0; i < photos.size(); i++) {
                int size = String.valueOf(i + 1).length();
                int counter = sizeLength - size;
                String prefix = "";
                if (counter > 0) {
                    prefix = String.format(String.format("%%%ds", counter), "").replace(" ", "0");
                }
                photos.get(i).setPosition(prefix + (i + 1));
            }
        }

        StringBuilder resultBuilder = new StringBuilder();
        for (Photo photo : photoList) {
            resultBuilder.append(photo.toString().trim()).append("\n");
        }
        return resultBuilder.toString();
    }
}

class Photo implements Comparable<Photo> {
    private String name;
    private String city;
    private String time;
    private String extension;
    private String position;

    public Photo(String name, String city, String time) {
        this.name = name;
        this.city = city;
        this.time = time;
        this.extension = name.split("\\.")[1];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public int compareTo(Photo o) {
        return this.getTime().compareTo(o.getTime());
    }

    @Override
    public String toString() {
        return this.city + this.position + "." + this.extension;
    }
}
