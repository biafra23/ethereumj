package org.ethereum.jsonrpc;

public interface EthereumService {

    public String eth_coinbase();

    public String eth_getBlockByNumber(long blockNr);

    public String eth_getBlockByHash(byte[] hash);
}
