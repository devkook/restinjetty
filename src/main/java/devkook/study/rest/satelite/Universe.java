package devkook.study.rest.satelite;

import java.util.Random;

public class Universe {

    public static long whatTimeIsItNow() {
        return Universe.myAge();
    }

    private static long myAge() {
        // TODO 가라데이타임
        long range = 1234567L;
        Random r = new Random();
        long age = (long) (r.nextDouble() * range);
        return age;
    }
}
