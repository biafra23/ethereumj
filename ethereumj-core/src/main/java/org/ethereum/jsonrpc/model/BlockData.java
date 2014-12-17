package org.ethereum.jsonrpc.model;

import org.ethereum.core.Block;
import org.spongycastle.util.encoders.Hex;

public class BlockData {

    private String difficulty;
    private String extraData;
    private long gasLimit;
    private String hash;
    private String minGasPrice;
    private String miner;
    private String nonce;
    private long number;
    private String parentHash;
    private String sha3Uncles;
    private String stateRoot;
    private long timestamp;
    private String transactionsRoot;

    public BlockData(Block block) {
        difficulty = "0x" + Hex.toHexString(block.getDifficulty());
        if(block.getExtraData() == null) {
            extraData = "0x0000000000000000000000000000000000000000000000000000000000000000";
        } else {
            extraData = "0x" + Hex.toHexString(block.getExtraData());
        }
        gasLimit = block.getGasLimit();
        hash = Hex.toHexString(block.getHash());
//        minGasPrice = "0x" + Long.toHexString(block.getGasUsed());
        miner = "0x" + Hex.toHexString(block.getCoinbase());
        nonce = "0x" + Hex.toHexString(block.getNonce());
        number = block.getNumber();
        parentHash = "0x" + Hex.toHexString(block.getParentHash());
        sha3Uncles = "0x" + Hex.toHexString(block.getUnclesHash());
        stateRoot = "0x" + Hex.toHexString(block.getStateRoot());
        timestamp = block.getTimestamp();
//        transactionsRoot = "0x" + Hex.toHexString(block.getTxTrieRoot());
    }

    public String getDifficulty() {
        return difficulty;
    }

    public String getExtraData() {
        return extraData;
    }

    public long getGasLimit() {
        return gasLimit;
    }

    public String getHash() {
        return hash;
    }

    public String getMinGasPrice() {
        return minGasPrice;
    }

    public String getMiner() {
        return miner;
    }

    public String getNonce() {
        return nonce;
    }

    public long getNumber() {
        return number;
    }

    public String getParentHash() {
        return parentHash;
    }

    public String getSha3Uncles() {
        return sha3Uncles;
    }

    public String getStateRoot() {
        return stateRoot;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getTransactionsRoot() {
        return transactionsRoot;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("BlockData{");
        sb.append("difficulty='").append(difficulty).append('\'');
        sb.append(", extraData='").append(extraData).append('\'');
        sb.append(", gasLimit=").append(gasLimit);
        sb.append(", hash='").append(hash).append('\'');
        sb.append(", minGasPrice='").append(minGasPrice).append('\'');
        sb.append(", miner='").append(miner).append('\'');
        sb.append(", nonce='").append(nonce).append('\'');
        sb.append(", number=").append(number);
        sb.append(", parentHash='").append(parentHash).append('\'');
        sb.append(", sha3Uncles='").append(sha3Uncles).append('\'');
        sb.append(", stateRoot='").append(stateRoot).append('\'');
        sb.append(", timestamp=").append(timestamp);
        sb.append(", transactionsRoot='").append(transactionsRoot).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
