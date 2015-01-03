package org.ethereum;

import org.ethereum.cli.CLIInterface;
import org.ethereum.facade.Ethereum;
import org.ethereum.facade.EthereumFactory;
import org.ethereum.jsonrpc.WebServer;
import org.ethereum.jsonrpc.WebServerConfig;

import static org.ethereum.config.SystemProperties.CONFIG;

/**
 * @author Roman Mandeleil
 * @since 14.11.2014
 */
public class Start {

    public static void main(String args[]) throws Exception {
        CLIInterface.call(args);
        Ethereum ethereum = EthereumFactory.createEthereum();

        if (CONFIG.jsonRpcEnabled()) {
            WebServer server = new WebServer(EthereumFactory.getContext(),
                    WebServerConfig.Factory.newDevelopmentConfig("jetty", CONFIG.jsonRpcListenPort(),
                            CONFIG.jsonRpcListenIp()));
            server.start();
            ethereum.connect(CONFIG.activePeerIP(), CONFIG.activePeerPort());
            server.join();
        } else {
            ethereum.connect(CONFIG.activePeerIP(), CONFIG.activePeerPort());
        }
    }
}
