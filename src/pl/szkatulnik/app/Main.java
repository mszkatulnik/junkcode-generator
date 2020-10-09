package pl.szkatulnik.app;

import pl.szkatulnik.app.enums.Language;
import pl.szkatulnik.app.generator.Generator;
import pl.szkatulnik.app.generator.GeneratorManager;
import pl.szkatulnik.app.generator.impl.CppGenerator;
import pl.szkatulnik.app.generator.impl.JavaGenerator;
import pl.szkatulnik.app.generator.impl.PythonGenerator;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.util.Objects;

public class Main extends JPanel
{
    private static final String VERSION = "1.2";

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

        final JLabel label2 = new JLabel("Prefix:");
        final JTextField prefixBox = new JTextField();

        final JLabel label3 = new JLabel("Variables count:");
        final JTextField variablesCountBox = new JTextField();

        final JLabel label4 = new JLabel("Methods count:");
        final JTextField methodsCountBox = new JTextField();

        final JLabel label5 = new JLabel("Variables in method count:");
        final JTextField variablesMethodCountBox = new JTextField();

        generateButton.addActionListener(e ->
        {
            final Generator generator = GeneratorManager.getGenerator(Language.valueOf(Objects.requireNonNull(languageBox.getSelectedItem()).toString()));

            int variablesCount = -1, methodsCount = -1, variablesMethodCount = -1;
            try
            {
                variablesCount = Integer.parseInt(variablesCountBox.getText());
                methodsCount = Integer.parseInt(methodsCountBox.getText());
                variablesMethodCount = Integer.parseInt(variablesMethodCountBox.getText());
            } catch (Exception ignored)
            {
            }

            if (variablesCount < 0 || methodsCount < 0 || variablesMethodCount < 0)
            {
                return;
            }

            if (generator != null)
            {
                codeBox.setText(generator.generate(prefixBox.getText().isBlank() ? "junkcode" : prefixBox.getText().isEmpty() ? "junkcode" : prefixBox.getText(), variablesCount, methodsCount, variablesMethodCount));
            }
        });

        copyBtn.addActionListener(e -> Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(codeBox.getText()), null));

        this.setPreferredSize(new Dimension(432, 582));
        this.setLayout(null);

        this.add(label1);
        this.add(languageBox);
        this.add(generateButton);
        this.add(copyBtn);
        this.add(codeScroll);
        this.add(label2);
        this.add(prefixBox);
        this.add(label3);
        this.add(variablesCountBox);
        this.add(label4);
        this.add(methodsCountBox);
        this.add(label5);
        this.add(variablesMethodCountBox);

        label1.setBounds(-90, 5, 650, 55);

        languageBox.setBounds(10, 60, 310, 25);
        generateButton.setBounds(325, 60, 100, 25);

        copyBtn.setBounds(325, 275, 100, 25);
        codeScroll.setBounds(10, 305, 415, 270);

        label2.setBounds(10, 100, 100, 25);
        prefixBox.setBounds(10, 125, 310, 25);

        label3.setBounds(10, 150, 100, 25);
        variablesCountBox.setBounds(10, 175, 310, 25);

        label4.setBounds(10, 200, 100, 25);
        methodsCountBox.setBounds(10, 225, 310, 30);

        label5.setBounds(10, 250, 170, 25);
        variablesMethodCountBox.setBounds(10, 275, 310, 25);
    }

    public static void main(String... args)
    {
        GeneratorManager.registerGenerators(new JavaGenerator(), new PythonGenerator(), new CppGenerator());

        final JFrame frame = new JFrame("junkcode-generator v" + VERSION);
        frame.setResizable(false);
        frame.getContentPane().add(new Main());
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
}