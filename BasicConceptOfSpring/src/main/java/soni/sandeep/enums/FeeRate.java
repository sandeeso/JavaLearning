package soni.sandeep.enums;

public enum FeeRate {
    FR1("1"),
    FR2("2"),
    FR3("3");

    public String getFeer() {
        return feer;
    }

    public void setFeer(String feer) {
        this.feer = feer;
    }

    public String feer;
     FeeRate(String feer) {
        this.feer=feer;

    }
}
