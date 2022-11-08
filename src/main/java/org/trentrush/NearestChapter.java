package org.trentrush;

import java.util.Comparator;
import java.util.stream.Stream;

/**
 * @Link <a href="https://edabit.com/challenge/WtxvjezcFYGQo2v48">Nearest Chapter Challenge</a>
 */
public class NearestChapter {
    public static void main(String[] args) {
        System.out.println(nearestChapter(new Chapter[] {
                new Chapter("Chapter 1", 1),
                new Chapter("Chapter 2", 15),
                new Chapter("Chapter 3", 37)
        }, 10));

        System.out.println(nearestChapter(new Chapter[] {
                new Chapter("New Beginnings", 1),
                new Chapter("Strange Developments", 62),
                new Chapter("The End?", 194),
                new Chapter("The True Ending", 460)
        }, 200));

        System.out.println(nearestChapter(new Chapter[] {
                new Chapter("Chapter 1a", 1),
                new Chapter("Chapter 1b", 5)
        }, 3));
    }

    public static String nearestChapter(Chapter[] chapter, int page) {
        return Stream.of(chapter)
                .sorted(Comparator.comparing(Chapter::getPage).reversed())
                .min(Comparator.comparingInt(currentChapter -> Math.abs(currentChapter.getPage() - page)))
                .orElseThrow().getName();
    }
}
class Chapter {
    private final String name;
    private final int page;

    public Chapter(String name, int page) {
        this.name = name;
        this.page = page;
    }
    public String getName() { return name; }
    public int getPage() { return page; }
}