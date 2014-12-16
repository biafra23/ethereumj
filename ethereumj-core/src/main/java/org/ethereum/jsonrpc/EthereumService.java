package org.ethereum.jsonrpc;

import org.ethereum.jsonrpc.model.BlockData;

public interface EthereumService {

    public String eth_coinbase();

    public BlockData eth_blockByNumber(long blockNr);

    public BlockData eth_blockByHash(String hash);

    public String eth_balanceAt(String address);
}
