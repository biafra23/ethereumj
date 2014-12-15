package org.ethereum;

import org.ethereum.cli.CLIInterface;
import org.ethereum.config.SystemProperties;
import org.ethereum.facade.Ethereum;
import org.ethereum.facade.EthereumFactory;
import org.ethereum.jsonrpc.WebServer;
import org.ethereum.jsonrpc.WebServerConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * www.etherj.com
 */

public class Start {
    public static void main(String args[]) throws Exception {
        CLIInterface.call(args);
        WebServer server = new WebServer(WebServerConfig.Factory.newDevelopmentConfig("happy", 8080, "localhost"));
        server.start();
        Ethereum ethereum = EthereumFactory.createEthereum();
        ethereum.connect(SystemProperties.CONFIG.activePeerIP(), SystemProperties.CONFIG.activePeerPort());
        server.join();
    }
}
