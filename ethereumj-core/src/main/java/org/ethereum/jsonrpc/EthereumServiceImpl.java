package org.ethereum.jsonrpc;

import org.ethereum.core.Block;
import org.ethereum.facade.Blockchain;
import org.ethereum.facade.Repository;
import org.ethereum.jsonrpc.model.BlockData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongycastle.util.encoders.Hex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class EthereumServiceImpl implements EthereumService {

    private static final Logger logger = LoggerFactory.getLogger("service");

    @Autowired
    Blockchain blockChain;

    @Autowired
    private Repository repository;

    @Override
    public String eth_coinbase() {
        return "0x3298478293748923784972498";
    }

    @Override
    public BlockData eth_blockByNumber(long blockNr) {
        Block block = blockChain.getBlockByNumber(blockNr);
        if (block != null) {
            return new BlockData(block);
        }
        return null;
    }

    @Override
    public BlockData eth_blockByHash(String hashString) {
        logger.info("hashString: " + hashString);
        byte[] hash = Hex.decode(hashString);
        final Block block = blockChain.getBlockByHash(hash);
        if (block != null) {
            return new BlockData(block);
        }
        return null;
    }

    @Override
    public String eth_balanceAt(String addressString) {
        //Remove 0x prefix
        addressString = addressString.substring(2);
        logger.info("addressString: " + addressString);
        byte[] address = Hex.decode(addressString);

        BigInteger balance = repository.getBalance(address);
        return "0x" + Hex.toHexString(balance.toByteArray());
    }
}