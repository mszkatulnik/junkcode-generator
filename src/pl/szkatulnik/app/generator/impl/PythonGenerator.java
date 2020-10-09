package pl.szkatulnik.app.generator.impl;

import pl.szkatulnik.app.enums.Language;
import pl.szkatulnik.app.generator.Generator;
import pl.szkatulnik.app.utils.RandomUtil;

public class PythonGenerator extends Generator
{
    public PythonGenerator()
    {
        super(Language.Python);
    }

    @Override
    public String generate(String prefix, int variablesCount, int methodsCount, int variablesInMethodCount)
    {
        final StringBuilder builder = new StringBuilder();

        //variables
        for (int i = 0; i < variablesCount; i++)
        {
            final String variable = RandomUtil.getRandomVariable();
            switch (variable)
            {
                case "string":
                    builder.append(prefix).append("_").append(RandomUtil.getRandomString()).append(" = \"").append(RandomUtil.getRandomString()).append("\"");
                    break;
                case "int":
                    builder.append(prefix).append("_").append(RandomUtil.getRandomString()).append(" = ").append(RandomUtil.getRandomInt());
                    break;
                case "float":
                    builder.append(prefix).append("_").append(RandomUtil.getRandomString()).append(" = ").append(RandomUtil.getRandomFloat());
                    break;
                default:
                    break;
            }
            builder.append("\n");
        }

        //methods
        for (int i = 0; i < methodsCount; i++)
        {
            builder.append("\ndef ").append(prefix).append("_").append(RandomUtil.getRandomString()).append("():\n\t");
            for (int j = 0; j < variablesInMethodCount; j++)
            {
                final String variable = RandomUtil.getRandomVariable();
                switch (variable)
                {
                    case "string":
                        builder.append(prefix).append("_").append(RandomUtil.getRandomString()).append(" = \"").append(RandomUtil.getRandomString()).append("\"\n");
                        break;
                    case "int":
                        builder.append(prefix).append("_").append(RandomUtil.getRandomString()).append(" = ").append(RandomUtil.getRandomInt()).append("\n");
                        break;
                    case "float":
                        builder.append(prefix).append("_").append(RandomUtil.getRandomString()).append(" = ").append(RandomUtil.getRandomFloat()).append("\n");
                        break;
                    default:
                        break;
                }
                builder.append("\t");
            }
            builder.append("\n");
        }

        return builder.toString();
    }
}