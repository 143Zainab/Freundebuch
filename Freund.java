public class Freund {
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

    public String getName() {
        return name;
    }

    public String getGeburtsdatum() {
        return geburtsdatum;
    }

    public String getSternzeichen() {
        return sternzeichen;
    }

    public boolean isSingle() {
        return single;
    }

    public String getAugenfarbe() {
        return augenfarbe;
    }

    public String getSuperkraft() {
        return superkraft;
    }
}
