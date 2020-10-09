package pl.szkatulnik.app.generator.impl;

import pl.szkatulnik.app.enums.Language;
import pl.szkatulnik.app.generator.Generator;
import pl.szkatulnik.app.utils.RandomUtil;

public class JavaGenerator extends Generator
{
    public JavaGenerator()
    {
        super(Language.JAVA);
    }

    @Override
    public String generate()
    {
        final StringBuilder builder = new StringBuilder();

        //variables
        for (int i = 0; i < 8; i++)
        {
            final String variable = RandomUtil.getRandomVariable();
            switch (variable)
            {
                case "String":
                    builder.append("private String ").append(RandomUtil.getRandomString()).append(" = \"").append(RandomUtil.getRandomString()).append("\";");
                    break;
                case "int":
                    builder.append("private int ").append(RandomUtil.getRandomString()).append(" = ").append(RandomUtil.getRandomInt()).append(";");
                    break;
                case "float":
                    builder.append("private float ").append(RandomUtil.getRandomString()).append(" = (float) ").append(RandomUtil.getRandomFloat()).append(";");
                    break;
                default:
                    break;
            }
            builder.append("\n");
        }

        //methods
        for (int i = 0; i < 8; i++)
        {
            builder.append("\nprivate void " + RandomUtil.getRandomString() + "() { ");
            for (int j = 0; j < 4; j++)
            {
                final String variable = RandomUtil.getRandomVariable();
                switch (variable)
                {
                    case "String":
                        builder.append("String ").append(RandomUtil.getRandomString()).append(" = \"").append(RandomUtil.getRandomString()).append("\"; ");
                        break;
                    case "int":
                        builder.append("int ").append(RandomUtil.getRandomString()).append(" = ").append(RandomUtil.getRandomInt()).append("; ");
                        break;
                    case "float":
                        builder.append("float ").append(RandomUtil.getRandomString()).append(" = (float) ").append(RandomUtil.getRandomFloat()).append("; ");
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