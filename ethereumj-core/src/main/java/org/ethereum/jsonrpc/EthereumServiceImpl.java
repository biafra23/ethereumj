package org.ethereum.jsonrpc;

import org.ethereum.core.Block;
import org.ethereum.facade.Blockchain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EthereumServiceImpl implements EthereumService {

    private static final Logger logger = LoggerFactory.getLogger("service");

    @Autowired
    //    @Qualifier("main")
            Blockchain blockChain;

    @Override
    public String eth_coinbase() {
        return "0x3298478293748923784972498";
    }

    @Override
    public Block eth_getBlockByNumber(long blockNr) {
        Block block = blockChain.getBlockByNumber(blockNr);
        return block;
    }

    @Override
    public String eth_getBlockByHash(byte[] hash) {
        return blockChain.getBlockByHash(hash).toFlatString();
    }
}
