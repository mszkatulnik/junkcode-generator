package pl.szkatulnik.app.generator;

import pl.szkatulnik.app.enums.Language;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GeneratorManager
{
    private static final Map<Language, Generator> generatorMap = new HashMap<>();

    public static void registerGenerators(Generator... generators)
    {
        Arrays.stream(generators).forEach(generator -> generatorMap.put(generator.getLanguage(), generator));
    }

    public static Generator getGenerator(Language language)
    {
        return generatorMap.get(language);
    }
}