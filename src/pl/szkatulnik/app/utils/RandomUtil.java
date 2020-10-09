package pl.szkatulnik.app.utils;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomUtil
{
    private static final Random random = new Random();

    public static String getRandomVariable()
    {
        final String[] variables = new String[] { "string", "int", "float" };
        return variables[random.nextInt(variables.length)];
    }

    public static float getRandomFloat()
    {
        return random.nextFloat();
    }

    public static int getRandomInt()
    {
        return random.nextInt(65535);
    }

    public static String getRandomString()
    {
        final char[] characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

        return IntStream.range(0, 32)
                .mapToObj(i -> String.valueOf(characters[random.nextInt(characters.length)]))
                .collect(Collectors.joining());
    }
}