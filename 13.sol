// SPDX-License-Identifier: MIT
pragma solidity ^0.8.19;

contract StudentData {
    // Structure to store student details
    struct Student {
        uint256 id;
        string name;
        uint8 age;
        string course;
    }

    // Array to store multiple students
    Student[] public students;

    // Track total number of students
    uint256 public studentCount;

    // Event to notify when a new student is added
    event StudentAdded(uint256 id, string name, uint8 age, string course);

    // Function to add a new student
    function addStudent(uint256 _id, string memory _name, uint8 _age, string memory _course) public {
        students.push(Student(_id, _name, _age, _course));
        studentCount++;
        emit StudentAdded(_id, _name, _age, _course);
    }

    // Function to get student details by index
    function getStudent(uint256 index) public view returns (uint256, string memory, uint8, string memory) {
        require(index < studentCount, "Invalid student index");
        Student memory s = students[index];
        return (s.id, s.name, s.age, s.course);
    }

    // Fallback function - gets called when someone sends Ether or invalid call
    fallback() external payable {
        // This allows the contract to receive Ether
    }

    // Function to check the balance of the contract
    function getBalance() public view returns (uint256) {
        return address(this).balance;
    }
}
