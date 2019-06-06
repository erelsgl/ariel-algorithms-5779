// From: http://www.talkcrypto.org/blog/2018/01/04/hello-world-ethereum-smart-contract/
pragma solidity ^0.5.9;

contract hello1 {  
    // bytes32 - a single word of the EVM - exactly 32 bytes.
    // string  - a dynamic string of UTF-8 chars.  
    function greet() public pure returns (string memory _greeting) {
        _greeting = 'Hello World!';
    }
}

