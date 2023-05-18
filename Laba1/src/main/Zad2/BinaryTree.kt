data class Node(
    val value: Int,
    val left: Node? = null,
    val right: Node? = null
)

class BinaryTree(private val root: Node? = null) {

    fun insert(value: Int): BinaryTree {
        val newRoot = insert(root, value)
        return BinaryTree(newRoot)
    }

    private fun insert(node: Node?, value: Int): Node {
        if (node == null) {
            return Node(value)
        }

        return when {
            value < node.value -> {
                val newLeft = insert(node.left, value)
                Node(node.value, newLeft, node.right)
            }
            else -> {
                val newRight = insert(node.right, value)
                Node(node.value, node.left, newRight)
            }
        }
    }

    fun search(value: Int): Node? {
        return search(root, value)
    }

    private fun search(node: Node?, value: Int): Node? {
        if (node == null || node.value == value) {
            return node
        }

        return if (value < node.value)
            search(node.left, value)
        else
            search(node.right, value)
    }

    fun delete(value: Int): BinaryTree {
        val newRoot = delete(root, value)
        return BinaryTree(newRoot)
    }

    private fun delete(node: Node?, value: Int): Node? {
        if (node == null) {
            return node
        }

        when {
            value < node.value -> {
                val newLeft = delete(node.left, value)
                return Node(node.value, newLeft, node.right)
            }
            value > node.value -> {
                val newRight = delete(node.right, value)
                return Node(node.value, node.left, newRight)
            }
            else -> {
                if (node.left == null && node.right == null) {
                    return null
                }
                if (node.left == null && node.right != null) {
                    return node.right
                }
                if (node.left != null && node.right == null) {
                    return node.left
                }
                val (leftMax, newLeft) = removeMax(node.left!!)
                return Node(leftMax, newLeft, node.right)
            }
        }
    }

    private fun removeMax(node: Node): Pair<Int, Node?> {
        if (node.right == null) {
            return Pair(node.value, node.left)
        }
        val (max, newRight) = removeMax(node.right)
        return Pair(max, Node(node.value, node.left, newRight))
    }

    fun inOrderTraversal(): List<Int> {
        val result = mutableListOf<Int>()
        inOrderTraversal(root, result)
        return result
    }

    private fun inOrderTraversal(node: Node?, result: MutableList<Int>) {
        if (node == null) {
            return
        }
        inOrderTraversal(node.left, result)
        result.add(node.value)
        inOrderTraversal(node.right, result)
    }
}