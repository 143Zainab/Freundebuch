import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Freundebuch {
    // GUI-Komponenten
    private JLabel JLabelTitel;
    private JLabel JLabelName;
    private JLabel JLabelGeburtsdatum;
    private JLabel JLabelSternzeichen;
    private JLabel JLabelSingle;
    private JLabel JLabelAugenfarbe;
    private JLabel JLabelSuperkraft;
    private JTextField textFieldName;
    private JTextField textFieldGeburtsdatum;
    private JComboBox<String> comboBoxSternzeichen;
    private JCheckBox checkBoxJa;
    private JCheckBox checkBoxnein;
    private JComboBox<String> comboBoxAugenfarbe;
    private JComboBox<String> comboBoxSuperkraft;
    private JButton buttonspeichern;
    private JButton buttonanzeigen;
    private JList<String> listFreundeliste;
    private DefaultListModel<String> listModel;

    // Liste der Freunde (Datenmodell)
    private List<Freund> freunde;

    public static void main(String[] args) {
        // Programmstart mit dem Erzeugen der Hauptklasse
        SwingUtilities.invokeLater(Freundebuch::new);
    }

    // Konstruktor
    public Freundebuch() {
        // Initialisierung der Liste der Freunde
        freunde = new ArrayList<>();
        initObjekte(); // Beispielpersonen hinzufügen
        createAndShowGUI(); // Benutzeroberfläche erstellen
    }

    // Beispielpersonen zur Freundesliste hinzufügen
    private void initObjekte() {
        freunde.add(new Freund("Alice", "12.03.1990", "Fische", true, "Blau", "Fliegen"));
        freunde.add(new Freund("Bob", "01.01.1985", "Steinbock", false, "Braun", "Unsichtbarkeit"));
        freunde.add(new Freund("Clara", "25.12.1992", "Schütze", true, "Grün", "Zeitreisen"));
        freunde.add(new Freund("David", "15.07.1994", "Krebs", false, "Grau", "Teleportation"));
        freunde.add(new Freund("Eva", "20.06.1988", "Zwillinge", true, "Braun", "Gedanken lesen"));
    }

    // Benutzeroberfläche erstellen und anzeigen
    private void createAndShowGUI() {
        // Hauptfenster konfigurieren
        JFrame frame = new JFrame("Freundebuch");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        // Panel für die Eingaben (GridLayout für Felder)
        JPanel inputPanel = new JPanel(new GridLayout(7, 2));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Abstand zum Rand

        // Überschrift erstellen
        JLabelTitel = new JLabel("<html><u>Seiten der Freundschaft</u></html>", SwingConstants.CENTER); // Unterstrichen und zentriert
        JLabelTitel.setFont(new Font("SansSerif", Font.BOLD, 24)); // Schriftgröße und Fett
        JLabelTitel.setForeground(Color.WHITE);

        // Labels für die Eingabefelder (rechtsbündig mit Abstand)
        JLabelName = new JLabel("Name:", SwingConstants.RIGHT);
        JLabelName.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10)); // Abstand zwischen Label und Feld
        JLabelGeburtsdatum = new JLabel("Geburtsdatum (dd.MM.yyyy):", SwingConstants.RIGHT);
        JLabelGeburtsdatum.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        JLabelSternzeichen = new JLabel("Sternzeichen:", SwingConstants.RIGHT);
        JLabelSternzeichen.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        JLabelSingle = new JLabel("Single:", SwingConstants.RIGHT);
        JLabelSingle.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        JLabelAugenfarbe = new JLabel("Augenfarbe:", SwingConstants.RIGHT);
        JLabelAugenfarbe.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        JLabelSuperkraft = new JLabel("Superkraft:", SwingConstants.RIGHT);
        JLabelSuperkraft.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));

        // Eingabefelder und Auswahlelemente
        textFieldName = new JTextField();
        textFieldGeburtsdatum = new JTextField();
        comboBoxSternzeichen = new JComboBox<>(new String[]{"Fische", "Steinbock", "Schütze", "Wassermann", "Krebs", "Widder", "Stier", "Zwillinge", "Jungfrau", "Waage", "Skorpion", "Löwe"});
        checkBoxJa = new JCheckBox("Ja");
        checkBoxnein = new JCheckBox("Nein");
        comboBoxAugenfarbe = new JComboBox<>(new String[]{"Blau", "Braun", "Grün", "Grau", "Andere"});
        comboBoxSuperkraft = new JComboBox<>(new String[]{"Fliegen", "Unsichtbarkeit", "Zeitreisen", "Teleportation", "Gedanken lesen"});

        // Checkboxen gruppieren (für "Single")
        ButtonGroup singleGroup = new ButtonGroup();
        singleGroup.add(checkBoxJa);
        singleGroup.add(checkBoxnein);

        // Buttons für Aktionen
        buttonspeichern = new JButton("Speichern");
        buttonanzeigen = new JButton("Anzeigen");

        // Liste für gespeicherte Freunde
        listModel = new DefaultListModel<>();
        listFreundeliste = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(listFreundeliste);

        // Farben und Design
        frame.getContentPane().setBackground(Color.PINK); // Hintergrundfarbe des Fensters
        inputPanel.setBackground(Color.PINK); // Hintergrundfarbe des Eingabepanels
        listFreundeliste.setBackground(Color.LIGHT_GRAY); // Hintergrund der Freundesliste

        // Eingabeelemente in das Panel einfügen
        inputPanel.add(JLabelName);
        inputPanel.add(textFieldName);
        inputPanel.add(JLabelGeburtsdatum);
        inputPanel.add(textFieldGeburtsdatum);
        inputPanel.add(JLabelSternzeichen);
        inputPanel.add(comboBoxSternzeichen);
        inputPanel.add(JLabelSingle);
        inputPanel.add(checkBoxJa);
        inputPanel.add(new JLabel()); // Leerplatz für bessere Struktur
        inputPanel.add(checkBoxnein);
        inputPanel.add(JLabelAugenfarbe);
        inputPanel.add(comboBoxAugenfarbe);
        inputPanel.add(JLabelSuperkraft);
        inputPanel.add(comboBoxSuperkraft);

        // Panel für die Buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.PINK); // Hintergrundfarbe der Buttons
        buttonPanel.add(buttonspeichern);
        buttonPanel.add(buttonanzeigen);

        // Komponenten in das Fenster einfügen
        frame.add(JLabelTitel, BorderLayout.NORTH); // Überschrift oben
        frame.add(inputPanel, BorderLayout.CENTER); // Eingabefelder
        frame.add(buttonPanel, BorderLayout.SOUTH); // Buttons
        frame.add(scrollPane, BorderLayout.EAST); // Freundesliste

        // Eventlistener für Speichern-Button
        buttonspeichern.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = textFieldName.getText().trim();
                    if (!name.matches("[a-zA-ZäöüÄÖÜß ]+")) {
                        throw new IllegalArgumentException("Name darf nur Buchstaben enthalten.");
                    }

                    String geburtsdatum = textFieldGeburtsdatum.getText().trim();
                    if (!geburtsdatum.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
                        throw new IllegalArgumentException("Geburtsdatum muss im Format dd.MM.yyyy sein.");
                    }

                    String sternzeichen = (String) comboBoxSternzeichen.getSelectedItem();
                    boolean single = checkBoxJa.isSelected();
                    String augenfarbe = (String) comboBoxAugenfarbe.getSelectedItem();
                    String superkraft = (String) comboBoxSuperkraft.getSelectedItem();

                    Freund neuerFreund = new Freund(name, geburtsdatum, sternzeichen, single, augenfarbe, superkraft);
                    freunde.add(neuerFreund);
                    listModel.addElement(name);

                    textFieldName.setText("");
                    textFieldGeburtsdatum.setText("");
                    checkBoxJa.setSelected(false);
                    checkBoxnein.setSelected(false);
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(frame, ex.getMessage(), "Eingabefehler", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Eventlistener für Anzeigen-Button
        buttonanzeigen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String superkraftFilter = JOptionPane.showInputDialog(frame, "Nach welcher Superkraft filtern?");
                if (superkraftFilter != null && !superkraftFilter.trim().isEmpty()) {
                    List<Freund> gefilterteFreunde = freunde.stream()
                            .filter(f -> f.getSuperkraft().equalsIgnoreCase(superkraftFilter.trim()))
                            .collect(Collectors.toList());

                    StringBuilder ergebnis = new StringBuilder("Gefilterte Freunde nach Superkraft: " + superkraftFilter + "\n");
                    for (Freund freund : gefilterteFreunde) {
                        ergebnis.append(freund).append("\n");
                    }

                    JOptionPane.showMessageDialog(frame, ergebnis.toString(), "Ergebnis", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        // Fenster sichtbar machen
        frame.setVisible(true);
    }

    // Klasse für Freund-Objekte
    private static class Freund {
        private String name;
        private String geburtsdatum;
        private String sternzeichen;
        private boolean single;
        private String augenfarbe;
        private String superkraft;

        public Freund(String name, String geburtsdatum, String sternzeichen, boolean single, String augenfarbe, String superkraft) {
            this.name = name;
            this.geburtsdatum = geburtsdatum;
            this.sternzeichen = sternzeichen;
            this.single = single;
            this.augenfarbe = augenfarbe;
            this.superkraft = superkraft;
        }

        public String getSuperkraft() {
            return superkraft;
        }

        public String toString() {
            return name + ", geboren am " + geburtsdatum + " (" + sternzeichen + "), Single: " + (single ? "Ja" : "Nein")
                    + ", Augenfarbe: " + augenfarbe + ", Superkraft: " + superkraft;
        }
    }
}
