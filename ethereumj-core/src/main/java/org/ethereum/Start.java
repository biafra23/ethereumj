package org.ethereum;

import org.ethereum.cli.CLIInterface;
import org.ethereum.config.SystemProperties;
import org.ethereum.facade.Ethereum;
import org.ethereum.facade.EthereumFactory;
import org.ethereum.jsonrpc.WebServer;
import org.ethereum.jsonrpc.WebServerConfig;

/**
 * www.etherj.com
 */

public class Start {

    public static void main(String args[]) throws Exception {
        CLIInterface.call(args);

        Ethereum ethereum = EthereumFactory.createEthereum();

        WebServer server = new WebServer(EthereumFactory.getContext(),
                WebServerConfig.Factory.newDevelopmentConfig("happy", 8080, "localhost"));
        server.start();

        ethereum.connect(SystemProperties.CONFIG.activePeerIP(), SystemProperties.CONFIG.activePeerPort());
        server.join();
    }
}
