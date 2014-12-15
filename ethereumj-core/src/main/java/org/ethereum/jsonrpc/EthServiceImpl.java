package org.ethereum.jsonrpc;

import org.springframework.stereotype.Component;

public class EthServiceImpl implements EthService {

    @Override
    public String eth_coinbase() {
        return "123456789";
    }
}
