# 2-4_tree
A 2 - 4 tree is self - balancing data structure commonly used in dictionaries. 2 - 4 trees perform searching, insertion and deletion in the order of O (log n).

Data Structures Used:
To implement 2 – 4 trees we use B –tree data structures. A B-tree is a tree data structure that keeps data sorted and allows searches, insertions, and deletions in logarithmic amortized time.
B-tree nodes have many more than two children. A B-tree node may contain more than just a single element.
A 2 – 4 tree is a self-balancing B – Tree data structure that is commonly used to implement dictionaries.

Run Time Analysis:
1. Every node (leaf or internal) is a 2-node, 3-node or a 4-node, and holds one, two, or three data elements, respectively.
2. All leaves are at the same depth (the bottom level).
3. All data is kept in sorted order.
4. All external nodes are at the same depth.
5. Deletion also takes O (log n) time, assuming transfer and fusion of nodes run in constant time O (1).