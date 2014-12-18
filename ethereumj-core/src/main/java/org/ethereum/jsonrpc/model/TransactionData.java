package org.ethereum.jsonrpc.model;

import org.ethereum.core.Transaction;

import static org.ethereum.jsonrpc.Utils.bytes2Long;
import static org.ethereum.jsonrpc.Utils.toHexStringNullSafe;

public class TransactionData {

    private String hash;
    private String nonce;
    private String value;
    private String to;
    private String gasPrice;
    private long gas;
    private String input;
    private String from;

    public TransactionData(Transaction tx) {
        if(tx == null) {
            return;
        }
        hash = "0x" + toHexStringNullSafe(tx.getHash());
        nonce = "0x" + toHexStringNullSafe(tx.getNonce());
        value = "0x" + toHexStringNullSafe(tx.getValue());
        to = "0x" + (toHexStringNullSafe(tx.getReceiveAddress()) == null ? "0000000000000000000000000000000000000000" :
                toHexStringNullSafe(tx.getReceiveAddress()));
        gasPrice = "0x" + toHexStringNullSafe(tx.getGasPrice());
        gas = bytes2Long(tx.getGasLimit());
        input = "0x" + toHexStringNullSafe(tx.getData());
        from = "0x" + toHexStringNullSafe(tx.getSender());

    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TransactionData{");
        sb.append("hash='").append(hash).append('\'');
        sb.append(", nonce='").append(nonce).append('\'');
        sb.append(", value='").append(value).append('\'');
        sb.append(", receiveAddress='").append(to).append('\'');
        sb.append(", gasPrice='").append(gasPrice).append('\'');
        sb.append(", data='").append(input).append('\'');
        sb.append(", sender='").append(from).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getHash() {
        return hash;
    }

    public String getNonce() {
        return nonce;
    }

    public String getValue() {
        return value;
    }

    public String getTo() {
        return to;
    }

    public String getGasPrice() {
        return gasPrice;
    }

    public long getGas() {
        return gas;
    }

    public String getInput() {
        return input;
    }

    public String getFrom() {
        return from;
    }
}


