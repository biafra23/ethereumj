package org.ethereum.jsonrpc;

import org.ethereum.core.Transaction;
import org.ethereum.jsonrpc.model.BlockData;
import org.ethereum.jsonrpc.model.TransactionData;

import java.util.List;

public interface EthereumService {

    public String eth_coinbase();

    public void eth_setCoinbase(String dummyValue);

    public Boolean eth_listening();

    public void eth_setListening(Boolean dummyValue);

    public Boolean eth_mining();

    public void eth_setMining(Boolean dummyValue);

    public String eth_gasPrice();

    public List<String> eth_accounts();

    public long eth_peerCount();

    public BlockData eth_defaultBlock();

    public long eth_number();

    public String eth_balanceAt(String address);

    public String eth_stateAt();

    public String eth_storageAt();

    public String eth_countAt();

    public String eth_codeAt();

    public String eth_transact();

    public String eth_call();

    public BlockData eth_blockByHash(String hash);

    public BlockData eth_blockByNumber(long blockNr);

    public TransactionData eth_transactionByHash(String hash, int nth);

    public TransactionData eth_transactionByNumber(long number, int nth);

    public BlockData eth_uncleByHash(String hash, int nth);

    public BlockData eth_uncleByNumber(long number, int nth);

    public void eth_compilers();

    public void eth_lll();

    public void eth_solidity();

    public void eth_serpent();

    public void eth_newFilter();

    public void eth_newFilterString();

    public void eth_uninstallFilter();

    public void eth_changed();

    public void eth_filterLogs();

    public void eth_logs();

    public void db_put();

    public void db_get();

    public void db_putString();

    public void db_getString();

    public void shh_post();

    public void shh_newIdeninty();

    public void shh_haveIdentity();

    public void shh_newGroup();

    public void shh_addToGroup();

    public void shh_newFilter();

    public void shh_uninstallFilter();

    public void shh_changed();

    public void transact(Object obj);

    public void newFilter(Object obj);

    public void messages(long id);

    public void uninstallFilter(long id);

}
