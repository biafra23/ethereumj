package org.ethereum.jsonrpc;

import org.springframework.stereotype.Component;

@Component
public interface EthService {
    public String eth_coinbase();
}
