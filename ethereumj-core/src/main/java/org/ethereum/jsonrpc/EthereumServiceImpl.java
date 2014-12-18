package org.ethereum.jsonrpc;

import org.ethereum.core.Block;
import org.ethereum.core.Transaction;
import org.ethereum.facade.Blockchain;
import org.ethereum.facade.Repository;
import org.ethereum.jsonrpc.model.BlockData;
import org.ethereum.jsonrpc.model.TransactionData;
import org.ethereum.manager.WorldManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongycastle.util.encoders.Hex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class EthereumServiceImpl implements EthereumService {

    private static final Logger logger = LoggerFactory.getLogger("service");

    @Autowired
    private WorldManager worldManager;

    @Autowired
    private Blockchain blockChain;

    @Autowired
    private Repository repository;

    //TODO: Do we really need these dummy values?
    private String coinbase;
    private Boolean listening;
    private Boolean mining;

    @Override
    public String eth_coinbase() {
        //TODO: Find out if eth_coinbase is meant to return the coinbase of latest block
        //or just a value that was set with eth_setCoinbase previously
        if (coinbase == null) {
            long blockChainSize = blockChain.getSize();
            logger.debug("size: " + blockChainSize);
            Block block = blockChain.getBlockByNumber(blockChainSize - 1);
            if (block != null) {
                return "0x" + Hex.toHexString(block.getCoinbase());
            }
            return null;
        } else {
            return coinbase;
        }
    }

    @Override
    public void eth_setCoinbase(String dummyValue) {
        coinbase = dummyValue;
    }

    @Override
    public Boolean eth_listening() {
        return listening;
    }

    @Override
    public void eth_setListening(Boolean dummyValue) {
        listening = dummyValue;
    }

    @Override
    public Boolean eth_mining() {
        return mining;
    }

    @Override
    public void eth_setMining(Boolean dummyValue) {
        mining = dummyValue;
    }

    @Override
    public String eth_gasPrice() {

        //TODO: Where to get this gasPrice from?
        return "0x09184e72a000";
    }

    @Override
    public List<String> eth_accounts() {
        return null;
    }

    @Override
    public long eth_peerCount() {
        //TODO: Find out if this gives always the right number
        return worldManager.getPeerDiscovery().getPeers().size();
    }

    @Override
    public BlockData eth_defaultBlock() {

        //TODO: Do we have a defaultBlock?
        return null;
    }

    @Override
    public long eth_number() {
        return 0;
    }

    @Override
    public BlockData eth_blockByNumber(long blockNr) {
        Block block = blockChain.getBlockByNumber(blockNr);
        if (block != null) {
            return new BlockData(block.getHeader());
        }
        return null;
    }

    @Override
    public TransactionData eth_transactionByHash(String hashString, int nth) {
        byte[] hash = Hex.decode(hashString);
        final Block block = blockChain.getBlockByHash(hash);
        Transaction tx = block.getTransactionsList().get(nth);
        return new TransactionData(tx);
    }

    @Override
    public TransactionData eth_transactionByNumber(long number, int nth) {
        Block block = blockChain.getBlockByNumber(number);
        if (block == null) {
            return null;
        }
        final List<Transaction> transactionsList = block.getTransactionsList();
        if (transactionsList != null) {
            logger.info("tx.list.size: " + transactionsList.size());

            for (Transaction tx : transactionsList) {
                logger.info("tx: " + tx);
            }
            if (transactionsList.size() > nth) {
                return new TransactionData(transactionsList.get(nth));
            }
        }
        return null;
    }

    @Override
    public BlockData eth_uncleByHash(String hashString, int nth) {
        byte[] hash = Hex.decode(hashString);
        final Block block = blockChain.getBlockByHash(hash);
        if (block == null) {
            return null;
        }
        return new BlockData(block.getUncleList().get(nth));
    }

    @Override
    public BlockData eth_uncleByNumber(long number, int nth) {
        Block block = blockChain.getBlockByNumber(number);
        if (block == null) {
            return null;
        }
        return new BlockData(block.getUncleList().get(nth));
    }

    @Override
    public void eth_compilers() {

    }

    @Override
    public void eth_lll() {

    }

    @Override
    public void eth_solidity() {

    }

    @Override
    public void eth_serpent() {

    }

    @Override
    public void eth_newFilter() {

    }

    @Override
    public void eth_newFilterString() {

    }

    @Override
    public void eth_uninstallFilter() {

    }

    @Override
    public void eth_changed() {

    }

    @Override
    public void eth_filterLogs() {

    }

    @Override
    public void eth_logs() {

    }

    @Override
    public void db_put() {

    }

    @Override
    public void db_get() {

    }

    @Override
    public void db_putString() {

    }

    @Override
    public void db_getString() {

    }

    @Override
    public void shh_post() {

    }

    @Override
    public void shh_newIdeninty() {

    }

    @Override
    public void shh_haveIdentity() {

    }

    @Override
    public void shh_newGroup() {

    }

    @Override
    public void shh_addToGroup() {

    }

    @Override
    public void shh_newFilter() {

    }

    @Override
    public void shh_uninstallFilter() {

    }

    @Override
    public void shh_changed() {

    }

    @Override
    public void transact(Object obj) {

    }

    @Override
    public void newFilter(Object obj) {

    }

    @Override
    public void messages(long id) {

    }

    @Override
    public void uninstallFilter(long id) {

    }

    @Override
    public BlockData eth_blockByHash(String hashString) {
        logger.info("hashString: " + hashString);
        byte[] hash = Hex.decode(hashString);
        final Block block = blockChain.getBlockByHash(hash);
        if (block != null) {
            return new BlockData(block.getHeader());
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

    @Override
    public String eth_stateAt() {
        return null;
    }

    @Override
    public String eth_storageAt() {
        return null;
    }

    @Override
    public String eth_countAt() {
        return null;
    }

    @Override
    public String eth_codeAt() {
        return null;
    }

    @Override
    public String eth_transact() {
        return null;
    }

    @Override
    public String eth_call() {
        return null;
    }
}