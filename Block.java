package blockchain;

import java.time.LocalDateTime;
import java.security.MessageDigest;
import java.nio.charset.StandardCharsets;

public class Block {

    //Info stored in the block
    private String data;
    private String previousHash;
    private String hash;
    private int nonce;
    private LocalDateTime timestamp;


    public Block(String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        this.timestamp = LocalDateTime.now();
        this.nonce = 0;
        this.hash = generateHash();
    }

    //SHA-256 Generation
    public String generateHash() {
        try {
            MessageDigest StringToDigest = MessageDigest.getInstance("SHA-256");

            String textToHash = data + previousHash + timestamp + nonce;
            byte[] hashBytes = StringToDigest.digest(textToHash.getBytes(StandardCharsets.UTF_8));

            //Converts bytes to hex string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public int mineBlock(int difficulty) {
        String target = "0".repeat(difficulty);  // for example, "0000"
        while (!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            hash = generateHash();  // recalculate with new nonce
        }
        System.out.println("Block mined, Hash: " + hash);
        int trials = 0;

        while (!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            hash = generateHash();
            trials++;
        }

        System.out.println("Hash: " + hash);
        System.out.println("Nonce: " + nonce + " Trials: " + trials);
        return trials;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public String getHash() {
        return hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

}


