package org.ethereum.jsonrpc;

import org.ethereum.facade.Blockchain;
import org.ethereum.manager.WorldManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class EthereumServiceImpl implements EthereumService {

    private static final Logger logger = LoggerFactory.getLogger("service");

    @Autowired
    @Qualifier("main")
    Blockchain blockChain;



    @Override
    public String eth_coinbase() {
        return "0x3298478293748923784972498";
    }

    @Override
    public String eth_getBlockByNumber(long blockNr) {
        return blockChain.getBlockByNumber(blockNr).toFlatString();
    }

    @Override
    public String eth_getBlockByHash(byte[] hash) {
        return blockChain.getBlockByHash(hash).toFlatString();
    }
}
