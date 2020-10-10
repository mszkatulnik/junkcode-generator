package pl.szkatulnik.app.generator.impl;

import pl.szkatulnik.app.enums.Language;
import pl.szkatulnik.app.generator.Generator;
import pl.szkatulnik.app.utils.RandomUtil;

public class CSharpGenerator extends Generator
{
    public CSharpGenerator()
    {
        super(Language.CSharp);
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
                    builder.append("string ").append(prefix).append("_").append(RandomUtil.getRandomString()).append(" = \"").append(RandomUtil.getRandomString()).append("\";");
                    break;
                case "int":
                    builder.append("int ").append(prefix).append("_").append(RandomUtil.getRandomString()).append(" = ").append(RandomUtil.getRandomInt()).append(";");
                    break;
                case "float":
                    builder.append("float ").append(prefix).append("_").append(RandomUtil.getRandomString()).append(" = (float) ").append(RandomUtil.getRandomFloat()).append(";");
                    break;
                default:
                    break;
            }
            builder.append("\n");
        }

        //methods
        for (int i = 0; i < methodsCount; i++)
        {
            builder.append("\nvoid ").append(prefix).append("_").append(RandomUtil.getRandomString()).append("() { ");
            for (int j = 0; j < variablesInMethodCount; j++)
            {
                final String variable = RandomUtil.getRandomVariable();
                switch (variable)
                {
                    case "string":
                        builder.append("string ").append(prefix).append("_").append(RandomUtil.getRandomString()).append(" = \"").append(RandomUtil.getRandomString()).append("\"; ");
                        break;
                    case "int":
                        builder.append("int ").append(prefix).append("_").append(RandomUtil.getRandomString()).append(" = ").append(RandomUtil.getRandomInt()).append("; ");
                        break;
                    case "float":
                        builder.append("float ").append(prefix).append("_").append(RandomUtil.getRandomString()).append(" = (float) ").append(RandomUtil.getRandomFloat()).append("; ");
                        break;
                    default:
                        break;
                }
            }
            builder.append("}\n");
        }

        return builder.toString();
    }
}