package pl.szkatulnik.app.generator;

import pl.szkatulnik.app.enums.Language;

public abstract class Generator
{
    private Language language;

    public Generator(Language language)
    {
        this.language = language;
    }

    public Language getLanguage()
    {
        return language;
    }

    public abstract String generate();
}