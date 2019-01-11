package ru.alfastrah.interplat.bus.opentext.card.entities;

public enum DocumentType {
    ACT("28"),
    AGREEMENT("27"),
    CONTRACT("26");

    private String id;

    DocumentType(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
