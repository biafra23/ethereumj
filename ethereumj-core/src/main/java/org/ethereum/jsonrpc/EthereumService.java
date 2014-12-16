package org.ethereum.jsonrpc;

import org.ethereum.core.Block;

public interface EthereumService {

    public String eth_coinbase();

    public Block eth_getBlockByNumber(long blockNr);

    public String eth_getBlockByHash(byte[] hash);
}
