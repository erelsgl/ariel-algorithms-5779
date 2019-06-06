// A second "hello world" program with an ability to change the status.
pragma solidity ^0.5.9;

contract hello2  {
     string public greeting;
      
     // Events that get logged on the blockchain
     event GreetingChanged(string _greeting);

     constructor(string memory _greeting) public {
         greeting = _greeting;
     }
 
     // Change the greeting message
     function setGreeting(string memory _greeting) public {
         greeting = _greeting;
         
         // Log an event that the greeting message has been updated
         emit GreetingChanged(_greeting);
     }
 
     // Get the greeting message
     function greet() public view returns (string memory _greeting) {
        _greeting = greeting;
     }
}
