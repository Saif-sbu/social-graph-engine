# social-graph-engine
Social Graph Simulator
Author: Tahmid Saif
Language: Java

Description

A Java-based social network graph simulator that models users and friendships. The project allows users to create accounts, build friendship connections, traverse the social network using graph algorithms, generate friend recommendations, and analyze network statistics.

Features:
1. Add users
2. Find users by ID
3. Remove users
4. Create friendships
5. Breadth-First Search (BFS) traversal
6. Depth-First Search (DFS) traversal
7. Friend recommendation system based on mutual friends
8. Most connected user analysis
9. Friend count analysis
10. Average friend count calculation
11. Detection of isolated users

Data Structures Used:
1. HashMap<Integer, User>
    Stores users by unique ID for efficient lookup.
2. ArrayList
    Stores friendship connections.
3. Queue
    Used for BFS traversal.
4. Stack
    Used for DFS traversal.
5. HashSet
    Tracks visited users during traversals.

Algorithms Used:
Breadth-First Search (BFS)

    Traverses the graph level by level starting from a selected user.

Depth-First Search (DFS)

    Traverses the graph by exploring as deeply as possible before backtracking.

Friend Recommendation Algorithm

    Finds friends-of-friends and ranks recommendations according to the number of mutual connections.

How to Run:
1. Compile all Java files.
2. Run Main.java.
3. Select options from the command-line menu.

Example Usage:
1. Add several users.
2. Create friendships between users.
3. Run BFS or DFS traversal.
4. Generate friend recommendations.
5. View network analytics.

Future Improvements:
1. Graph visualization
2. GUI interface
3. User persistence using files or databases
4. Shortest path between users
5. Community detection algorithms
6. Mutual friend count display in recommendations

## What I Learned
- Object-Oriented Programming in Java
- Graph data structures
- Breadth-First Search (BFS)
- Depth-First Search (DFS)
- HashMaps, HashSets, Queues, and Stacks
- Command-line application development