# Social Graph Engine

A Java-based social network graph simulator that models users and manages friendship networks using core data structures and graph algorithms.

## 🚀 Features

- **User Management:** Add, find, and remove users by unique ID with $O(1)$ lookups.
- **Friendships:** Create bidirectional connections and prevent self-loop friendships.
- **Graph Traversals:** Explore the network using Breadth-First Search (BFS) and Depth-First Search (DFS).
- **Smart Recommendations:** Mutual-friend ranking system for friend suggestions.
- **Network Analytics:** Calculate average friend counts, find the most connected user, and detect isolated accounts.

## 🛠️ Tech Stack & Data Structures

- **Language:** Java
- **Data Structures:** `HashMap` (user registry), `HashSet` (visited states), `Queue`/`Stack` (traversals), `ArrayList` (friend lists).

## ⚙️ How to Run

1. Compile all Java files in the project.
2. Run `Main.java`.
3. Follow the interactive command-line menu options (1–9).

## 🔮 Future Improvements
- Graph visualization and GUI interface
- Data persistence (files/database integration)
- Shortest path routing between users
