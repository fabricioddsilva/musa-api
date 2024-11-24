package com.kaos.musa.entities.enums;

public enum TrailLevel {
    INICIANTE("iniciante"),
    INTERMEDIARIO("intermediário"),
    AVANCADO("avançado");

    private String trailLevel;

    TrailLevel(String level){
        this.trailLevel = level;
    }

    public String getTrailLevel() {
        return trailLevel;
    }
}
