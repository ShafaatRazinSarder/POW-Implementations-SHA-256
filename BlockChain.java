package blockchain;
import java.util.ArrayList;

public class BlockChain {
    public ArrayList<Block> chain;  // stores all the blocks

    public BlockChain() {
        chain = new ArrayList<>();
        chain.add(createGenesisBlock());
    }

    //First block is genesis block
    private Block createGenesisBlock() {
        return new Block("Genesis Block", "0");
    }

    public Block getLatestBlock() {
        return chain.get(chain.size() - 1);
    }

    // Add a new block to the chain
    public void addBlock(Block newBlock, int difficulty) throws Exception {
        newBlock.setPreviousHash(getLatestBlock().getHash()); //linking
        newBlock.mineBlock(difficulty);                 //POW
        chain.add(newBlock);
    }

    // Check if the chain is valid
    public boolean isChainValid() throws Exception {
        for (int i = 1; i < chain.size(); i++) {
            Block currentBlock = chain.get(i);
            Block previousBlock = chain.get(i - 1);

            //check for current hash
            if (!currentBlock.getHash().equals(currentBlock.generateHash())) {
                System.out.println("Invalid block hash at index " + i);
                return false;
            }

            //check for previous hash link
            if (!currentBlock.getPreviousHash().equals(previousBlock.getHash())) {
                System.out.println("Invalid previous hash link at index " + i);
                return false;
            }
        }
        return true;
    }
}