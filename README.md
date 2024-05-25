# Assignment 4 - Algorithm and Data Structures

This assignment contains implementations of various graph search algorithms in Java.

## Changes from the Initial Implementation

Initially, the project used an `Edge` class to represent edges in the graph. However, in the later stages of development, it was decided to refactor the code to use a `Vertex` class to represent vertices in the graph instead. This change was made to simplify the implementation and improve readability.

Here are the key changes that were made:

1. **Replacement of Edge with Vertex**: The `Edge` class was replaced with the `Vertex` class, which now represents vertices in the graph. Each `Vertex` object contains data associated with the vertex and a map of adjacent vertices along with their weights.

2. **Update in Graph Classes**: The `WeightedGraph` class was updated to work with the `Vertex` class instead of the `Edge` class. It now handles vertices directly and manage adjacency lists accordingly.

3. **Modification of Search Algorithms**: The search algorithm (`DijkstraSearch`) was modified to work with `Vertex` objects instead of `Edge` objects. This involved updating method signatures and logic to operate on vertices and their adjacency lists
