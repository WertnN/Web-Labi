fun main(args: Array<String>) {
    val tree = BinaryTree()
        .insert(5)
        .insert(7)
        .insert(3)
        .insert(2)
        .insert(8)
    println(tree.inOrderTraversal()) // [2, 3, 5, 7, 8]
    val deletedTree = tree.delete(3)
    println(deletedTree.inOrderTraversal()) // [2, 5, 7, 8]
    println(tree.search(7)) // Node(value=7, left=null, right=Node(value=8, left=null, right=null))
}