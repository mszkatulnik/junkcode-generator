package pl.szkatulnik.app.generator;

import pl.szkatulnik.app.enums.Language;

public abstract class Generator
{
    private Language language;

    public Generator(Language language)
    {
        this.language = language;
    }

    Language getLanguage()
    {
        return language;
    }

    public abstract String generate(String prefix, int variablesCount, int methodsCount, int variablesInMethodCount);
}