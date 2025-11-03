# POW-Implementations-SHA-256
A simple Proof of Work implementation in Java using SHA-256

This program implements a simple Proof of Work (PoW) algorithm in Java,
using the MessageDigest API to calculate SHA-256 hashes.
The function accepts a message and a difficulty level, then appends different nonce values to the message until the hash begins with the required number of leading zeros.
The program outputs the nonce and the number of trials once a valid hash is found, demonstrating the concept of computational effort behind blockchain mining.
