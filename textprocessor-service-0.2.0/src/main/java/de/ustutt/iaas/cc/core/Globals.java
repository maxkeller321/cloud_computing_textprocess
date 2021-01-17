package de.ustutt.iaas.cc.core;

public class Globals {

    private static int latencyMs = 0;

    public static int getLatencyMs() {
	return latencyMs;
    }

    public static void setLatencyMs(int latencyMs) {
	Globals.latencyMs = latencyMs;
    }

}
