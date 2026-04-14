Project: Version Control Simulation in Java

Requirements:
- Java JDK installed

How to compile:
`javac Main.java`

How to run:
`java Main`

What the program does:
This program simulates a simple version control system using a doubly linked list.
It saves 3 versions, displays all versions, shows the current version, performs undo
operations, and then performs a redo operation.

Expected output summary:
- Shows Version 1, Version 2, and Version 3
- Shows the current version as Test 3 after saving
- After one undo, the current version becomes Test 2
- After another undo, the current version becomes Test 1
- After redo, the current version becomes Test 2

Notes:
- The program was tested successfully with:
  `javac Main.java`
  `java Main`
