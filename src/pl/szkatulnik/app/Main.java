package pl.szkatulnik.app;

import pl.szkatulnik.app.enums.Language;
import pl.szkatulnik.app.generator.Generator;
import pl.szkatulnik.app.generator.GeneratorManager;
import pl.szkatulnik.app.generator.impl.JavaGenerator;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;

public class Main extends JPanel
{
    private static final String VERSION = "1.0";

    private Main()
    {
        final JLabel label1 = new JLabel("                                                          JunkCode-Generator v" + VERSION + " - github.com/mszkatulnik");

        final JComboBox languageBox = new JComboBox(Language.values());
        final JButton generateButton = new JButton("Generate");

        final JButton copyBtn = new JButton("Copy");
        final JTextArea codeBox = new JTextArea();
        codeBox.setEditable(false);
        final JScrollPane codeScroll = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        codeScroll.setViewportView(codeBox);

        generateButton.addActionListener(e ->
        {
            final Generator generator = GeneratorManager.getGenerator(Language.valueOf(languageBox.getSelectedItem().toString()));

            if (generator != null)
            {
                codeBox.setText(generator.generate());
            }
        });

        copyBtn.addActionListener(e -> Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(codeBox.getText()), null));

        this.setPreferredSize(new Dimension(650, 377));
        this.setLayout(null);

        this.add(label1);
        this.add(languageBox);
        this.add(generateButton);
        this.add(copyBtn);
        this.add(codeScroll);

        label1.setBounds(0, 0, 650, 55);

        languageBox.setBounds(10, 65, 100, 25);
        generateButton.setBounds(115, 65, 100, 25);

        copyBtn.setBounds(540, 65, 100, 25);
        codeScroll.setBounds(10, 95, 630, 270);
    }

    public static void main(String... args)
    {
        GeneratorManager.registerGenerators(new JavaGenerator());

        final JFrame frame = new JFrame("junkcode-generator v" + VERSION);
        frame.setResizable(false);
        frame.getContentPane().add(new Main());
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
}