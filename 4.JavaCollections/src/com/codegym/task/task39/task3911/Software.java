package com.codegym.task.task39.task3911;

import java.util.*;

public class Software {
    int currentVersion;

    private Map<Integer, String> versionHistoryMap = new LinkedHashMap<>();

    public void addNewVersion(int version, String description) {
        if (version > currentVersion) {
            versionHistoryMap.put(version, description);
            currentVersion = version;
        }
    }

    public int getCurrentVersion() {
        return currentVersion;
    }

    public Map<Integer, String> getVersionHistoryMap() {
        return Collections.unmodifiableMap(versionHistoryMap);
    }

    public boolean rollback(int rollbackVersion) {
        Map<Integer, String> newVersion = new LinkedHashMap<>();
        String s = versionHistoryMap.get(rollbackVersion);

        if(s==null)
            return false;

        newVersion.put(rollbackVersion, s);
        versionHistoryMap = newVersion;
        currentVersion = rollbackVersion;
        return true;
    }
}
