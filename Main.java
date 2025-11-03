package blockchain;

public class Main {
    public static void main(String[] args) throws Exception {
        BlockChain myChain = new BlockChain();

        System.out.println("Mining block 1...");
        myChain.addBlock(new Block("Transaction 1", ""), 4);

        System.out.println("Mining block 2...");
        myChain.addBlock(new Block("Transaction 2nd", ""), 4);

        System.out.println("Mining block 3...");
        myChain.addBlock(new Block("Transaction 3rd", ""), 4);

        System.out.println("\nBlockchain valid: " + myChain.isChainValid());
    }
}
