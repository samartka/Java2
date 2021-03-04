package com.company.proxy;

import java.util.ArrayList;
import java.util.List;

class ProxyInternet {
    private Internet internet;
    private static List<String> bannedSites;

    public ProxyInternet() {
        internet = new Internet();
        bannedSites = new ArrayList<String>();
        bannedSites.add("pornhub.com");
        bannedSites.add("redtube.com");
    }

    public String connectTo(String serverHost) {
        if (bannedSites.contains(serverHost.toLowerCase())) {
            return serverHost + " is access denied!!";
        }
        return internet.connectTo(serverHost);
    }
}