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

    /*
    {
        "id" : 1,
        "jsonrpc" : "2.0",
        "result" : {
            "difficulty" : "0x0327c5",
            "extraData" : "0x0000000000000000000000000000000000000000000000000000000000000000",
            "gasLimit" : 300018,
            "hash" : "ee670ec64341771606e55d6b4ca35a1a6b75ee3d5145a99d05921026d1527331",
            "minGasPrice" : "0x09184e72a000",
            "miner" : "0x82022c34d173cf3b83c6e4553d627276fff6b66d",
            "nonce" : "0xc2adfa12f40d142eb585b0b7892cd0841cf30dd18cb88940a5323df767f0db2f",
            "number" : 1231,
            "parentHash" : "0xaa322b7bd7418b4328f0c7b350359a86d6b9b698ef584937447743b082eed099",
            "sha3Uncles" : "0x1dcc4de8dec75d7aab85b567b6ccd41ad312451b948a7413f0a142fd40d49347",
            "stateRoot" : "0x86df58f157e5ff5b77a6b1cddb43a2616acbaa7907087e0effb339e14c23a5db",
            "timestamp" : 1416509555,
            "transactionsRoot" : "0x56e81f171bcc55a6ff8345e692c0f86e5b48e01b996cadc001622fb5e363b421"
        }
    }
     */
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
